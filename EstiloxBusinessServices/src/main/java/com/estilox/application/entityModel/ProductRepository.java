package com.estilox.application.entityModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long>{

	@Query("SELECT p FROM Products p WHERE p.productName = :productName")
	public Products getProductByName(@Param("productName") String productName);
	
}