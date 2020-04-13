package com.xls.xc.xpy.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.config.shiro
 * @ClassName: CustomCredentialsMatch
 * @Description: 自定义CustomCredentialsMatch类
 * 继承HashedCredentialsMatcher类，
 * 覆写其中的doCredentialsMatch方法，
 * 将token强转为自定义token,若loginType是免密登录，
 * 则直接返回true，否则执行父类比对。
 * @Author: SkyChen
 * @Create: 2020-04-10 22:25
 * @Version: v1.0
 **/
public class CustomCredentialsMatch extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public CustomCredentialsMatch(CacheManager cacheManager) {
        this.passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //增加免密登录功能，使用自定义token
        CustomToken userToken = (CustomToken)token;

        //免密登录，不验证密码
        if(LoginType.NOPASSWORD.equals(userToken.getType())) {
            return true;
        }

        String account = userToken.getUsername();
        AtomicInteger atomicInteger = passwordRetryCache.get(account);
        if(atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            passwordRetryCache.put(account,atomicInteger);
        }

        if (atomicInteger.incrementAndGet() > 5) {
            throw new ExcessiveAttemptsException();
        }
        boolean matches  = super.doCredentialsMatch(token, info);
        if(matches) {
            passwordRetryCache.remove(account);
        }
        return matches;
    }
}
