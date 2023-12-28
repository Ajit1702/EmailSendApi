package com.example.EmailSendApi.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.EmailSendApi.Entity.EmailDetails;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
	
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);


	@Autowired
	private JavaMailSender javaMailSender;

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	@Value("${spring.mail.username}")
	private String sender;

	
	@Override
	public String sendEmail(EmailDetails details) {

		try {

			if (details == null || details.getTo() == null || details.getSubject() == null
					|| details.getMsg() == null) {
				return "Invalid email details. Please provide all required information.";
			}

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getTo());
			mailMessage.setSubject(details.getSubject());
			mailMessage.setText(details.getMsg());

			javaMailSender.send(mailMessage);
			
	        logger.info("Simple email sent successfully to {}: {}", details.getTo(), details.getSubject());
			return "Email sent Successfully";

		} catch (Exception e) {
	        logger.error("Error while sending simple email: {}", e.getMessage(), e);
			return "Error while Sending Mail " + e.getMessage();
		}
	}

	@Override
	public String sendEmailAttachment(EmailDetails details) {

		System.out.println(details);

		MimeMessage message = javaMailSender.createMimeMessage();

		System.out.println("step 1 this is message" + message);

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(sender);
			helper.setTo(details.getTo());
			helper.setSubject(details.getSubject());
			helper.setText(details.getMsg());

			System.out.println("step 2 this is helper" + helper);

			FileSystemResource resource = new FileSystemResource(new File(details.getAttachment()));
			System.out.println(resource);
			helper.addAttachment(resource.getFilename(), resource);
			System.out.println("step 3 this is helper" + helper);
			javaMailSender.send(message);
	        logger.info("Email with attachment sent successfully to {}: {}", details.getTo(), details.getSubject());
			return "Mail sent Successfully";

		} catch (Exception e) {
	        logger.error("Error while sending email with attachment: {}", e.getMessage(), e);
			return "Error while sending mail!!!";
		}
	}

}
