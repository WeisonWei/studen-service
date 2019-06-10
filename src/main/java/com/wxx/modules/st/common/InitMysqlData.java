package com.wxx.modules.st.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class InitMysqlData implements CommandLineRunner {
    /**
     * CommandLineRunner 接口的 Component 会在所有 Spring Beans 都初始化之后，
     * SpringApplication.run() 之前执行
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("在这个方法里可以初始化数据，加载数据到mysql");
    }
}