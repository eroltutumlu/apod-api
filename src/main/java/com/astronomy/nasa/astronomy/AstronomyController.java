package com.astronomy.nasa.astronomy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstronomyController {

    @Autowired
    private AstronomyService astronomyService;

    @GetMapping("/apod")
    public Astronomy getDayOfAstronomyPicture(@RequestParam("date") String date){
        return astronomyService.getDayOfAstronomyPicture(date);
    }

}
