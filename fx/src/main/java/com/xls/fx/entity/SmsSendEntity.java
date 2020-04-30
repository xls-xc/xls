package com.xls.fx.entity;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.entity
 * @ClassName: SmsSendEntity
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-30 09:16
 * @Version: v1.0
 **/
@Data
public class SmsSendEntity {
    /**
     * 短信平台appCode
     */
    private String appCode;

    /**
     * 短信id UUID
     */
    private String appSmsId;

    /**
     * 发送手机号
     */
    private String mobile;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 短信平台组织编码
     */
    private String orgCode;

    /**
     * 签名
     */
    private String sign;

    /**
     * 短信平台配置模板编码
     */
    private String templateCode;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 参数：短信内容
     */
    private List<String> params;
}
