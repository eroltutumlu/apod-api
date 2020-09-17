package com.astronomy.nasa.astronomy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstronomyService {

    private final RestTemplate restTemplate;

    private static final String API_KEY = "bkiy44xdGYqktYBjP21oZlGB1bhBiPc1UKUnTLsO";

    @Autowired
    public AstronomyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Astronomy getDayOfAstronomyPicture(String date){
        String d = "https://api.nasa.gov/planetary/apod?" + "api_key=" + API_KEY + "&date=" + date;
        return restTemplate.exchange(d, HttpMethod.GET, null, Astronomy.class).getBody();
    }

}
