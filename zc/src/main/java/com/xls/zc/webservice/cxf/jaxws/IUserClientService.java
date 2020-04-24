package com.xls.zc.webservice.cxf.jaxws;

import com.xls.zc.webservice.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxws
 * @InterfaceName: IUserClientService
 * @Description: 要调用的远程发布接口，开发需要和发布端获取
 * @Author: SkyChen
 * @Create: 2020-04-17 17:16
 * @Version: v1.0
 **/

@WebService(name = "iUserService",targetNamespace = "http://jaxws.cxf.webservice.zc.xls.com")
public interface IUserClientService {
    @WebMethod
    @WebResult(name = "userName")
    String getName(@WebParam(name = "userId")String userId);
    String getUser(String userId);
}
