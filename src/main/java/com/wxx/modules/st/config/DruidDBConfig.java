package com.wxx.modules.st.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class DruidDBConfig {
    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setPassword(env.getProperty("spring.datasource.url.password"));
        dataSource.setUsername(env.getProperty("spring.datasource.url.username"));
        //执行前看连接是否可用
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

}




