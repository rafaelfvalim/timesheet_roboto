package br.com.homine.roboto.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.homine.roboto.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	public SimpleMailMessage template;

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@homine.com.br");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public SimpleMailMessage emailTemplate() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("This is the test email template for your email:\n%s\n");
		return message;
	}

	@Override
	public void sendComplexMessage(String to, String subject, String text) {
		MimeMessage message = emailSender.createMimeMessage();		
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message);
            helper.setFrom("noreply@homineinfo.com.br");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text,true);

            emailSender.send(message);
            logger.info("Mail sent to: {}, with subject: {}", to, subject);

        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
		
	}

}