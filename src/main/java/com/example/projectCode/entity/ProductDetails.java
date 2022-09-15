package com.example.projectCode.entity;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="products")
public class ProductDetails {
	
	@Id
	@Column(name="pk_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="productName", nullable=false, unique=true)
	private String productName;
	
	@Column(name="productId")
	private String productId;
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="productPrice")
	private Double productPrice;
	
	@Column(name="type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	//image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "picByte", length = 50000)
	private byte[] picByte;

	
	@Column(name="category")
	private String productCategory;
	
	
	public ProductDetails() {
		super();
		
	}
	
	
	



	public ProductDetails(String productName, String productId, String productDescription, Double productPrice,
			String type, String name, byte[] picByte, String productCategory) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.type = type;
		this.name = name;
		this.picByte = picByte;
		this.productCategory = productCategory;
	}






	


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


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public byte[] getPicByte() {
		return picByte;
	}


	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	

		
	
	
}
