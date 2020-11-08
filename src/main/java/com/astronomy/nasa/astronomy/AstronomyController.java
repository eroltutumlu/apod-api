package com.astronomy.nasa.astronomy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstronomyController {

    static final Logger logger = LoggerFactory.getLogger(AstronomyController.class);

    @Autowired
    private AstronomyService astronomyService;

    @GetMapping("/apod")
    public Astronomy getDayOfAstronomyPicture(@RequestParam("date") String date){
        logger.info("getDayOfAstronomyPicture method called with date: " + date);
        return astronomyService.getDayOfAstronomyPicture(date);
    }

}
