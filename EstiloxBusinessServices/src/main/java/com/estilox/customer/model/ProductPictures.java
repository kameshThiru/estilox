package com.estilox.customer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


/**
 *	@author Kamesh 
**/
@Entity
@Table(name="DOC_PROODUCT_IMAGES")
public class ProductPictures implements Serializable{
	
	private static final long serialVersionUID = 287469144761828211L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_IMAGE_ID",nullable=false,updatable=false)
	private Long productImageId;
	
	@Column(name="IMAGE_PATH")
	private String path;
	
	@Column(name="VISIBLE")
	private boolean visible;
	
	@Column(name="CREATED_DATE",nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	@Column(name="UPDATED_DATE",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Products products;
}
