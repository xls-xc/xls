package com.xls.zc.http.base.configload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**



 *
 * 登录配置
 *
 * @author zxy
 * Created 2017/4/17 12:03
 */
public class LoginConnectConfig {
    private static Properties props = new Properties();

    public LoginConnectConfig() {
    }

    public static String getValue(String key) {
        return props.getProperty(key);
    }

    public static void updateProperties(String key, String value) {
        props.setProperty(key, value);
    }

    static {
        //第三方登录配置信息
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("loginconnectconfig.properties"));
        } catch (FileNotFoundException var1) {
            var1.printStackTrace();
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
}
