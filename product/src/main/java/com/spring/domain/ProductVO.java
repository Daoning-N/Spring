//VO를 작업하면 Mapper(productMapper.xml) 필수
package com.spring.domain;

import org.springframework.stereotype.Component;

@Component
public class ProductVO {
	private int num;
	private String product;
	private int price;
	private int quantity;
	private String company;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "ProductVO [num=" + num + ", product=" + product + ", price=" + price + ", quantity=" + quantity
				+ ", company=" + company + "]";
	}
	
	
	

}
