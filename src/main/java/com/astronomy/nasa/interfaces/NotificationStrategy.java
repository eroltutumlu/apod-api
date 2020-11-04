package com.astronomy.nasa.interfaces;

import javax.mail.MessagingException;

public interface NotificationStrategy {
    void notificate() throws MessagingException;
}