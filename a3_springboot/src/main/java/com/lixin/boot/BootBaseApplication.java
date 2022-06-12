package com.lixin.boot;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动类
 */
@MapperScan(basePackages = {"com.lixin.boot_base.mapper"})
@SpringBootApplication

public class BootBaseApplication {

    public static Logger log = LoggerFactory.getLogger(BootBaseApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(BootBaseApplication.class, args);
        int length = context.getBeanDefinitionNames().length;
         log.debug("Spring boot启动初始化了 {} 个 Bean", length);
         log.info("swagger2访问地址：http://127.0.0.1:8080/base/swagger-ui.html#/");
         log.info("hello world");
    }
}
