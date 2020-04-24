package com.xls.zc.http.base;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Sql相关辅助方法<br/>
 * Created by dqw on 2016/04/25.
 */
@Component
public class SqlHelper {

    protected static final Logger logger = Logger.getLogger(SqlHelper.class);

    /**
     * 根据参数Map拼接where字符串，通过字段的不同前缀区分条件类型
     * 字段以"eq_"开头，拼接等于条件
     * 字段以"gt_"开头，拼接大于条件
     * 字段以"lt_"开头，拼接小于条件
     * 字段以"nq_"开头，拼接不等于条件
     * 字段以"lk_"开头，拼接like条件
     * 字段以"in_"开头，拼接in条件
     * <p>
     * 例：
     * HashMap<String, Object> params = new HashMap<>();
     * params.put("eq_categoryId1", categoryId1);
     * params.put("lk_goodsName", '%' + keyword + '%');
     * params.put("in_commonId", commonIdList);
     * String where = SqlHelper.getWhereStringByParams(params);
     *
     * @param params
     * @return
     */
    public static String getWhereStringByParams(Map<String, Object> params) {
        StringBuilder where = new StringBuilder();
        where.append(" where 1=1");

        for (String key : params.keySet()) {
            String type = key.substring(0, 3);
            String field = key.substring(3, key.length());
            switch (type) {
                case "eq_":
                    where.append(" and ");
                    where.append(field);
                    where.append(" = :");
                    where.append(key);
                    break;
                case "gt_":
                    where.append(" and ");
                    where.append(field);
                    where.append(" > :");
                    where.append(key);
                    break;
                case "lt_":
                    where.append(" and ");
                    where.append(field);
                    where.append(" < :");
                    where.append(key);
                    break;
                case "nq_":
                    where.append(" and ");
                    where.append(field);
                    where.append(" != :");
                    where.append(key);
                    break;
                case "lk_":
                    where.append(" and ");
                    where.append(field);
                    where.append(" like :");
                    where.append(key);
                    break;
                case "in_":
                    where.append(" and ");
                    where.append(field);
                    where.append(" in (:");
                    where.append(key);
                    where.append(")");
                    break;
            }
        }
        return where.toString();
    }
}
