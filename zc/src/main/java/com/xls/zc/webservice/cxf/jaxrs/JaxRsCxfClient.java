package com.xls.zc.webservice.cxf.jaxrs;

import com.alibaba.fastjson.JSON;
import com.xls.zc.webservice.entity.User;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxrs
 * @ClassName: JaxRsCxfClient
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-16 22:03
 * @Version: v1.0
 **/
public class JaxRsCxfClient {
    private static final String CALL_ADDR="http://localhost:8080/cxf/jaxrs";
    private static final String ROOT_MAPPING = "/iCarService";
    private static final String SUB_MAPPING1 = "/car";
    private static final String ALL_ADDR = CALL_ADDR+ROOT_MAPPING+SUB_MAPPING1;

    private String getData() {
        Car car = new Car();
        car.setCarId(1);
        car.setCarName("es");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUsername("zhangsan");
        car.getUsers().add(user1);

        User user2 = new User();
        user2.setUserId(1);
        user2.setUsername("lisi");
        car.getUsers().add(user2);

        System.out.println("初始化数据：" + JSON.toJSONString(car));
        return JSON.toJSONString(car);
    }

    @Test
    public void testSave() throws UnsupportedEncodingException {
        //通过WebClient对象远程调用服务端
        Response response = WebClient.create(ALL_ADDR)
                .type(MediaType.APPLICATION_JSON) //指定请求的数据格式为json 默认为xml
                .encoding("UTF-8")
                .post(getData());
        System.out.println("post响应信息："+response);
    }

    @Test
    public void testGet() {
        String s = WebClient.create(ALL_ADDR)
                .type(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("get查询到的数据：" + s);
    }

    @Test
    public void testGetById() {
        String s = WebClient.create(ALL_ADDR+"/1")
                .type(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("getById查询到的数据：" + s);
    }

    @Test
    public void testPut() {
        Response put = WebClient.create(ALL_ADDR)
                .type(MediaType.APPLICATION_JSON)
                .put(getData());
        System.out.println("Put响应信息:" + put);
    }

    @Test
    public void testDelete() {
        Response delete = WebClient.create(ALL_ADDR + "/1")
                .type(MediaType.APPLICATION_JSON)
                .delete();
        System.out.println("Delete响应信息" + delete);
    }
}
