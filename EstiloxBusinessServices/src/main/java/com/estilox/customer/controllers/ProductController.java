package com.estilox.customer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilox.customer.db.schema.model.Products;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	ProductRepositories productRepositories;
	
	@PostMapping("/addProduct")
	public Products saveProducts(@Valid @RequestBody Products products){
		
		return productRepositories.save(products);
	}
}
