package com.xls.xc.xpy.dao;

import com.xls.xc.xpy.vo.SysUser;

import java.util.List;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.xc.xpy.dao
 * @InterfaceName: IUserDao
 * @Description: 用户的数据操作接口
 * @Author: SkyChen
 * @Create: 2020-04-08 16:18
 * @Version: v1.0
 **/
public interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    Integer save(SysUser user) throws Exception;

    /**
     * 删除用户
     * @param user
     * @throws Exception
     */
    void delete(SysUser user) throws Exception;

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    void update(SysUser user) throws Exception;

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     * @throws Exception
     */
    SysUser findUserById(Integer userId) throws Exception;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<SysUser> findAllUser() throws Exception;
}
