package com.estilox.application.entityModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Long>{

	
}