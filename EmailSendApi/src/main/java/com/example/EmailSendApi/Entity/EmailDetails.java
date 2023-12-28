package com.example.EmailSendApi.Entity;

public class EmailDetails {

	private String to;
	private String subject;
	private String msg;
	private String attachment;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	

	public EmailDetails(String to, String subject, String msg, String attachment) {
		super();
		this.to = to;
		this.subject = subject;
		this.msg = msg;
		this.attachment = attachment;
	}
	public EmailDetails() {
		super();
	}
	@Override
	public String toString() {
		return "EmailDetails [to=" + to + ", subject=" + subject + ", msg=" + msg + ", attachment=" + attachment + "]";
	}
	
	
	
	
}
