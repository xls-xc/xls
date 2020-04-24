package com.xls.zc.webservice.cxf.jaxws;


import com.alibaba.fastjson.JSON;
import com.xls.zc.webservice.entity.User;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
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
@WebService(serviceName = "iUserService",//与接口指定的serviceName一致
        targetNamespace="http://jaxws.cxf.webservice.zc.xls.com",//与接口中的命名空间一致
        endpointInterface = "com.xls.zc.webservice.cxf.jaxws.IUserService")//接口地址
public class UserServiceImpl implements IUserService {

    private static Map<String, User> userMap = new HashMap<String, User>();
    static {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId(1);
        user.setUsername("SkyChen");
        userMap.put(user.getUserId().toString(), user);

        user = new User();
        user.setUserId(2);
        user.setUsername("clement");
        userMap.put(user.getUserId().toString(), user);

        user = new User();
        user.setUserId(3);
        user.setUsername("wangwu");
        userMap.put(user.getUserId().toString(), user);
    }


    @Override
    public String getName(String userId) {
        return "liyd-" + userId;
    }

    @Override
    public String getUser(String userId) {
        System.out.println("userMap"+userMap);
        return JSON.toJSONString(userMap.get(userId));
    }
}
