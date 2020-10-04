package com.astronomy.nasa.subscriber;

import com.astronomy.nasa.entity.Result;
import com.astronomy.nasa.exception.EmailAlreadyRegisteredException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

import static com.astronomy.nasa.constant.RabbitMq.EXCHANGE_NAME;

@Service
public final class SubscriberService {

    private final RabbitTemplate rabbitTemplate;
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(final RabbitTemplate rabbitTemplate, final SubscriberRepository subscriberRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.subscriberRepository = subscriberRepository;
    }

    public Result<Boolean> subscribe(Subscriber subscriber) throws EmailAlreadyRegisteredException {
        Result<Boolean> result = new Result<>(false);

        List<Subscriber> subscribers = subscriberRepository.findActiveSubscriberByEmail(subscriber.getEmail());
        if(CollectionUtils.isEmpty(subscribers) == false) {
            throw new EmailAlreadyRegisteredException("Email is already registered", "450");
        }

        subscriber.setIsDeleted(false);
        subscriberRepository.save(subscriber);
        result.setResponse(true);

        rabbitTemplate.convertAndSend(EXCHANGE_NAME,
                "apod.newSubscriber", subscriber.getEmail());

        return result;
    }

    public Result<Boolean> unsubscribe(String email) {
        Result<Boolean> result = new Result<>(false);

        List<Subscriber> subscribers = subscriberRepository.findActiveSubscriberByEmail(email);
        if(CollectionUtils.isEmpty(subscribers) == false) {
            Subscriber subscriber = subscribers.get(0);
            subscriber.setIsDeleted(true);
            subscriberRepository.save(subscriber);
            result.setResponse(true);
        }

        return result;
    }


    public List<Subscriber> getAllActiveSubscribers() {
        return subscriberRepository.getActiveSubscribers();
    }

}
