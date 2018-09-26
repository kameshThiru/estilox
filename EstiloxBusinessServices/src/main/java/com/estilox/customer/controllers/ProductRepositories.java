package com.estilox.customer.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estilox.customer.db.schema.model.Products;

@Repository
public interface ProductRepositories extends JpaRepository<Products, Long>{
		
}
