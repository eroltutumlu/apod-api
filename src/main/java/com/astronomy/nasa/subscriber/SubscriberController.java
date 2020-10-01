package com.astronomy.nasa.subscriber;

import com.astronomy.nasa.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriberController {

    private final SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    public Result<Boolean> subscribe(Subscriber subscriber) {
        // stub
        return null;
    }

    public Result<Boolean> unSubscribe(String email) {
        // stub
        return null;
    }

}

