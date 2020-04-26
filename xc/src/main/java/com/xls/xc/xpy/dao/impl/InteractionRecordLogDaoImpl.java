package com.xls.xc.xpy.dao.impl;

import com.xls.xc.xpy.common.BaseDaoHibernate5;
import com.xls.xc.xpy.dao.IInteractionRecordLogDao;
import com.xls.xc.xpy.vo.XcInteractionLogVo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.dao.impl
 * @ClassName: InteractionRecordLogDaoImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-26 21:37
 * @Version: v1.0
 **/
@Repository
@Transactional(rollbackFor = {Exception.class})
public class InteractionRecordLogDaoImpl extends BaseDaoHibernate5<XcInteractionLogVo> implements IInteractionRecordLogDao  {
    @Override
    public Integer save(XcInteractionLogVo xcInteractionLogVo) throws Exception {
        Serializable serializable = saveEntity(xcInteractionLogVo);
        return Integer.valueOf(serializable.toString());
    }
}
