package com.xls.xc.xpy.service;

import com.xls.xc.xpy.vo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void save() {
        SysUser user = new SysUser();
        user.setUserNo("111");
        userService.save(user);
    }

    @Test
    public void delete() {
        SysUser user = new SysUser();
        user.setUserId(2);
        userService.delete(user);
    }

    @Test
    public void update() {
        SysUser user = new SysUser();
        user.setUserId(2);
        userService.update(user);
    }

    @Test
    public void findUserById() {
        SysUser userById = userService.findUserById(1);
        System.out.println(userById);
    }

    @Test
    public void findAllUser() {
        userService.findAllUser();
    }
}