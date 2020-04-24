package com.xls.zc.http.base;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @copyright
 * @license    
 * @link       
 *
 * Session处理类
 *
 * @author zxy
 * Created 2017/4/13 11:08
 */
@Component
public class SessionHelper {
    /**
     * session前缀
     */
    private String prefix = "";

    /**
     * 设置Session
     * @param name session名称
     * @param value session值
     * @param expiredTime 过期时间
     */
    public void setSession(String name, Object value, int expiredTime) {
        HttpServletRequest request  = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(expiredTime);
        session.setAttribute(prefix + name, value);
    }

    /**
     * 获取Session
     * @param name session名称
     * @return session值
     */
    public String getSession(String name) {
        HttpServletRequest request  = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        if (session==null) {
            return "";
        }
        Object val = session.getAttribute(prefix + name);
        if (val==null) {
            return "";
        }else{
            return val.toString();
        }
    }

    /**
     * 销毁Session
     * @param name session名称
     */
    public void destroySession(String name) {
        HttpServletRequest request  = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(prefix + name);
    }

    /**
     * 获取session ID
     * @return sessionID
     */
    public String getSessionId() {
        HttpServletRequest request  = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        return session.getId();
    }

    /**
     * 获取session路径
     * @return session路径
     */
    public String getSessionPath() {
        HttpServletRequest request  = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getContextPath()+"/";
    }
}
