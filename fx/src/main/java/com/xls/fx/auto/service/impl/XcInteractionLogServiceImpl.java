package com.xls.fx.auto.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xls.fx.auto.entity.XcInteractionLog;
import com.xls.fx.auto.dao.XcInteractionLogMapper;
import com.xls.fx.auto.service.XcInteractionLogService;

/**
 * XcInteractionLog 业务接口实现类
 * @author chenshuaikai
 * @since 2020-05-03
 */
@Service
public class XcInteractionLogServiceImpl implements XcInteractionLogService {


        @Autowired
        private XcInteractionLogMapper mapper;

        /**
        * 返回XcInteractionLog表所有数据
        * @return
        */
        @Override
        public Map<String,Object> findAllXcInteractionLog(Map query) {
            List<Map> dataList = mapper.findAllXcInteractionLog(query);
            int totalRow = mapper.getTotalRow(query);
            Map map = new HashMap();
            map.put("dataList",dataList);
            map.put("totalRow",totalRow);
            return map;
        }

        /**
        * 添加XcInteractionLog表数据
        */
        @Override
        public Map<String,Object> addXcInteractionLog(XcInteractionLog xcInteractionLog) {
            int addResult = mapper.addXcInteractionLog(xcInteractionLog);
            Map<String,Object> resutlMap = new HashMap<String,Object>();
            if(addResult>0) {
            resutlMap.put("code",true);
            return resutlMap;
            }
            resutlMap.put("code",false);
            return resutlMap;
        }


        /**
         * 删除XcInteractionLog表指定的数据
         */
        @Override
        public Map<String,Object>delXcInteractionLogById(Integer primaryKeyId) {
            int addResult = mapper.delXcInteractionLogById(primaryKeyId);
            Map<String,Object> resutlMap = new HashMap<String,Object>();
            if(addResult>0) {
            resutlMap.put("code",true);
            return resutlMap;
            }
            resutlMap.put("code",false);
            return resutlMap;
        }

        /**
         * 根据XcInteractionLog表的主键id修改表的信息
         */
        @Override
        public Map<String,Object> updateXcInteractionLogById(XcInteractionLog xcInteractionLog) {
            int addResult = mapper.updateXcInteractionLogById(xcInteractionLog);
            Map<String,Object> resutlMap = new HashMap<String,Object>();
            if(addResult>0) {
            resutlMap.put("code",true);
            return resutlMap;
            }
            resutlMap.put("code",false);
            return resutlMap;
        }
}
