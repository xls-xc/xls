package com.xls.fx.entity;

import lombok.*;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.entity
 * @ClassName: SmsMessage
 * @Description: 消息模板实体类
 * @Author: SkyChen
 * @Create: 2020-04-13 14:59
 * @Version: v1.0
 **/
@Data
public class SmsMessage {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private String id;

    /**
     * 业务系统的短信ID
     */
    private String smsId;

    /**
     * 电话号码
     */
    private String phoneNumber;
    /**
     * 短信内容
     */
    private String content;		
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 短信业务类型
     */
    private String businessType;
    /**
     * 短信供应商编号
     */
    private String customerNo;
    /**
     * 创建网点
     */
    private String createOrgCode;
    /**
     * 创建人
     */
    private String createUserCode;
    /**
     * 短信内容条数
     */
    private int sectionCount;
    /**
     * 备注
     */
    private String remark;
    private String scankey;
    private String translateType;
    /**
     * 派件员手机号码：可以换成它deliveryman
     */
    private String sendTel;

}
