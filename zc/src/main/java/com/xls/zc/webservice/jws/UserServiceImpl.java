package com.xls.zc.webservice.jws;


import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.jws
 * @ClassName: UserServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-16 19:53
 * @Version: v1.0
 **/
@WebService(serviceName="iUserService",//与接口指定的serviceName一致
        targetNamespace="http://jws.webservice.util.fx.xls.com",//与接口中的命名空间一致
        endpointInterface = "com.xls.zc.webservice.jws.IUserService"//接口地址
)
public class UserServiceImpl implements IUserService{

    public String firstMethod(String requestParam) {
        return " I'm the firstMethod";
    }

     /**
     * 屏蔽要发布的方法
     * @param requestParam
     * @return
     */
    @WebMethod(exclude=true)
    public String excludeMethod(String requestParam) {
        return " I'm the excludeMethod";
    }


}
