package com.astronomy.nasa.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.astronomy.nasa.constant.RabbitMq.EXCHANGE_NAME;
import static com.astronomy.nasa.constant.RabbitMq.QUEUE_NAME;

@Configuration
public class RabbitMqConfig {

    @Bean
    Queue createQueue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue q, TopicExchange exchange){
        return BindingBuilder.bind(q).to(exchange).with("apod.#");
    }

}
