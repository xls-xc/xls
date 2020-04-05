package com.xls.fx.webservice.jaxrs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.webservice.jaxrs
 * @ClassName: iPublishServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-05 14:52
 * @Version: v1.0
 **/
public class PublishServiceImpl implements iPublishService {
    @Override
    public void saveParam(String saveParam) {
        System.out.println("保存"+saveParam);
    }

    @Override
    public void updateParam(String updateParam) {
        System.out.println("修改"+updateParam);
    }

    @Override
    public List<String> findAllParams() {
        List<String> allParams = new ArrayList<>();
        allParams.add("1");
        allParams.add("2");
        allParams.add("3");
        allParams.add("4");
        return allParams;
    }

    @Override
    public String findParamById(Integer id) {
        return "return:"+id;
    }

    @Override
    public void delParamById(Integer id) {
        System.out.println("删除：" + id);
    }
}
