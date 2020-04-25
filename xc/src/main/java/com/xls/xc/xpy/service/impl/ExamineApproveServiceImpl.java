package com.xls.xc.xpy.service.impl;

import com.xls.alike.util.HttpClient4Util;
import com.xls.xc.xpy.service.IExamineApproveService;
import com.xls.xc.xpy.vo.SysUserRole;
import org.springframework.stereotype.Service;

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
    @Override
    public Boolean userChangeRoleApprove(SysUserRole oldUserRole, SysUserRole newUserRole) {
        HttpClient4Util.doPostJson(null,null);
        return null;
    }
}
