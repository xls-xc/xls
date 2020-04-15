package com.xls.fx.util.webservice.jaxrs;

import org.apache.cxf.jaxrs.client.WebClient;
import javax.ws.rs.core.MediaType;
import org.junit.Test;


import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.jaxrs
 * @ClassName: ClientServer
 * @Description: 测试JaxWs 发布的服务  若想事项不能和发布服务的在同一启动工程即（同一tomcat下）
 * @Author: SkyChen
 * @Create: 2020-04-05 15:20
 * @Version: v1.0
 **/
public class ClientServer {
    private static final String CALL_ADDR = "http://localhost:8080/jaxrs";
    private static final String ROOT_MAPPING = "/iPublishService";
    private static final String SUB_MAPPING1 = "/test";

    @Test
    public void testSave() throws UnsupportedEncodingException {
        //通过WebClient对象远程调用服务端


        WebClient.create(CALL_ADDR+ROOT_MAPPING+SUB_MAPPING1)
                .type(MediaType.APPLICATION_JSON) //指定请求的数据格式为json 默认为xml
                .encoding("UTF-8")
                .post("发送的内容");
    }

    @Test
    public void testGet() {
        String user = WebClient.create(CALL_ADDR+ROOT_MAPPING+SUB_MAPPING1 + "/1")
                .type(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("查询到的数据：" + user);
    }

    @Test
    public void testPut() {
                 WebClient.create(CALL_ADDR+ROOT_MAPPING+SUB_MAPPING1)
                .type(MediaType.APPLICATION_JSON)
                .put("修改的内容");
    }

    @Test
    public void testDelete() {
                WebClient.create(CALL_ADDR+ROOT_MAPPING+SUB_MAPPING1 + "/1")
                .type(MediaType.APPLICATION_JSON)
                .delete();
    }
}
