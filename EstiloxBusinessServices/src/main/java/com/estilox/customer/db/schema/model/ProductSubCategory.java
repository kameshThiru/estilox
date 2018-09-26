package com.estilox.customer.db.schema.model;

import java.util.Set;

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
 * @author Kamesh
 *
 */
@Entity
@Table(name="DOC_PRODUCT_SUB_CATEGORY")
public class ProductSubCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUB_CATEGORY_ID",nullable=false,updatable=false)
	private Long subCategoryId;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private ProductCategory productCategory;
	
	@Column(name="SUB_CATEGORY_NAME")
	private String subCategoryName;
	
	@OneToMany
	@JoinColumn(name="SUB_CATEGORY_ID")
	private Set<Products> products;

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	
}
