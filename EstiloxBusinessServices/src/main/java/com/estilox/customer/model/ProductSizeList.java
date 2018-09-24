package com.estilox.customer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *	@author Kamesh 
**/

@Entity
@Table(name="DOC_PRODUCT_SIZE")
public class ProductSizeList implements Serializable{
	
	private static final long serialVersionUID = 4595748836245376780L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIZE_ID",nullable=false,updatable=false)
	private Long sizeId;
	
	@Column(name="SIZE")
	private char size;
	
	@Column(name="SIZE_DESCRIPTION")
	private String sizeDescription;
	
	@Column(name="ACTIVE")
	private boolean active;

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public String getSizeDescription() {
		return sizeDescription;
	}

	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
