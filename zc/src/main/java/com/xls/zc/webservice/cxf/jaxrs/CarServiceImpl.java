package com.xls.zc.webservice.cxf.jaxrs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xls.zc.webservice.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxrs
 * @ClassName: CarServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-16 21:44
 * @Version: v1.0
 **/
public class CarServiceImpl implements ICarService {

    private static Map<String,Object> map = new HashMap<>();
    static{
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
        map.put("data",car);
        System.out.println("初始化数据：" + JSON.toJSONString(map));
    }

    @Override
    public void save(String car) {
        System.out.println("接收到要保存的数据:" + JSON.toJSONString(car));
        System.out.println("接收到要保存的对象:" + JSONObject.parse(car));
    }

    @Override
    public void update(String car) {
        System.out.println("接收到要修改的数据:" + JSON.toJSONString(car));
        System.out.println("接收到要修改的对象:" + JSONObject.parse(car));
    }

    @Override
    public String findAll() {
        return JSON.toJSONString(map);
    }

    @Override
    public String findById(Integer carId) {
        System.out.println("接收到的参数：" + carId);
        return JSON.toJSONString(map);
    }

    @Override
    public void delById(Integer carId) {
        System.out.println("接收到的参数：" + carId);
    }
}
