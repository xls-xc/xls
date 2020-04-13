package com.xls.xc.xpy.config.shiro;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.xc.xpy.config.shiro
 * @EnumName: LoginType
 * @Description: 登录类型
 * @Author: SkyChen
 * @Create: 2020-04-10 21:41
 * @Version: v1.0
 **/
public enum LoginType {
    /**
     * 密码登录
     */
    PASSWORD("password"), NOPASSWORD("nopassword");
    private String code;// 状态值

    private LoginType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
