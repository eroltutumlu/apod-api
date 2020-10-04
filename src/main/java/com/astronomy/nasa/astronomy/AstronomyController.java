package com.astronomy.nasa.astronomy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstronomyController {

    private final AstronomyService astronomyService;

    public AstronomyController(AstronomyService astronomyService) {
        this.astronomyService = astronomyService;
    }

    @GetMapping("/apod")
    public Astronomy getDayOfAstronomyPicture(@RequestParam("date") String date){
        return astronomyService.getDayOfAstronomyPicture(date);
    }

}
