package com.xls.xc.xpy.controller;

import com.xls.xc.xpy.common.ResultEntity;
import com.xls.xc.xpy.service.UserService;
import com.xls.xc.xpy.vo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class UserController {

    private UserService userService;


    @RequestMapping("/findUserById")
    public ResultEntity findUserById(Integer userId) {
        ResultEntity entitySuccess = ResultEntity.getEntitySuccess();
        userService.findUserById(userId);
        return entitySuccess;
    }

    @RequestMapping("/findAllUser")
    public ResultEntity findAllUser() {
        ResultEntity entitySuccess = ResultEntity.getEntitySuccess();
        userService.findAllUser();
        return entitySuccess;
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public ResultEntity saveUser(SysUser sysUser) {
        ResultEntity entitySuccess = ResultEntity.getEntitySuccess();
        SysUser user = new SysUser();
        user.setDeptNo("111");
        userService.save(user);
        return entitySuccess;
    }

    @RequestMapping("/updateUser")
    public ResultEntity updateUser(SysUser sysUser) {
        ResultEntity entitySuccess = ResultEntity.getEntitySuccess();
        SysUser user = new SysUser();
        user.setUserId(2);
        userService.update(user);
        return entitySuccess;
    }

    @RequestMapping("/deleteUser")
    public ResultEntity deleteUser(SysUser sysUser) {
        ResultEntity entitySuccess = ResultEntity.getEntitySuccess();
        SysUser user = new SysUser();
        user.setUserId(2);
        userService.delete(user);
        return entitySuccess;
    }


}
