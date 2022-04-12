package com.fd.registrationmicroservice.appuser;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {
	
	
	@SequenceGenerator(
			name= "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
			)
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
			)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private AppUserRole appUserRole;
	private Boolean locked = false;
	private Boolean enabled = false;
	
	
	
	
	
	

	public AppUser(String name, 
			String username, 
			String email, 
			String password, 
			AppUserRole appUserRole) {
		
		this.firstName = name;
		this.lastName = username;
		this.email = email;
		this.password = password;
		this.appUserRole = appUserRole;
	}

	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
		
		// TODO Auto-generated method stub
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	
	private String getfirstName() {
		// TODO Auto-generated method stub
		return firstName;

	}
	
	private String getlastname() {
		// TODO Auto-generated method stub
		return lastName;

	}
	
	
	
	

}
