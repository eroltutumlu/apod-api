package com.astronomy.nasa.entity;

public class Result<T> {

    private T response;

    public Result(T response) {
        this.response = response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }
}
