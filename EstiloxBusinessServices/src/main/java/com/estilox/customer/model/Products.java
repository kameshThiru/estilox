package com.estilox.customer.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author Kamesh
 * 
 */
@Entity
@Table(name="DOC_PRODUCTS")
public class Products implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID",nullable=false,updatable=false)
	private Long id;
	
	@Column(name="SKU")
	private String sku;
	
	@Column(name="IDSKU")
	private String idSku;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private ProductCategory productCategory;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name="PRODUCT_STATUS")
	private boolean productStatus;
	
	@Column(name="REGULAR_PRICE")
	private Integer regularPrice;
	
	@Column(name="DISCOUNT_PRICE")
	private Integer discountPrice;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="TAXABLE")
	private boolean taxable;
	
	@Column(name="INSERTED_DATE",nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date insertedAt;
	
	@Column(name="UPDATED_DATE",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	//private Set<ProductMappedSizeColour> colourSize;
	private Set<ProductPictures> productPictures;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getIdSku() {
		return idSku;
	}
	public void setIdSku(String idSku) {
		this.idSku = idSku;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public boolean isProductStatus() {
		return productStatus;
	}
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	public Integer getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(Integer regularPrice) {
		this.regularPrice = regularPrice;
	}
	public Integer getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Integer discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public boolean isTaxable() {
		return taxable;
	}
	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	public Date getInsertedAt() {
		return insertedAt;
	}
	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/*public Set<ProductMappedSizeColour> getColourSize() {
		return colourSize;
	}
	public void setColourSize(Set<ProductMappedSizeColour> colourSize) {
		this.colourSize = colourSize;
	}*/
	@OneToMany(mappedBy="products",cascade=CascadeType.ALL)
	public Set<ProductPictures> getProductPictures() {
		return productPictures;
	}
	public void setProductPictures(Set<ProductPictures> productPictures) {
		this.productPictures = productPictures;
	}
}
