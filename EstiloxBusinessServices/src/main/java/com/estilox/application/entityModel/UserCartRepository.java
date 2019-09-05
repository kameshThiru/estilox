package com.estilox.application.entityModel;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserCartRepository extends CrudRepository<UserCart, Long>{
	
	@Modifying
	@Transactional
	@Query("DELETE FROM UserCart userCart WHERE userCart.id = :id")
	public void deleteCartItem(@Param("id") Long id);
	
}
