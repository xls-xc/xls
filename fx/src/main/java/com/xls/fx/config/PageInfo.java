package com.xls.fx.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.config
 * @ClassName: PageInfo
 * @Description: 分页类
 * @Author: SkyChen
 * @Create: 2020-04-28 13:46
 * @Version: v1.0
 **/
@Data
public class PageInfo <T> implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;


    /**
     * 默认显示的记录数
     */
    private final static int PAGE_SIZE = 10;

    /**
     * 总条数
     */
    private int total;

    /**
     * 显示的条数
     */
    private List records;

    /**
     * 在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响
     * 如果注解失效，可能是因为你使用的是fastJson，尝试使用对应的注解来忽略字段，注解为：@JSONField(serialize = false)，使用方法一样。
     *
     * 开始查询条数
     */
    @JsonIgnore
    private int startNum;
    /**
     * 结束查询条数
     */
    @JsonIgnore
    private int endNum;
    /**
     * 当前页
     */
    @JsonIgnore
    private int currentPage = 1;
    /**
     * 每页显示的记录数
     */
    @JsonIgnore
    private int pageSize = 10;

    /**
     * 查询条件
     */
    @JsonIgnore
    private Map<String, Object> condition;

    /**
     * 排序字段
     */
    @JsonIgnore
    private String orderByField = "seq";

    /**
     * 排序类型 asc，desc  默认正序 false desc 正序
     */
    @JsonIgnore
    private Boolean isAsc = false;

    public PageInfo() {}

    /**
     * 根据页码和显示条数查询数据
     * @param currentPage 页码
     * @param pageSize 显示条数
     */
    public PageInfo(Integer currentPage, Integer pageSize) {
        if(currentPage==null){
            currentPage = 1;
        }

        if(pageSize==null) {
            pageSize = 10;
        }

        //计算当前页
        if (currentPage < 0) {
            this.currentPage = 1;
        } else {
            //当前页
            this.currentPage = currentPage;
        }
        //记录每页显示的记录数
        if (pageSize < 0) {
            this.pageSize = PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
        //计算开始的记录和结束的记录
        this.startNum = (this.currentPage - 1) * this.pageSize;
        this.endNum = this.pageSize;
    }

    /**
     * 根据页码 显示条数 正序 倒序 排序字段查询
     * @param currentPage 页码
     * @param pageSize 显示条数
     * @param isAsc true 为正序 false为倒序
     * @param orderByField 排序字段
     */
    public PageInfo(Integer currentPage, Integer pageSize, Boolean isAsc, String orderByField) {
        this(currentPage, pageSize) ;
        // 排序字段，正序还是倒序
        this.isAsc = isAsc;
        this.orderByField = orderByField;
    }
    
}
