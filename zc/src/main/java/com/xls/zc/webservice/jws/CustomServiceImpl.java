package com.xls.zc.webservice.jws;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.jws
 * @ClassName: UserServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-16 19:53
 * @Version: v1.0
 **/
@WebService(serviceName="CustomServiceImpl",targetNamespace="http://jws.webservice.util.fx.xls.com")
public class CustomServiceImpl {

    public String firstMethod(String requestParam) {
        return " I'm the firstMethod";
    }

    @WebMethod(operationName="customSecondMethod")
    @WebResult(name = "responseInfo")
    public String secondMethod(@WebParam(name="requestParam")String requestParam) {
        return " I'm the firstMethod";
    }

    /**
     * 私有方法不会被自动发布
     * @param requestParam
     * @return
     */
    private String privateMethod(String requestParam) {
        return " I'm the private method ";
    }

    /**
     * 静态方法 不会被发布
     * @param requestParam
     * @return
     */
    public static String staticMethod(String requestParam){
        return "  I'm the staticMethod  ";
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



    public static void main(String[] args) {

        //implementor要发布的对象，一般是接口的实现类
        String address="http://127.0.0.1/CustomServiceImpl?WSDL";
        Endpoint point = Endpoint.publish(address, new CustomServiceImpl());
        System.out.println("WebService发布成功，地址为：" + address);
        //关闭发布
        //point.stop();
    }
}
