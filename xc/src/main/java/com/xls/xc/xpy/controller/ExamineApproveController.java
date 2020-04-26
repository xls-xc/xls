package com.xls.xc.xpy.controller;

import com.xls.xc.xpy.common.ResultEntity;
import com.xls.xc.xpy.service.IExamineApproveService;
import com.xls.xc.xpy.vo.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.controller
 * @ClassName: ExamineApproveController
 * @Description: 审批控制层
 * @Author: SkyChen
 * @Create: 2020-04-25 14:52
 * @Version: v1.0
 **/
@Controller
@RequestMapping("/examineApproveController")
public class ExamineApproveController {

    @Autowired
    IExamineApproveService iExamineApproveService;

    /**
     * @RequestParam  默认可以接收请求的所有参数
     * @param userRole
     * @return
     */
    @RequestMapping(value = "/userChangeRoleApproveParam",method = RequestMethod.PUT)
    @ResponseBody
    public ResultEntity userChangeRoleApprove(@RequestParam(value = "userRole") String userRole) {
        return ResultEntity.getEntitySuccess();
    }

    /**
     * @RequestBody 使json数据和实体进行自动映射
     * @param userRole
     * @return
     */
    @RequestMapping(value = "/userChangeRoleApprove",method = RequestMethod.PUT)
    @ResponseBody
    public ResultEntity userChangeRoleApprove(@RequestBody SysUserRole userRole) {
        Boolean isUserChangeRoleApprove = iExamineApproveService.userChangeRoleApprove(userRole);
        return ResultEntity.getEntitySuccess();
    }

}
