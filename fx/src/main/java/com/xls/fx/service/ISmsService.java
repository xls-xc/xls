package com.xls.fx.service;

import com.xls.fx.entity.SmsSendEntity;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.fx.service
 * @InterfaceName: ISmsService
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-30 09:15
 * @Version: v1.0
 **/
public interface ISmsService {

    /**
     * 生成指定长度的随机数字符串
     * @param length
     * @return
     */
    static String generateRandomNumber(int length) {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        //有可能是负数
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        StringBuffer code = new StringBuffer(String.valueOf(hashCodeV));
        //如果hashcode位数不够，则在后面拼随机数
        String number = (new BigDecimal(((Math.random() * 9 + 1) * Math.pow(10, length - code.length() - 1)))).toString().substring(0, length - code.length());
        code.append(number);
        return code.toString();
    }
    String sendSMSCode(String phone, String content);
    SmsSendEntity getNewSmsSendDto(String content, String phone, String smsId, String nonce, long timestamp);
}
