package com.estilox.application.entityModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kamesh
 */
@Entity
@Table(name="DOC_PRODUCT_COLOUR")
public class ProductColourList implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COLOUR_ID")
	private Long colourId;
	
	@Column(name="COLOUR_NAME")
	private String colour;
	
	@Column(name="COLOUR_DESCRIPTION")
	private String colourDescription;
	
	@Column(name="COLOUR_CODE_RGB")
	private String colourCode;
	
	@Column(name="ACTIVE")
	private boolean active;

	public Long getColourId() {
		return colourId;
	}

	public void setColourId(Long colourId) {
		this.colourId = colourId;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getColourDescription() {
		return colourDescription;
	}

	public void setColourDescription(String colourDescription) {
		this.colourDescription = colourDescription;
	}

	public String getColourCode() {
		return colourCode;
	}

	public void setColourCode(String colourCode) {
		this.colourCode = colourCode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
