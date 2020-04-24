package com.xls.zc.webservice.axis2;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.axis2
 * @ClassName: client
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-22 20:12
 * @Version: v1.0
 **/
public class client {

    private static String url = "http://localhost:8080/zc/services/businessService?wsdl";

    public static void main(String[] args) throws Exception
    {
        //  使用RPC方式调用WebService
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        //  指定调用WebService的URL
        EndpointReference targetEPR = new EndpointReference(url);

        options.setTo(targetEPR);
        //  指定方法的参数值
        Object[] opAddEntryArgs = new Object[] {"hello world!"};
        //  指定方法返回值的数据类型的Class对象
        Class[] classes = new Class[] {String.class};
        //  指定要调用的方法及WSDL文件的命名空间，QName指定了要调用的方法名，其中第一个参数为wsdl文件命名空间，填入wsdl:definitions 后跟的内容
        QName opAddEntry = new QName("http://axis2.webservice.zc.xls.com", "greek");
        //  调用方法并输出该方法的返回值,invokeBlocking第一个参数为QName指定调用方法名，第二个为参数类型，第三个为返回值类型的Class对象
        System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
    }
}
