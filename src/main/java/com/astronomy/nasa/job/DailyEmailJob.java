package com.astronomy.nasa.job;

import com.astronomy.nasa.astronomy.Astronomy;
import com.astronomy.nasa.astronomy.AstronomyService;
import com.astronomy.nasa.subscriber.Subscriber;
import com.astronomy.nasa.subscriber.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DailyEmailJob {

    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private AstronomyService astronomyService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Scheduled(cron = "0 0 9 * * *")
    public void sendDailyEmail() throws MessagingException {
        List<Subscriber> subscribers = subscriberService.getAllActiveSubscribers();
        for (Subscriber subscriber: subscribers) {
            String email = subscriber.getEmail();
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

}
