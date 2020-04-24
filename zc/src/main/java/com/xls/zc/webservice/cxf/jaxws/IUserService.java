package com.xls.zc.webservice.cxf.jaxws;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.fx.util.webservice.cxf
 * @InterfaceName: IUserService
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-15 13:19
 * @Version: v1.0
 **/
@WebService(name = "iUserService",targetNamespace = "http://jaxws.cxf.webservice.zc.xls.com")
public interface IUserService {

    @WebMethod
    @WebResult(name = "userName")
    String getName(@WebParam(name = "userId") String userId);

    @WebMethod
    String getUser(String userId);
}
