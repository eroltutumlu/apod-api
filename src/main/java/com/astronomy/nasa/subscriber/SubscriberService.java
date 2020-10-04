package com.astronomy.nasa.subscriber;

import com.astronomy.nasa.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Service
public final class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Result<Boolean> subscribe(Subscriber subscriber) {
        Result<Boolean> result = new Result<>(false);

        List<Subscriber> subscribers = subscriberRepository.findActiveSubscriberByEmail(subscriber.getEmail());
        if(CollectionUtils.isEmpty(subscribers)) {
            subscriber.setIsDeleted(false);
            subscriberRepository.save(subscriber);
            result.setResponse(true);
        }

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
