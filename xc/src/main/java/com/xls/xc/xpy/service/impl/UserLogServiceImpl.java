package com.xls.xc.xpy.service.impl;

import com.xls.xc.xpy.util.ObjectChangeValueTool;
import com.xls.xc.xpy.dao.UserLogDao;
import com.xls.xc.xpy.service.UserLogService;
import com.xls.xc.xpy.vo.UserLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.service.impl
 * @ClassName: IGlobalLogServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-03-31 13:42
 * @Version: v1.0
 **/
@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    UserLogDao userLogDao;
    @Autowired
    HibernateTransactionManager transactionManager;
    /**
     * 查询实体
     * @param logId
     * @return
     */
    @Override
    public UserLogVo getUserLogVoById(Integer logId){
        UserLogVo userLogVo = null;
        try {
            userLogVo = userLogDao.findUserLogVoById(logId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLogVo;
    }


    /**
     * 增加一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    @Override
    public UserLogVo saveUserLogVo(UserLogVo userLogVo) {
       try {
           Integer logId = userLogDao.saveUserLogVo(userLogVo);
           userLogVo.setLogId(logId);
       } catch (Exception e) {
            e.printStackTrace();
            return null;
       }
        return userLogVo;
    }


    /**
     * 修改一个UserLogVo实体
     * @param newUserLogVo
     * @return
     */
    @Override
    public UserLogVo updateUserLogVo(UserLogVo newUserLogVo) {
        UserLogVo userLogVo = null;
        try {

            UserLogVo   oldUserLogVo = userLogDao.findUserLogVoById(newUserLogVo.getLogId());
            userLogVo = ObjectChangeValueTool.changeAllValue(UserLogVo.class,oldUserLogVo, newUserLogVo);
            userLogDao.updateUserLogVo(userLogVo);
            userLogVo = userLogDao.findUserLogVoById(userLogVo.getLogId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLogVo;
    }


    /**
     * 删除一个UserLogVo实体
     * @param userLogVo
     * @return
     */
    @Override
    public boolean deleteUserLogVo(UserLogVo userLogVo) {
         try {
             userLogDao.deleteUserLogVo(userLogVo);
         } catch (Exception e) {

         }
        return true;
    }
}
