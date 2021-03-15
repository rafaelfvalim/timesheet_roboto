package br.com.homine.roboto.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	 void sendSimpleMessage(String to, String subject, String text);
	 void sendComplexMessage(String to, String subject, String text);
	 SimpleMailMessage emailTemplate( );
}
