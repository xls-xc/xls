package com.xls.xc.xpy.dao;

import com.xls.xc.xpy.vo.XcInteractionLogVo;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.xc.xpy.dao
 * @InterfaceName: IInteractionRecordLogDao
 * @Description: 交互日志记录数据接口
 * @Author: SkyChen
 * @Create: 2020-04-26 21:35
 * @Version: v1.0
 **/
public interface IInteractionRecordLogDao {
    Integer save(XcInteractionLogVo xcInteractionLogVo) throws Exception;
}
