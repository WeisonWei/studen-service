package com.wxx.modules.st.openmq;

import com.wxx.modules.st.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static com.wxx.modules.st.config.JMSConfig.QUEUE_LISTENER_CONTAINER_FACTORY;

@Slf4j
@Component
public class QueueConsumerHandler {

    @JmsListener(destination = "studentUpdateQueue", containerFactory = QUEUE_LISTENER_CONTAINER_FACTORY)
    public void studentProcessListener(Student message) {
        log.info("get the Message: " + message);
    }

}
