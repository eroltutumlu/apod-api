package com.astronomy.nasa.consumer;

import com.astronomy.nasa.astronomy.Astronomy;
import com.astronomy.nasa.astronomy.AstronomyService;
import com.astronomy.nasa.interfaces.NotificationStrategy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("newSubscriberEmailStrategy")
public class EmailStrategy implements NotificationStrategy {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    private final AstronomyService astronomyService;

    public EmailStrategy(JavaMailSender mailSender, TemplateEngine templateEngine,
                         AstronomyService astronomyService) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.astronomyService = astronomyService;
    }

    @Override
    public void notificate(String email) throws MessagingException {

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject("Day of picture from APOD NASA");
        message.setFrom("eroltutumlu@example.com");
        message.setTo("eroltutumlu@gmail.com");

        DateFormat dform = new SimpleDateFormat("YYYY-MM-dd");
        Date obj = new Date();

        Astronomy astronomy = astronomyService.getDayOfAstronomyPicture(dform.format(obj));

        Context context = new Context();
        context.setVariable("subject", astronomy.getTitle());
        context.setVariable("exp", astronomy.getExplanation());
        context.setVariable("src", astronomy.getUrl());

        String htmlContent = templateEngine.process("mailTemplate", context);
        message.setText(htmlContent, true);

        mailSender.send(mimeMessage);
    }
}
