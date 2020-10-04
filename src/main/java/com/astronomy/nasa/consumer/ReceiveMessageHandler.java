package com.astronomy.nasa.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import static com.astronomy.nasa.constant.RabbitMq.QUEUE_NAME;

@Service
@RabbitListener(queues = QUEUE_NAME)
public class ReceiveMessageHandler {

    @RabbitHandler
    public void sendEmailToNewSubscriber(String email){
        // stub
        // TODO
        // https://stackoverflow.com/questions/17629761/strategy-pattern-with-spring-beans
    }

}
