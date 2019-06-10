package com.wxx.modules.st;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StApplication {

    public static void main(String[] args) {
        log.info("-- SpringBoot 开始启动--");
        SpringApplication.run(StApplication.class, args);
        log.info("-- SpringBoot 已经启动--");
    }

}
