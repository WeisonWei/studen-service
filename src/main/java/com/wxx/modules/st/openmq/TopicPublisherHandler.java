package com.wxx.modules.st.openmq;


import com.wxx.modules.st.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.wxx.modules.st.config.JMSConfig.TOPIC_JMSTEMPLATE;

@Slf4j
@Component
public class TopicPublisherHandler {
    @Autowired
    @Qualifier(TOPIC_JMSTEMPLATE)
    JmsTemplate jmsTemplate;

    @Value("${destination.topic}")
    private String topicDestination;

    public Mono<String> sendMessage(Mono<Student> student) {

        student.subscribe(student1 -> jmsTemplate.convertAndSend(topicDestination, student1));
        // Send a message with a POJO - the template reuse the message converter
        log.info("sending message='{}' to destination='{}'", student,
                topicDestination);
        return Mono.just(student + " send~");
    }

}

