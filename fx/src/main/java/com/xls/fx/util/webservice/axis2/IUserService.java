package com.xls.fx.util.webservice.axis2;



/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.fx.util.webservice.cxf
 * @InterfaceName: IUserService
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-15 13:19
 * @Version: v1.0
 **/
public interface IUserService {


    String getName( String userId);
    User getUser(String userId);
}
