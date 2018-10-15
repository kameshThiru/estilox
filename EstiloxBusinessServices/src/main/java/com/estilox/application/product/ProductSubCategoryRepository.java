package com.estilox.application.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Long>{

	
}