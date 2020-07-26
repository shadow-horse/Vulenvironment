package com.snowsec0.springshiro;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        System.out.println("is rememberme:"+ShiroUtils.getSubject().isRemembered());
        System.out.println("is authenticate:"+ShiroUtils.getSubject().isAuthenticated());
        return "index";
    }
    /**
     * 如果已经登录了，直接转跳index
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(Model model) {
        if(ShiroUtils.getSubject().isAuthenticated()) {
            return "redirect:index";
        }
        else {
            model.addAttribute("msg", "请登录");
            return "login";
        }

    }
    /**
     * 登录成功会直接按配置转跳
     * 登录失败的时候会进入到这个函数里，可以提取出登录报错
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model, HttpServletRequest request) {

        Object exception = request.getAttribute("shiroLoginFailure");
        String msg= "登录失败";
        if(exception !=null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "用户名不正确，请重新输入";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码错误，请重新输入";
            } else {
                msg = "发生未知错误，请联系管理员。";
            }
        }
        model.addAttribute("msg", msg);
        return "login";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:login";
    }
}