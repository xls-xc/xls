package com.xls.xc.xpy.service.impl;

import com.alibaba.fastjson.JSON;
import com.xls.alike.entity.log.XcApproveInteractionLog;
import com.xls.alike.util.HttpClient4Util;
import com.xls.alike.util.TimeUtil;
import com.xls.xc.xpy.common.ResultCode;
import com.xls.xc.xpy.constant.ApproveInterfaceAddrConstant;
import com.xls.xc.xpy.dao.IInteractionRecordLogDao;
import com.xls.xc.xpy.service.IExamineApproveService;
import com.xls.xc.xpy.vo.SysUserRole;
import com.xls.xc.xpy.vo.XcInteractionLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.service.impl
 * @ClassName: ExamineApproveServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-25 14:21
 * @Version: v1.0
 **/
@Service(value = "examineApproveServiceImpl")
public class ExamineApproveServiceImpl implements IExamineApproveService {

    //@Value("#{alike-configProperties['approveAddr']}")
    private String approveAddr;
    private String userChangeRoleApproveUrl = approveAddr + ApproveInterfaceAddrConstant.USER_CHANGE_ROLE_APPROVE;


    @Autowired
    private IInteractionRecordLogDao iInteractionRecordLogDao;

    @Override
    public Boolean userChangeRoleApprove(SysUserRole userRole) {
        userChangeRoleApproveUrl = "http://test.srm.yto.net.cn:9999/web/api/oa/notify";

        Map<String,Object> map = new HashMap<>();
        map.put("flowInstanceId","171b460b9ee2f51998485614a009e0c0");
        map.put("result","5");
        map.put("buissnessType","");

        XcInteractionLogVo xcApproveInteractionLog = new XcInteractionLogVo();
        xcApproveInteractionLog.setSystemName("星辰审批系统");
        xcApproveInteractionLog.setModuleName("星辰（xc)");
        xcApproveInteractionLog.setMenuName("用户管理");
        xcApproveInteractionLog.setRequestUrl(userChangeRoleApproveUrl);
        xcApproveInteractionLog.setClassName(getClass().getName());
        xcApproveInteractionLog.setMenuName(Thread.currentThread().getStackTrace()[1].getMethodName());
        xcApproveInteractionLog.setRequestTime(TimeUtil.getCurrentDate());
        xcApproveInteractionLog.setRequestParam(JSON.toJSONString(map));
        xcApproveInteractionLog.setUserNo("000001");
        xcApproveInteractionLog.setUserCode("000000x1");
        xcApproveInteractionLog.setUserName("admin");
        String s = "";
        try {
            s = HttpClient4Util.doPostJson(userChangeRoleApproveUrl, JSON.toJSONString(map));


            xcApproveInteractionLog.setResponseTime(TimeUtil.getCurrentDate());
            xcApproveInteractionLog.setResponseTimeLong(xcApproveInteractionLog.getResponseTimeLong(xcApproveInteractionLog));
            xcApproveInteractionLog.setResponseParam( JSON.toJSONString(map));
            xcApproveInteractionLog.setResponseCode(ResultCode.SUCCESS);
        }catch (Exception e) {
            xcApproveInteractionLog.setResponseTime(TimeUtil.getCurrentDate());
            xcApproveInteractionLog.setResponseTimeLong(xcApproveInteractionLog.getResponseTimeLong(xcApproveInteractionLog));
            xcApproveInteractionLog.setResponseParam(e.getMessage());
            xcApproveInteractionLog.setResponseCode(ResultCode.SUCCESS);
        }
        try {
            iInteractionRecordLogDao.save(xcApproveInteractionLog);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("日志记录日常");
        }
        return null;
    }

}