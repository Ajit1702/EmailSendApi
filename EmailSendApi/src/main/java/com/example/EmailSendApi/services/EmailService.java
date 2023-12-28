package com.example.EmailSendApi.services;

import com.example.EmailSendApi.Entity.EmailDetails;

public interface EmailService {

	public String sendEmail(EmailDetails details);
	
	public String sendEmailAttachment(EmailDetails details);
}
