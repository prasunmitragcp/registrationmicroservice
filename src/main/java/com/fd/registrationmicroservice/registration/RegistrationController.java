package com.fd.registrationmicroservice.registration;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
	
	
	
	private RegistrationService registrationService;
	
	@PostMapping
	public String register(@RequestBody RegistrationRequest request) {
		
		System.out.println("request email: "+request.getEmail());
		System.out.println("request first name: "+request.getFirstName());
		System.out.println("request lastname: "+request.getLastName());
		System.out.println("request password: "+request.getPassword());
		
		return registrationService.register(request);
	}
	
	@GetMapping(path = "confirm")
	public String confirm(@RequestParam("token") String token) {
		
		return registrationService.confirmToken(token);
	}

}
