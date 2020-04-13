package com.xls.xc.xpy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.controller
 * @ClassName: LoginController
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-11 14:45
 * @Version: v1.0
 **/
public class LoginController {

    @RequestMapping("/login")
    public String login(ModelMap modelMap, HttpServletResponse response) {
         try {
             Subject subject = SecurityUtils.getSubject();
             subject.login(null);
         }catch (Exception e) {
             e.printStackTrace();
         }
         return null;
    }
}
