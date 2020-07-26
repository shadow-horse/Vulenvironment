package com.snowsec0.springshiro;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello2")
public class HelloController {
    @RequestMapping("")
    public String hello() {
        return "helloworld2";
    }

    @PostMapping("/hello")
    public Object login(@RequestBody Map<String,Object> map){
        String str = (String) map.get("json");
        return null;
    }
}