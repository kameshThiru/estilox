package com.estilox.application.entityModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("SELECT user FROM User user WHERE user.emailId = :emailId")
	public User findUserByEmailId(@Param("emailId") String emailId);

}
