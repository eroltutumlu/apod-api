package com.astronomy.nasa.util;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(getRandomString());
    }

    private String getRandomString(){
        int r = (int) (Math.random()*7);
        String name = new String [] {"John", "Joe", "Qwerty", "Asdf", "George", "Doe"}[r];
        return name;
    }

}