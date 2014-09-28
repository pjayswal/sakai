package org.sakai.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//@Service("springMailSender")
public class SakaiEmaiSenderService {
	//@Autowired
	private SimpleMailMessage emailTemplate;
	//@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void setEmailTemplate(SimpleMailMessage emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(String dear, String content, String[] to) {
		String fromEmail = emailTemplate.getFrom();
		String[] toEmail = to;
		String emailSubject = emailTemplate.getSubject();
		String emailBody = String
				.format(emailTemplate.getText(), dear, content);
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(emailSubject);
			helper.setText(emailBody);
			/*
			 * uncomment the following lines for attachment FileSystemResource
			 * file = new FileSystemResource("attachment.jpg");
			 * helper.addAttachment(file.getFilename(), file);
			 */
			javaMailSender.send(mimeMessage);
			System.out.println("Mail sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}