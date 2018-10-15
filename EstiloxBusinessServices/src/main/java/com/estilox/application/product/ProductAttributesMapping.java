package com.estilox.application.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author Kamesh
 *
 */
@Entity
@Table(name="DOC_PRODUCT_ATTR_MAPPING")
public class ProductAttributesMapping implements Serializable{

	private static final long serialVersionUID = 1L;

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