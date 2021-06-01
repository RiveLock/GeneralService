package com.happy.exercise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.happy.exercise.business.*.mapper")
public class ExerciseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseServiceApplication.class, args);
    }

}
