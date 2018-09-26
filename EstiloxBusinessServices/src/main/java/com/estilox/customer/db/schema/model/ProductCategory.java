package com.estilox.customer.db.schema.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 	@author Kamesh
**/
@Entity
@Table(name="DOC_PRODUCT_CATEGORY")
public class ProductCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID",nullable=false,updatable=false)
	private Long categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="DESCRIPTION")
	private String categoryDescription;
	
	@Column(name="ACTIVE")
	private boolean active;
	
	@OneToMany
	@JoinColumn(name="CATEGORY_ID")
	private Set<ProductSubCategory> productSubCategory;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<ProductSubCategory> getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(Set<ProductSubCategory> productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

}