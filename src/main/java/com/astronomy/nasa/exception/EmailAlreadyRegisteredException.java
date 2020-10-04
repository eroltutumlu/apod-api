package com.astronomy.nasa.exception;

public class EmailAlreadyRegisteredException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    private final String code;

    public EmailAlreadyRegisteredException(String code) {
        super();
        this.code = code;
    }

    public EmailAlreadyRegisteredException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public EmailAlreadyRegisteredException(String message, String code) {
        super(message);
        this.code = code;
    }

    public EmailAlreadyRegisteredException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

}