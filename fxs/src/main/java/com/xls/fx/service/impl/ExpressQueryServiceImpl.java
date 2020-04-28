package com.xls.fx.service.impl;

import com.xls.fx.service.IExpressQueryService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.service.impl
 * @ClassName: IExpressQueryServiceImpl
 * @Description: 该webservice接口基于jws实现
 * @Author: SkyChen
 * @Create: 2020-04-03 21:50
 * @Version: v1.0
 *   serviceName = "expressQueryService",//与接口指定的serviceName一致
 *   targetNamespace = "http://service.fx.xls.com",//与接口中的命名空间一致
 *   endpointInterface = "com.xls.fx.service.IExpressQueryService")//接口地址
 **/
@Service
@WebService(
        serviceName = "expressQueryService",//与接口指定的serviceName一致
        targetNamespace = "http://service.fx.xls.com",//与接口中的命名空间一致
        endpointInterface = "com.xls.fx.service.IExpressQueryService")//接口地址
public class ExpressQueryServiceImpl implements IExpressQueryService {
    @Override
    public String selectExpressInfo(String selectInfo) {
        System.out.println("请求信息:" + selectInfo);
        return "返回的响应信息!";
    }
}
