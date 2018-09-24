package com.estilox.customer.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductPK implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Products products;

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
}
