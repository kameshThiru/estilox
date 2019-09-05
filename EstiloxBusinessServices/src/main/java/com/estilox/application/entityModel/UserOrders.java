package com.estilox.application.entityModel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.estilox.application.resolver.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * 
 * @author Kamesh
 * 
 **/

@Entity
@Table(name="DOC_USER_ORDERS")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,
					property="id",resolver=EntityIdResolver.class,scope=UserOrders.class)
public class UserOrders implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID",nullable=false,updatable=false)
	private Long id;
	
	@Column(name="DELIVERY_STATUS")
	private String deliveryStatus;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	private Integer productPrice;
	private Integer productPriceTotal;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
	private Products products;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductPriceTotal() {
		return productPriceTotal;
	}

	public void setProductPriceTotal(Integer productPriceTotal) {
		this.productPriceTotal = productPriceTotal;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
