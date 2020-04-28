package com.xls.fx.service;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.service
 * @ClassName: IExpressQueryService
 * @Description: 快递查询业务类接口 该webservice接口基于jws实现
 * @Author: SkyChen
 * @Create: 2020-04-03 21:37
 * @Version: v1.0
 **/
@Service
@WebService(name = "expressQueryService",targetNamespace = "http://service.fx.xls.com")
public interface IExpressQueryService {

    /**
     * 快递的即使查询
     * @param selectInfo 参数名  expressInfo 返回值的名
     * @return 返回类型为json字符串（注：webservice可以处理String 基本数据类型，普通POJO、list 数组 别的类型不匹配）
     */
    @WebMethod
    @WebResult(name = "expressInfo")
    String selectExpressInfo(@WebParam(name = "selectInfo") String selectInfo);
}
