package com.xls.xc.xpy.config.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.config.shiro
 * @ClassName: CustomToken 自定义token
 * @Description:
 * @Author: SkyChen
 * @Create: 2020-04-10 21:57
 * @Version: v1.0
 **/
public class CustomToken extends UsernamePasswordToken {
    private static final long serialVersionUID = -2564928913725078138L;

    /**
     * 登录类型
     */
    private LoginType type;

    public CustomToken() {
        super();
    }


    /**
     * 有参构造自定义token
     * @param username 用户名
     * @param password 密码
     * @param type 登录类型
     * @param rememberMe 是否记住密码 true 是  false 否
     * @param host 主机
     */
    public CustomToken(String username, String password, LoginType type, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
        this.type = type;
    }

    /**
     * 免密登录
     */
    public CustomToken(String username) {
        super(username, "", false, null);
        this.type = LoginType.NOPASSWORD;
    }

    /**
     * 账号密码登录
     */
    public CustomToken(String username, String password) {
        super(username, password, false, null);
        this.type = LoginType.PASSWORD;
    }

    public LoginType getType() {
        return type;
    }


    public void setType(LoginType type) {
        this.type = type;
    }

}
