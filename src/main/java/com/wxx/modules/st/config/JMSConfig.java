package com.wxx.modules.st.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.TopicConnectionFactory;


@Slf4j
@EnableJms
@Configuration
public class JMSConfig {
    public static final String QUEUE_PRODUCER_CONTAINER_FACTORY = "queueProducerContainerFactory";
    public static final String QUEUE_LISTENER_CONTAINER_FACTORY = "queueListenerContainerFactory";
    public static final String TOPIC_PRODUCER_CONTAINER_FACTORY = "topicProducerContainerFactory";
    public static final String TOPIC_LISTENER_CONTAINER_FACTORY = "topicListenerContainerFactory";
    public static final String QUEUE_JMSTEMPLATE = "QueueJmsTemplate";
    public static final String TOPIC_JMSTEMPLATE = "topicJmsTemplate";


    @Value("${openmq.brokerIpAddressList}")
    private String openMqAddressList;

    private ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        //connectionFactory.setTargetConnectionFactory(createConnectionFactory(openMqAddressList));
        connectionFactory.setSessionCacheSize(5);
        connectionFactory.setCacheProducers(false);
        connectionFactory.setCacheConsumers(false);
        return connectionFactory;
    }

    @Bean(QUEUE_LISTENER_CONTAINER_FACTORY)
    public JmsListenerContainerFactory jmsQueueListenerContainerFactory() {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        jmsListenerContainerFactory.setPubSubDomain(false);
        return jmsListenerContainerFactory;
    }

    @Bean(TOPIC_PRODUCER_CONTAINER_FACTORY)
    public TopicConnectionFactory jmsTopicProducerContainerFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();

        cachingConnectionFactory.setTargetConnectionFactory(connectionFactory());
        return cachingConnectionFactory;
    }

    @Bean(TOPIC_LISTENER_CONTAINER_FACTORY)
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory() {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        jmsListenerContainerFactory.setPubSubDomain(true);
        return jmsListenerContainerFactory;
    }

    @Bean(QUEUE_JMSTEMPLATE)
    public JmsTemplate queueJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setPubSubDomain(false);
        return jmsTemplate;
    }

    @Bean(TOPIC_JMSTEMPLATE)
    public JmsTemplate topicJmsTemplate1() {
        JmsTemplate jmsTemplate = new JmsTemplate(jmsTopicProducerContainerFactory());
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }


}




