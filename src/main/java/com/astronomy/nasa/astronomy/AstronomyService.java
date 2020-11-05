package com.astronomy.nasa.astronomy;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

@Service
public class AstronomyService {

    private final static String APOD_CACHE = "APOD";
    private static final String API_KEY = "bkiy44xdGYqktYBjP21oZlGB1bhBiPc1UKUnTLsO";

    private final RedisTemplate<String, Object> redisTemplate;
    private final RestTemplate restTemplate;

    private HashOperations<String, String, Astronomy> hashOperations;

    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    public AstronomyService(final RedisTemplate<String, Object> redisTemplate, final RestTemplate restTemplate) {
        this.redisTemplate = redisTemplate;
        this.restTemplate = restTemplate;
    }

    public Astronomy getDayOfAstronomyPicture(final String date){

        Astronomy astronomy = (Astronomy)hashOperations.get(APOD_CACHE, date);
        if(astronomy == null) {
            String d = "https://api.nasa.gov/planetary/apod?" + "api_key=" + API_KEY + "&date=" + date;
            astronomy = restTemplate.exchange(d, HttpMethod.GET, null, Astronomy.class).getBody();
            hashOperations.put(APOD_CACHE, date, astronomy);
        }

        return astronomy;
    }

}
