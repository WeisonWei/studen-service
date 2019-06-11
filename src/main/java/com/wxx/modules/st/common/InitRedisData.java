package com.wxx.modules.st.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(2)
public class InitRedisData implements CommandLineRunner {
    @Autowired
    MasterByDefaultProperties masterByDefaultProperties;

    @Autowired
    MasterByDefaultYml masterByDefaultYml;

    @Autowired
    MasterByDevProperties masterByDevProperties;

    @Autowired
    MasterByDevYml masterByDevYml;

    @Autowired
    MasterByMasterYml masterByMasterYml;

    @Autowired
    private Environment env;

    /**
     * CommandLineRunner 接口的 Component 会在所有 Spring Beans 都初始化之后，
     * SpringApplication.run() 之前执行
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("the masterByDefaultProperties is :" + masterByDefaultProperties.toString());
        log.info("the masterByDefaultYml is :" + masterByDefaultYml.toString());
        log.info("the masterByDevProperties is :" + masterByDevProperties.toString());
        log.info("the masterByDevYml is :" + masterByDevYml.toString());
        log.info("the masterByMasterYml is :" + masterByMasterYml.toString());
        log.info("在这个方法里可以初始化数据，加载数据到redis");
    }
}