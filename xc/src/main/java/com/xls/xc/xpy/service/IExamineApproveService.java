package com.xls.xc.xpy.service;

import com.xls.xc.xpy.vo.SysUserRole;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.xc.xpy.service
 * @InterfaceName: IExamineApproveService
 * @Description: 审批接口
 * @Author: SkyChen
 * @Create: 2020-04-25 13:25
 * @Version: v1.0
 **/
public interface IExamineApproveService {

    /**
     * 用户角色转变审批
     * @param oldUserRole
     * @param newUserRole
     * @return
     */
    Boolean userChangeRoleApprove(SysUserRole oldUserRole,SysUserRole newUserRole);
}
