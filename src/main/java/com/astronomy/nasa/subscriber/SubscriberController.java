package com.astronomy.nasa.subscriber;

import com.astronomy.nasa.entity.Result;
import com.astronomy.nasa.exception.EmailAlreadyRegisteredException;
import com.astronomy.nasa.util.apiversion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping(value = "/subscribe")
    public Result<Boolean> subscribe(@RequestBody Subscriber subscriber) throws EmailAlreadyRegisteredException {
        return subscriberService.subscribe(subscriber);
    }

    @PutMapping(value = "/unsubscribe")
    public Result<Boolean> unsubscribe(@RequestBody Subscriber subscriber) {
        return subscriberService.unsubscribe(subscriber);
    }

    @GetMapping(value = "/all")
    public List<Subscriber> getAllActiveSubscribers() {
        return subscriberService.getAllActiveSubscribers();
    }

}

