package com.website.configuration;

import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class ConfigurationClass {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	 @Bean
	    public JavaMailSender javaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("alibrahimmahavidhyalaya@gmail.com"); // Replace with your email
	        mailSender.setPassword("czye fkvq dpka mllj"); // Replace with your password

	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");

	        return mailSender;
	    }
	
}
