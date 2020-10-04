package com.astronomy.nasa.subscriber;

import com.astronomy.nasa.entity.Result;
import com.astronomy.nasa.util.apiversion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
@ApiVersion(1)
public class SubscriberController {

    private final SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping(value = "/subscribe")
    public Result<Boolean> subscribe(@RequestBody Subscriber subscriber) {
        return subscriberService.subscribe(subscriber);
    }

    @PutMapping(value = "/unsubscribe/{email}")
    public Result<Boolean> unsubscribe(@PathVariable("email") String email) {
        return subscriberService.unsubscribe(email);
    }

    @GetMapping(value = "all")
    public List<Subscriber> getAllActiveSubscribers() {
        return subscriberService.getAllActiveSubscribers();
    }

}

