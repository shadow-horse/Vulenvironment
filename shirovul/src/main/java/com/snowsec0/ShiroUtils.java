package com.snowsec0.springshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


/**
 * 工具类
 */
public class ShiroUtils {
    /**
     * 返回线程绑定的Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }
}