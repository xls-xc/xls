package com.xls.alike.util;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.alike.util
 * @ClassName: XcJson
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-25 15:00
 * @Version: v1.0
 **/
public class XcJsonUtil {
        /**
         * 将json字符串转为Map对象
         * 如果json复杂，结果可能是map嵌套map
         * @param jsonStr 入参，json格式字符串
         * @return 返回一个map
         */
        public static Map<String, Object> jsonToMap(String jsonStr) {
            Map<String, Object> map = new HashMap<>();
            if(jsonStr != null && !"".equals(jsonStr)){
                //最外层解析
                JSONObject jsonObject = JSONObject.parseObject(jsonStr);
                for (Object k : jsonObject.keySet()) {
                    Object v = jsonObject.get(k);
                    //如果内层还是数组的话，继续解析
                    if (v instanceof JSONArray) {
                        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                        Iterator<Object> iterator = ((JSONArray) v).iterator();
                        while (iterator.hasNext()) {
                            Object next = iterator.next();
                            list.add(jsonToMap(next.toString()));
                        }
                        map.put(k.toString(), list);
                    } else {
                        map.put(k.toString(), v);
                    }
                }
                return map;
            }else{
                return null;
            }
        }



}
