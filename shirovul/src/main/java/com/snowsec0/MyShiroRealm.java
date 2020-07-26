package com.snowsec0.springshiro;

import javax.naming.AuthenticationException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {
    /**
     * 用于判断登录信息的方法
     */
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo:");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        System.out.println("token:"+token);
        String name = token.getUsername();
        System.out.println("name:"+name);
        String password = String.valueOf(token.getPassword());
        System.out.println("password:"+password);
        if ("admin".equals(name)) {
            return new SimpleAuthenticationInfo(name, "123456", getName());
        } else {
            return null;
        }
    }
    /**
     * 这里是用来返回用户权限的方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}