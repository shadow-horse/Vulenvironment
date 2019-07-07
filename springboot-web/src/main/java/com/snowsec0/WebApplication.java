package com.snowsec0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
public class WebApplication{

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	//springboot中URL带有斜杠的转义字符百分之2F导致的400错误
	//https://blog.csdn.net/u011419453/article/details/25736375 未解决
	/*
	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
    */
}
