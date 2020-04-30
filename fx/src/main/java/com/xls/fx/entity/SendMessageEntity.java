package com.xls.fx.entity;

import lombok.Data;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.entity
 * @ClassName: SendMessageEntity
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-30 10:52
 * @Version: v1.0
 **/
@Data
public class SendMessageEntity {
    private String number = "";
    private String title = "";
    private String content = "";
    private int sendType = 0;
}
