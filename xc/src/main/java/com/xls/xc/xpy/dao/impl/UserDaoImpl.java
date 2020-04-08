package com.xls.xc.xpy.dao.impl;

import com.xls.xc.xpy.common.BaseDaoHibernate5;
import com.xls.xc.xpy.dao.UserDao;
import com.xls.xc.xpy.util.HostInformationTool;
import com.xls.xc.xpy.vo.SysUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.dao.impl
 * @ClassName: UserDaoImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-08 16:25
 * @Version: v1.0
 **/
@Repository
@Transactional(rollbackFor = {Exception.class})
public class UserDaoImpl extends BaseDaoHibernate5<SysUser> implements UserDao {

    @Override
    public Integer save(SysUser user) throws Exception {
        user.setCreateTime(HostInformationTool.getCurrentTimestamp());
        Serializable serializable = saveEntity(user);
        return Integer.valueOf(serializable.toString());
    }

    @Override
    public void delete(SysUser user) throws Exception {
        deleteEntity(user);
    }

    @Override
    public void update(SysUser user) throws Exception {
        updateEntity(user);
    }

    @Override
    public SysUser findUserById(Integer userId) throws Exception {
        return findEntity(SysUser.class,userId);
    }

    @Override
    public List<SysUser> findAllUser() throws Exception {
        return findAllEntity(SysUser.class);
    }
}
