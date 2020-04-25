package com.xls.fx.util.webservice.cxf;


import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.cxf
 * @ClassName: UserServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-15 13:20
 * @Version: v1.0
 **/
@Service("userServiceImpl")
@WebService(serviceName = "userService",//与接口指定的serviceName一致
        targetNamespace="http://cxf.webservice.util.fx.xls.com",//与接口中的命名空间一致
        endpointInterface = "com.xls.fx.util.webservice.cxf.IUserService")//接口地址
public class UserServiceImpl implements IUserService {

    private static Map<String, User> userMap = new HashMap<String, User>();
    static {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("411001");
        user.setUsername("zhansan");
        user.setAge("20");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411002");
        user.setUsername("lisi");
        user.setAge("30");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411003");
        user.setUsername("wangwu");
        user.setAge("40");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);
    }


    @Override
    public String getName(String userId) {
        return "liyd-" + userId;
    }

    @Override
    public User getUser(String userId) {
        System.out.println("userMap是:"+userMap);
        return userMap.get(userId);
    }
}