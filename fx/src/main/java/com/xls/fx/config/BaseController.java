package com.xls.fx.config;

import com.baomidou.mybatisplus.plugins.Page;
import com.xls.fx.config.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.controller
 * @ClassName: BaseController
 * @Description: 基础Controller
 * @Author: SkyChen
 * @Create: 2020-04-28 13:41
 * @Version: v1.0
 **/
public abstract class BaseController {


    protected Logger logger = LoggerFactory.getLogger(getClass());

    public <T> Page<T> getPage(int current, int size, String sort, String order){
        Page<T> page = new Page<T>(current, size, sort);
        if ("desc".equals(order)) {
            page.setAsc(false);
        } else {
            page.setAsc(true);
        }
        return page;
    }

    public <T> PageInfo pageToPageInfo(Page<T> page) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setRecords(page.getRecords());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setOrderByField(page.getOrderByField());
        pageInfo.setIsAsc(page.isAsc());
        return pageInfo;
    }


    public Boolean isAsc(String sort) {
        if ("asc".equals(sort)) {
           return true;
        }
        return false;
    }
}
