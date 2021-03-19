package com.general.support;

import com.general.support.business.sample.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com.general.support.business.*.mapper")
public class SupportApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SupportApplication.class, args);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====================  start ====================");
//        for (String str : applicationContext.getBeanDefinitionNames()) {
//            System.out.println(str);
//        }
        System.out.println(applicationContext.getBean("userServiceImpl"));
    }
}
