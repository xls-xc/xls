package com.xls.xc.xpy.common;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.common
 * @ClassName: BaseDaoHibernate4
 * @Description: Hibernate4 BaseDao
 * 在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,
 * 加上rollbackFor=Exception.class,可以让事物在遇到非运行时异常时也回滚
 * @Author: SkyChen
 * @Create: 2020-03-31 00:26
 * @Version: v1.0
 **/
@Transactional(rollbackFor = {Exception.class})
public class BaseDaoHibernate5<T> {
    protected final Logger logger = Logger.getLogger(getClass());

    @Autowired
    protected SessionFactory sessionFactory;

    /**
     * 查询实体
     * @param entityClass
     * @param id
     * @return
     */
    public T findEntity(Class<T> entityClass, Serializable id) throws Exception{
        return (T) sessionFactory.getCurrentSession().get(entityClass,id);
    }

    /**
     * 查找所有实体
     * @param entityClazz
     * @return
     * @throws Exception
     */
    public List<T> findAllEntity(Class<T> entityClazz) throws Exception{
       String sql = "select en from "+ entityClazz.getSimpleName() + " en";
        return (List<T>) sessionFactory.getCurrentSession().createQuery(sql).list();
    }

    /**
     * 保存实体
     * @param entity
     * @return
     */
    public  Serializable saveEntity(T entity) throws Exception{
       return sessionFactory.getCurrentSession().save(entity);
    }

    /**
     * 更新实体
     * @param entity
     */
    public void updateEntity(T entity) throws Exception{
        sessionFactory.getCurrentSession().update(entity);

    }

    /**
     * 删除实体
     * @param entity
     */
    public void deleteEntity(T entity) throws Exception{
        sessionFactory.getCurrentSession().delete(entity);
    }

    /**
     * 提交事务
     */
    public void commit() throws Exception{
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }
}
