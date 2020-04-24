package com.xls.fx.util.webservice.jaxrs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.jaxrs
 * @ClassName: iPublishServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-05 14:52
 * @Version: v1.0
 **/
public class JaxRsServiceImpl implements IJaxRsService {
    @Override
    public void saveParam(String saveParam) {
        System.out.println("保存"+saveParam);
    }

    @Override
    public void updateParam(String updateParam) {
        System.out.println("修改"+updateParam);
    }

    @Override
    public List<User> findAllParams() {
        List<User> users = new ArrayList<>();
        User user = new User();
        users.add(user);
        return users;
    }

    @Override
    public User findParamById(Integer id) {
        User user = new User();
        user.setUserId("1");
        return user;
    }

    @Override
    public void delParamById(Integer id) {
        System.out.println("删除：" + id);
    }
}
