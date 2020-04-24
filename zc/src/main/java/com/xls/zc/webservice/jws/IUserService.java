package com.xls.zc.webservice.jws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.fx.util.webservice.jws
 * @InterfaceName: IUserService
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-16 19:48
 * @Version: v1.0
 **/
@WebService(serviceName="iUserService",targetNamespace="http://jws.webservice.util.fx.xls.com")
public interface IUserService {

  /*  *//**
     *  Java 8 对接口做了进一步的增强。
     * 在接口中可以添加使用 default 关键字修饰的非抽象方法。即：默认方法（或扩展方法）  默认方法可以选择的 是否去实现
     * 接口里可以声明静态方法，并且可以实现。
     *
     * 静态和非public方法不会被自动发布
     * @param requestParam
     * @return
     *//*
    static String staticMethod(String requestParam){
        return "静态方法"+requestParam;
    }*/

    /**
     * 默认修饰的方法 可以被子类实现也可以不实现，但是子类默认方法，即扩展方法可以被webservice发布
     * @return
     */
    default String defaultMethod() {
        return "I'm the defaultMethod";
    }



    @WebMethod(operationName="firstMethod")
    @WebResult(name = "responseInfo")
    String firstMethod(@WebParam(name = "requestParam") String requestParam);

   /**
     * 屏蔽要发布的方法
     * @param requestParam
     * @return
     */
    @WebMethod(exclude=true)
    String excludeMethod(String requestParam);
}
