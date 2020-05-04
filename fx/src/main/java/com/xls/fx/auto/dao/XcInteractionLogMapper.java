package com.xls.fx.auto.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import com.xls.fx.auto.entity.XcInteractionLog;
/**
  * XcInteractionLogMapper 接口
 * @author chenshuaikai
 * @since 2020-05-03
 */
@Repository
@Mapper
public interface XcInteractionLogMapper {

        /**
        * 返回XcInteractionLog表的所有数据
        *  @param query
        *  @return
        */
        List<Map> findAllXcInteractionLog(Map query);

        /**
        * 查询数据总数，方便分页
        * @param query
        * @return
        */
        int getTotalRow(Map query);

        /**
         * 添加XcInteractionLog表数据
         * @param xcInteractionLog
         * @return
         */
        int addXcInteractionLog(XcInteractionLog xcInteractionLog);

       /**
        * 删除XcInteractionLog表指定的数据
        * @param primaryKeyId
        * @return
        */
        int delXcInteractionLogById(Integer primaryKeyId);

        /**
         * 根据XcInteractionLog表的主键id修改表的信息
         * @param xcInteractionLog
         * @return
         */
        int updateXcInteractionLogById(XcInteractionLog xcInteractionLog);
}