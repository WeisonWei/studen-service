package com.wxx.modules.st.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@Profile("dev")
@PropertySource("classpath:master.properties")
public class MasterByMasterYml {
    @Value("${teacher.name}")
    private String name;
    @Value("${teacher.sex}")
    private String sex;
    @Value("${teacher.phone}")
    private Integer phone;
    @Value("${teacher.address}")
    private String address;
}
