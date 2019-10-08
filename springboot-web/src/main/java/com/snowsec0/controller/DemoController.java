package com.snowsec0.controller;

import java.util.Date;

import com.snowsec0.dao.*;
import com.snowsec0.jackson.JacksonSerial;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
   
    /**
     * 返回demo数据:
     * 请求地址：http://127.0.0.1:8080/demo/getDemo
     * @return
     */
    @RequestMapping("/getDemo")
    public Demo getDemo(){
       Demo demo = new Demo();
       demo.setId(1);
       demo.setName("Angel");
       demo.setCreateTime(new Date());
       demo.setRemark("remark");
       return demo;
    }
   
    /**
     * 触发Jackson漏洞
     * cve-2019-12384
     */
    @RequestMapping("/jackson")
    public String jackson() {
    	JacksonSerial jacksonSerial = new JacksonSerial();
    	jacksonSerial.cve201912384();
    	return "jackson success(cve-2019-12384)";
    }
    
    /**
     * 触发Jackson漏洞
     * CVE-2019-12086
     * 在开启Default Typing的情况下，且classpath中存在mysql-connector-java 8.0.15版本（2019.2.1发布）以下，攻击者可以通过发送恶意json数据读取任意文件
     */
    @RequestMapping("/jackson12086")
    public String jackson12086() {
    	JacksonSerial jacksonSerial = new JacksonSerial();
    	jacksonSerial.cve201912086();
    	return "jackson success(cve-2019-12086)";
    }
    
    
}