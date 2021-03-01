package com.general.support;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.general.support")
public class SupportApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SupportApplication.class, args);
    }


//    @Resource
//    private UserMapper userMapper;

    @Override
    public void run(ApplicationArguments args) {
//        System.out.println(userMapper.selectById(1));
    }
}
