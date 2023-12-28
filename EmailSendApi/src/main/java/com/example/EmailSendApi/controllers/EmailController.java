package com.example.EmailSendApi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmailSendApi.Entity.EmailDetails;
import com.example.EmailSendApi.services.EmailService;



@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	
	
	@GetMapping("/test")
	public String emailtest() {
	    logger.info("Testing endpoint accessed.");
	    return "this is for testing ";
	}

	@PostMapping("/sendEmail")
	public String sendSimpleEmail(@RequestBody EmailDetails details) {
	    logger.info("Received request to send simple email: {}", details);
	    String email = emailService.sendEmail(details);
	    logger.info("Email sent successfully: {}", email);
	    return email;
	}

	@PostMapping("/sendEmailWithAttachment")
	public String sendEmailWithAttachment(@RequestBody EmailDetails details) {
	    logger.info("Received request to send email with attachment: {}", details);
	    String email = emailService.sendEmailAttachment(details);
	    logger.info("Email with attachment sent successfully: {}", email);
	    return email;
	}


}
