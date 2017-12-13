package com.train.webstore.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	private String productId;
	private String name;
	private String desc;
	private Double price;
	private String manufacturer;
	private String category;
	private Long unitsInStock;
	private Long unitsInOrder;
	private boolean discontinued;
	
	private String condition;
	
	private Date pubDate;
	
	private MultipartFile productImageFile;
	
	
	
	public MultipartFile getProductImageFile() {
		return productImageFile;
	}
	public void setProductImageFile(MultipartFile productImageFile) {
		this.productImageFile = productImageFile;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public Long getUnitsInOrder() {
		return unitsInOrder;
	}
	public void setUnitsInOrder(Long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}
	public boolean isDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	

}
