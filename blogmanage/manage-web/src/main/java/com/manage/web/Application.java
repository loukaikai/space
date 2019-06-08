package com.manage.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-example
 * @description: 启动类
 * @author:
 * @create: 2018-05-02 09:57
 **/

@SpringBootApplication
@ComponentScan(basePackages = {"com","com.manage","cn.xxx"})
@Configuration
public class Application {
	
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
