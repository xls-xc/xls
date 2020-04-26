package com.xls.alike.util;

import com.alibaba.fastjson.JSON;
import com.xls.alike.constant.ApproveInterfaceAddrConstant;
import com.xls.alike.entity.log.XcApproveInteractionLog;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.alike.util
 * @ClassName: InteractionRecordLogUtil
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-25 17:34
 * @Version: v1.0
 **/
public class InteractionRecordLogUtil {

    /**
     * 星辰审批交互地址
     */
    @Value("#{aplike-config.properties['approveAddr']}")
    private static String approveAddr;
    private static String userChangeRoleApproveUrl = approveAddr + ApproveInterfaceAddrConstant.USER_CHANGE_ROLE_APPROVE;

    /**
     * 记录星辰系统审批交互日志
     */
   /* public static<T> void recordExamineApproveLog(Class<T> entityClass) {
        XcApproveInteractionLog xcApproveInteractionLog = new XcApproveInteractionLog();
        xcApproveInteractionLog.setSystemName("星辰审批系统");
        xcApproveInteractionLog.setModuleName("星辰（xc)");
        xcApproveInteractionLog.setMenuName("用户管理");
        xcApproveInteractionLog.setRequestUrl(userChangeRoleApproveUrl);
        xcApproveInteractionLog.setClassName(xcApproveInteractionLog.getClass().getName());
        xcApproveInteractionLog.setMenuName(Thread.currentThread().getStackTrace()[2].getMethodName());
        xcApproveInteractionLog.setRequestTime(TimeUtil.getCurrentDate());
        xcApproveInteractionLog.setRequestParam(JSON.toJSONString(userRole));

    }*/
}
