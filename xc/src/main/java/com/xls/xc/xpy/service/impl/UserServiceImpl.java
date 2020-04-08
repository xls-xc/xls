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
    private ThreadLocal<ResultEntity> resultEntityT = new ThreadLocal<>();

    @Override
    public ResultEntity save(SysUser user)  {

        try {
            Integer save = userDao.save(user);
            return findUserById(save);
        }catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.getEntityError(ResultCode.FAIL,e.toString());
        }

    }

    @Override
    public ResultEntity delete(SysUser user)  {
        resultEntityT.set(ResultEntity.createResultEntity());
        try {
            userDao.delete(user);
            this.resultEntityT.get().setCode(ResultCode.SUCCESS);
            this.resultEntityT.get().setMessage("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            this.resultEntityT.get().setCode(ResultCode.FAIL);
            this.resultEntityT.get().setMessage("删除成功");
        }
        return this.resultEntityT.get();
    }

    @Override
    public ResultEntity update(SysUser user)  {
        try {
            userDao.update(user);
            return ResultEntity.getEntitySuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.getEntityError(ResultCode.FAIL,e.toString());
        }
    }

    @Override
    public ResultEntity findUserById(Integer userId)  {
        try {
            SysUser userById = userDao.findUserById(userId);
            return ResultEntity.getEntitySuccess(userById);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.getEntityError(ResultCode.FAIL,e.toString());
        }
    }

    @Override
    public ResultEntity findAllUser()  {
        try {
            List<SysUser> allUser = userDao.findAllUser();
            return ResultEntity.getEntitySuccess(allUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.getEntityError(ResultCode.FAIL,e.toString());
        }
    }
}
