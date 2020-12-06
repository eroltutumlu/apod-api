package com.astronomy.nasa.consumer;

import com.astronomy.nasa.astronomy.Astronomy;
import com.astronomy.nasa.astronomy.AstronomyService;
import com.astronomy.nasa.interfaces.NotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static com.astronomy.nasa.util.DateUtils.getCurrentDateFormatted;

@Component("newSubscriberEmailStrategy")
public class EmailStrategy implements NotificationStrategy {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private AstronomyService astronomyService;

    @Override
    public void notificate(String email) throws MessagingException {

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject("Day of picture from APOD NASA");
        message.setFrom("developerfull5@gmail.com");
        message.setTo(email);

        final String currentDate = getCurrentDateFormatted("");

        Astronomy astronomy = astronomyService.getDayOfAstronomyPicture(currentDate);

        Context context = new Context();
        context.setVariable("subject", astronomy.getTitle());
        context.setVariable("exp", astronomy.getExplanation());
        context.setVariable("src", astronomy.getUrl());

        String htmlContent = templateEngine.process("mailTemplate", context);
        message.setText(htmlContent, true);

        mailSender.send(mimeMessage);
    }
}
