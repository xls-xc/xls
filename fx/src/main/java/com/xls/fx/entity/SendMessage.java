package com.xls.fx.entity;

import lombok.Data;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.entity
 * @ClassName: SendMessage
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-13 16:47
 * @Version: v1.0
 **/
@Data
public class SendMessage {
    private String number = "";
    private String title = "";
    private String content = "";
    private int sendType = 0;
}
