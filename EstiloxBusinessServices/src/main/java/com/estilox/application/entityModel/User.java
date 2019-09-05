package com.estilox.application.entityModel;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.estilox.application.resolver.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * 
 * @author Kamesh
 * 
 **/
@Entity
@Table(name="DOC_USER")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,
property="id",resolver=EntityIdResolver.class,scope=User.class)
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID",nullable=false,updatable=false)
	private Long id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_EMAIL")
	private String emailId;
	
	@Column(name="USER_PASSWORD",nullable=false)
	private String password;
	
	@Column(name="INSERTED_DATE",nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date insertedAt;
	
	@Column(name="UPDATED_DATE",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNo;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private Set<UserCart> userCart;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ORDER_ID")
	private Set<UserOrders> userOrders;
	
	@Transient
	private String statusMessage;
	@Transient
	private String token;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Set<UserCart> getUserCart() {
		return userCart;
	}

	public void setUserCart(Set<UserCart> userCart) {
		this.userCart = userCart;
	}

	public Set<UserOrders> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(Set<UserOrders> userOrders) {
		this.userOrders = userOrders;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
