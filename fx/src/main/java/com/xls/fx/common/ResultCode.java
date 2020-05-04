package com.xls.fx.common;

/**
 * @ProjectName: xc (星辰)
 * @PackageName: com.xls.xpy.entity
 * @ClassName: ResultCode
 * @Description: 状态码
 * @Author: SkyChen
 * @Create: 2020-03-31 14:44
 * @Version: v1.0
 **/
public interface ResultCode {


    /**
     * 成功状态吗
     */
    Integer SUCCESS = 200;



    /**
     * 失败
     */
    Integer FAIL = 400;


    /**
     * 参数异常
     */
    Integer PARAM_ERROR = 1001;

    /**
     * 参数为空
     */
    Integer PARAM_NULL = 1002;

    /**
     * 操作成功
     */
    Integer PARAM_OPERATION_SUCCESS=1003;

    /**
     * 操作失败
     */
    Integer PARAM_OPERATION_ERROR = 1004;


}
