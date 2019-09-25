package com.manage.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: spring-boot-example
 * @description: 启动类
 * @author:
 * @create: 2018-05-02 09:57
 **/

//@SpringBootApplication
@ComponentScan(basePackages = {"com","com.manage.*","cn.xxx"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@Configuration
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class })
@MapperScan(basePackages = {"com.manage.*"})
public class Application {
	
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
