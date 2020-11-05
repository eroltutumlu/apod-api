package com.astronomy.nasa.consumer;

import com.astronomy.nasa.interfaces.NotificationStrategy;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.util.Map;
import static com.astronomy.nasa.constant.RabbitMq.QUEUE_NAME;

@Service
@RabbitListener(queues = QUEUE_NAME)
public class ReceiveMessageHandler {

    private final Map<String, NotificationStrategy> notificationStrategies;

    public ReceiveMessageHandler(Map<String, NotificationStrategy> notificationStrategies) {
        this.notificationStrategies = notificationStrategies;
    }

    @RabbitHandler
    public void sendEmailToNewSubscriber(String email) throws MessagingException {
        notificationStrategies.get("newSubscriberEmailStrategy").notificate(email);
    }

}
