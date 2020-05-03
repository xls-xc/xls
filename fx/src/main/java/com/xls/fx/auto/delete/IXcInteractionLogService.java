package com.xls.fx.auto.delete;


import java.util.List;
import java.util.Map;
import com.xls.fx.auto.delete.XcInteractionLog;

/**
 * XcInteractionLog 业务接口
 * @author chenhusikai
 * @since 2020-05-03
 */

public interface IXcInteractionLogService {

    /**
     *  返回XcInteractionLog表的所有数据
     *  @param query
     *  @return
     */
    Map<String,Object> findAllXcInteractionLog(Map query);

    /**
    * 添加XcInteractionLog表数据
     * @param xcInteractionLog
     * @return
    */
    Map<String,Object> addXcInteractionLog(XcInteractionLog xcInteractionLog);

    /**
     * 删除XcInteractionLog表指定的数据
     * @param primaryKeyId
     * @return
     */
    Map<String,Object>delXcInteractionLogById(Integer primaryKeyId);

    /**
     * 根据XcInteractionLog表的主键id修改表的信息
     * @param xcInteractionLog
     * @return
     */
    Map<String,Object> updateXcInteractionLogById(XcInteractionLog xcInteractionLog);
}