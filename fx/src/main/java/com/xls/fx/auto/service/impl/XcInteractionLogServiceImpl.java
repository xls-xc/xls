package com.xls.fx.auto.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xls.fx.common.RedisHelper;
import com.xls.fx.constant.CacheKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "xcInteractionLogServiceImpl")
public class XcInteractionLogServiceImpl implements XcInteractionLogService {


        @Autowired
        private XcInteractionLogMapper mapper;

        @Autowired
        private RedisHelper redisHelper;

        /**
        * 返回XcInteractionLog表所有数据
        * @return
        */
        @Override
        @Cacheable(value = "findAllXcInteractionLog",key = "#query" )
        public Map<String,Object> findAllXcInteractionLog(Map query) {
            Map map = new HashMap();
            String cacheMap = redisHelper.get(CacheKey.XC_INTERACTION_LOG);
            if(StringUtils.isBlank(cacheMap)) {
                List<Map> dataList = mapper.findAllXcInteractionLog(query);
                int totalRow = mapper.getTotalRow(query);
                map.put("dataList",dataList);
                map.put("totalRow",totalRow);
                redisHelper.set(CacheKey.XC_INTERACTION_LOG, JSON.toJSONString(map),30);
            }else {
                map = JSON.parseObject(cacheMap);
            }

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
