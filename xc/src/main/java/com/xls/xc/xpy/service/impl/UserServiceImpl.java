package com.xls.xc.xpy.service.impl;

import com.xls.xc.xpy.common.ResultCode;
import com.xls.xc.xpy.common.ResultEntity;
import com.xls.xc.xpy.dao.UserDao;
import com.xls.xc.xpy.service.UserService;
import com.xls.xc.xpy.vo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.service.impl
 * @ClassName: UserServiceImpl
 * @Description: 用户的实现类
 * @Author: SkyChen
 * @Create: 2020-04-08 16:53
 * @Version: v1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Autowired
    public void setUserDao (UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 防止全局变量引起并发
     */
    private ThreadLocal<Boolean> resultSign = new ThreadLocal<>();

    @Override
    public SysUser save(SysUser user)  {

        try {
            Integer save = userDao.save(user);
            user.setUserId(save);
        }catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }

    @Override
    public Boolean delete(SysUser user)  {
        this.resultSign.set(false);
        try {
            userDao.delete(user);
            this.resultSign.set(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.resultSign.get();
    }

    @Override
    public Boolean update(SysUser user)  {
        Boolean sign = false;
        try {
            userDao.update(user);
            sign = true;
        } catch (Exception e) {
            e.printStackTrace();
            sign = false;
        }
        return sign;
    }

    @Override
    public SysUser findUserById(Integer userId)  {
        SysUser user = null;
        try {
             user = userDao.findUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public SysUser findUserByAccount(String account) {
        SysUser user = new SysUser();
        user.setUserName("1");
        //1是启用状态
        user.setStatus(1);
        return user;
    }

    @Override
    public List<SysUser> findAllUser()  {
        List<SysUser> allUser = null;
        try {
            allUser = userDao.findAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUser;
    }
}
