package com.fd.registrationmicroservice.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
	
	
	Optional<ConfirmationToken> findByToken(String token);
	
	@Query("UPDATE ConfirmationToken c " + 
			"SET c.confirmedAt = ?2 " + 
			"WHERE c.token = ?1")
	int updateConfirmedAt(String token, 
			LocalDateTime confirmedAt);

}