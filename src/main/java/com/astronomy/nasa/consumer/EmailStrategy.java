package com.astronomy.nasa.consumer;

import com.astronomy.nasa.interfaces.NotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailStrategy implements NotificationStrategy {

    @Autowired
    private JavaMailSender mailSender;

    private String ab;

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    @Override
    public void notificate() throws MessagingException {

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
        message.setSubject("Example HTML email with inline image");
        message.setFrom("eroltutumlu@example.com");
        message.setTo("eroltutumlu@gmail.com");

        // Create the HTML body using Thymeleaf
        final String htmlContent = "<h1>HI!!</h1>";
        message.setText(htmlContent, true);

        mailSender.send(mimeMessage);
    }
}
