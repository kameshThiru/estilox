package com.estilox.application.entityModel;

import java.io.Serializable;


/**
 * @author Kamesh
 */
public class UserCartDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String productName;
	private Integer quantity;
	private String imagePath;
	private Integer price;
	private Integer offerPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(Integer offerPrice) {
		this.offerPrice = offerPrice;
	}
}
