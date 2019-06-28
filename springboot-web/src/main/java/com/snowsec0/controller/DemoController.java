package com.snowsec0.controller;

import java.util.Date;

import com.snowsec0.dao.*;
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
   
}