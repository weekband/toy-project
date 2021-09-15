package com.kh.toy.common.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.kh.toy.common.code.Config;
import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.HandlableException;

public class MailSender {
	
	private static final Properties SNTP_PROPERTIES;
	
	static {
		SNTP_PROPERTIES = new Properties();
		SNTP_PROPERTIES.put("mail.smtp.host", "smtp.gmail.com");
		SNTP_PROPERTIES.put("mail.smtp.port", "587");
		SNTP_PROPERTIES.put("mail.smtp.starttls.enable", "true");
		SNTP_PROPERTIES.put("mail.smtp.ssl.protocols", "TLSv1.2");
		SNTP_PROPERTIES.put("mail.smtp.auth", "true");
		SNTP_PROPERTIES.put("mail.debug", "true");
	}
	
	public void sendEmail(String to, String subject, String htmlText) {
	  
		try {
	        MimeMessage msg = new MimeMessage(getSession());
	        msg.setFrom(new InternetAddress(Config.COMPANY_EMAIL.DESC));
	        msg.setRecipients(Message.RecipientType.TO,to);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        msg.setText(htmlText,"utf-8","html");
	        
	        Transport.send(msg);
	        
	    } catch (MessagingException mex) {
	        throw new HandlableException(ErrorCode.MAIL_SEND_FAIL_ERROR,mex);
	    }
	}
	
	private Session getSession() {
		Session session = Session.getDefaultInstance(SNTP_PROPERTIES, new Authenticator(){
	    	public PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(Config.SNTP_AUTHENTICATION_ID.DESC, Config.SNTP_AUTHENTICATION_PASSWORD.DESC);
	    	}
		});
		
		return session;
	}
	
}
