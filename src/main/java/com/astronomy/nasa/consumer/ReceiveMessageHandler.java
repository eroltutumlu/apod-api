package com.astronomy.nasa.consumer;

import com.astronomy.nasa.interfaces.NotificationStrategy;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

import static com.astronomy.nasa.constant.RabbitMq.QUEUE_NAME;

@Service
@RabbitListener(queues = QUEUE_NAME)
public class ReceiveMessageHandler {

    @Autowired
    Map<String, NotificationStrategy> notificationStrategies = new HashMap<>();

    @RabbitHandler
    public void sendEmailToNewSubscriber(String email) throws MessagingException {


        notificationStrategies.get("emailStrategy").notificate();
        int a = 1;

        // stub
        // TODO
        // https://stackoverflow.com/questions/17629761/strategy-pattern-with-spring-beans
    }

}
