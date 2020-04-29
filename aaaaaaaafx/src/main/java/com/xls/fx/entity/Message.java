package com.xls.fx.entity;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.entity
 * @ClassName: Message
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-14 19:32
 * @Version: v1.0
 **/
@Data
public class Message {

    private int id;
    private String appCode;
    private String appSmsId;
    private String mobile;
    private String nonce;
    private String orgCode;
    private String userCode;
    private List<String> params;
    private String sign;
    private String templateCode;
    private Long timestamp;

}
