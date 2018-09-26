package com.estilox.customer.db.schema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="DOC_PRODUCT_ATTR_MAPPING")
public class ProductAttributesMapping implements Serializable{

	private static final long serialVersionUID = 238774821687790149L;

	@EmbeddedId
	private ProductPK productPK;
	
	@Column(name="SIZE_ID")
	private ProductSizeList productSizeList;
	
	@Column(name="COLOUR_ID")
	private ProductColourList productColourList;

	public ProductPK getProductPK() {
		return productPK;
	}

	public void setProductPK(ProductPK productPK) {
		this.productPK = productPK;
	}

	public ProductSizeList getProductSizeList() {
		return productSizeList;
	}

	public void setProductSizeList(ProductSizeList productSizeList) {
		this.productSizeList = productSizeList;
	}

	public ProductColourList getProductColourList() {
		return productColourList;
	}

	public void setProductColourList(ProductColourList productColourList) {
		this.productColourList = productColourList;
	}
	
}