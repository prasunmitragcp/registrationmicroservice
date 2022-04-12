package com.fd.registrationmicroservice.registration;

import javax.persistence.Entity;

import com.fd.registrationmicroservice.appuser.AppUser;
import com.fd.registrationmicroservice.appuser.AppUserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegistrationRequest {
	
	private final String firstname;
	private final String lastname;
	private final String password;
	private final String email;

}
