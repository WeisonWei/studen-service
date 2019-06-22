package com.wxx.modules.st.openmq;


import com.wxx.modules.st.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

import static com.wxx.modules.st.config.JMSConfig.TOPIC_LISTENER_CONTAINER_FACTORY;


@Slf4j
@Component
public class TopicSubscriberHandler {

    private CountDownLatch latch = new CountDownLatch(2);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "${openmq.topic.stTopic.name}", containerFactory = TOPIC_LISTENER_CONTAINER_FACTORY)
    public void receive1(Student message) {
        log.info("'subscriber1' received message='{}'", message);
        latch.countDown();
    }

    @JmsListener(destination = "${openmq.topic.stTopic.name}", containerFactory = TOPIC_LISTENER_CONTAINER_FACTORY)
    public void receive2(Student message) {
        log.info("'subscriber2' received message='{}'", message);
        latch.countDown();
    }
}
