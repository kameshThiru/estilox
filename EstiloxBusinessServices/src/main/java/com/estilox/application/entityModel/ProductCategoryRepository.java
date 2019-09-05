package com.estilox.application.entityModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{

	@Query("SELECT pc FROM ProductCategory pc WHERE pc.categoryName = :categoryName")
	public ProductCategory getProductCategoryByName(@Param("categoryName") String categoryName);

	
}