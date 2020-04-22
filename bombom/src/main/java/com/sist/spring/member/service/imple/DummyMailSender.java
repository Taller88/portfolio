package com.sist.spring.member.service.imple;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailSender implements MailSender {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public void send(SimpleMailMessage simpleMessage) throws MailException {
		LOG.debug("**********************");
		LOG.debug("=DummyMailSender send(SimpleMailMessage simpleMessage)");
		LOG.debug("**********************");
	}

	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		// TODO Auto-generated method stub

	}

}
