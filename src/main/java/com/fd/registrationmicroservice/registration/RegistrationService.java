package com.fd.registrationmicroservice.registration;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fd.registrationmicroservice.appuser.AppUser;
import com.fd.registrationmicroservice.appuser.AppUserRole;
import com.fd.registrationmicroservice.appuser.AppUserService;
import com.fd.registrationmicroservice.email.EmailSender;
import com.fd.registrationmicroservice.registration.token.ConfirmationToken;
import com.fd.registrationmicroservice.registration.token.ConfirmationTokenRepository;
import com.fd.registrationmicroservice.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final AppUserService appUserService;
	private final EmailValidator emailValidator;
	private final ConfirmationTokenService confirmationTokenService;
	private final EmailSender emailSender;
	
	public String register(RegistrationRequest request) {
		
		
		  boolean isValidEmail = emailValidator.test(request.getEmail());
		  
		  if(!isValidEmail) { throw new IllegalStateException("Email not valid!"); }
		 
		
		//return "It works!";
		
		  String token = appUserService.signUpUser( 
				  new AppUser( 
						  request.getFirstname(),
						  request.getLastname(), 
						  request.getEmail(), 
						  request.getPassword(),
						  AppUserRole.USER 
						)
				  );
		  
		  String link = "http://localhost:8087/api/v1/registration/confirm?token="+token;
		  emailSender.send(
				  request.getEmail(),
				  buildEmail(request.getFirstname(), link));
		  
		  return token;
		 
	}

	@Transactional
	public String confirmToken(String token) {

		ConfirmationToken confirmationToken = confirmToken(token)
	}
}
