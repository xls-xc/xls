package com.xls.xc.xpy.controller;

import com.xls.xc.xpy.common.ResultEntity;
import com.xls.xc.xpy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.controller
 * @ClassName: SysUserController
 * @Description: 系统用户有关的配置（用户的增删改查）
 * @Author: SkyChen
 * @Create: 2020-04-08 16:16
 * @Version: v1.0
 **/
@Controller
@RequestMapping("/user")
public class SysUserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/findUserById")
    public ResultEntity findUserById(Integer userId) {
        ResultEntity entitySuccess = ResultEntity.getEntitySuccess();
        userService.findUserById(userId);
        return entitySuccess;
    }


}
