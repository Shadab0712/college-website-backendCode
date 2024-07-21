package com.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text, Long mobileNumber) {
        String mobileNumberStr = String.valueOf(mobileNumber); // Convert Long to String

        String messageText = text + "\n\nSender's Mobile Number: " + mobileNumberStr;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(messageText);

        mailSender.send(message);
    }
}
