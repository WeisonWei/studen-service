package com.wxx.modules.st.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置
 */
@Configuration
public class RabbitMQConfig {

    //topic
    public static final String TOPIC_QUEUE1 = "st.topic.t1";
    public static final String TOPIC_QUEUE2 = "st.topic.t2";
    public static final String TOPIC_QUEUE3 = "st.topic.t3";

    public static final String TOPIC_EXECHANGE = "st.topic.exchange";

    public static final String ROUTING_KEY = "st.tp";


    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }

    @Bean
    public Queue topicQueue3() {
        return new Queue(TOPIC_QUEUE3);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXECHANGE);
    }


    @Bean
    public Binding topicExchangeBinding() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(ROUTING_KEY);
    }
}
