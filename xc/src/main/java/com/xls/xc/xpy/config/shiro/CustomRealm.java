package com.xls.xc.xpy.config.shiro;

import com.xls.xc.xpy.constant.UserConstant;
import com.xls.xc.xpy.service.UserService;
import com.xls.xc.xpy.util.HostInformationTool;
import com.xls.xc.xpy.vo.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.config.shiro
 * @ClassName: CustomRealm
 * @Description: 自定义的域用来管理用户的认证授权
 * @Author: SkyChen
 * @Create: 2020-04-10 21:29
 * @Version: v1.0
 **/
public class CustomRealm extends AuthorizingRealm {

    private final Logger log = LoggerFactory.getLogger(CustomRealm.class);

    @Autowired
    UserService userService;

    public String getRealmName() {
        return "CustomRealm";
    }


    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //增加免密登录，使用自定义的token
        CustomToken token = (CustomToken) authenticationToken;

        String userAccount  =(String) token.getPrincipal();

        SysUser user = userService.findUserByAccount(userAccount);
        if(user == null) {
            throw new UnknownAccountException();
        }

        if(user.getStatus() == UserConstant.STATUS) {
            throw new LockedAccountException();
        }

        String password = "123456";
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserAccount(), password, getRealmName());
        return simpleAuthenticationInfo;
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }


}
