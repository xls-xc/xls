package com.xls.xc.xpy.service;

import com.xls.xc.xpy.common.ResultEntity;
import com.xls.xc.xpy.vo.SysUser;

import java.util.List;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.xc.xpy.service
 * @InterfaceName: IUserService
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-08 16:50
 * @Version: v1.0
 **/
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    SysUser save(SysUser user);

    /**
     * 删除用户
     * @param user
     * @throws Exception
     */
    Boolean delete(SysUser user);

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    Boolean update(SysUser user);

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     * @throws Exception
     */
    SysUser findUserById(Integer userId);

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<SysUser> findAllUser() ;
}
