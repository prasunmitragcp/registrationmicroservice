package com.fd.registrationmicroservice.email;

public interface EmailSender {
	
	void send(String to, String email);

}
