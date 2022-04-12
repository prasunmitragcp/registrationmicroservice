package com.fd.registrationmicroservice.email;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService implements EmailSender {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
	private final JavaMailSender mailSender;
	
	

}
