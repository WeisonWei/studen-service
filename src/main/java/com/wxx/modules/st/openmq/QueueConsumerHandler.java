package com.wxx.modules.st.openmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueConsumerHandler {

    @JmsListener(destination = "1", selector = "2", containerFactory = "beanName")
    public void studentProcessListener(String message) {
        log.info("get the Message: " + message);
    }

}
