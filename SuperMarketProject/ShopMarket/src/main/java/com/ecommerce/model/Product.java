package com.ecommerce.model;

import java.sql.Timestamp;




public class Product {
	
	private int id;
	private String name;
	private String category;
	private String price;
	private String quantity;
	private String image;
	private String productdate;
	
	public Product() {}
	
	public Product(int id, String name, String category, String price, String quantity, String image, String productdate) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.productdate = productdate;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}



	public String getProductdate() {
		return productdate;
	}

	public void setProductdate(String productdate) {
		this.productdate = productdate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", quantity="
				+ quantity + ", image=" + image + ", productdate=" + productdate + "]";
	}

	

	

	
	
	
	
	
	
	

}
