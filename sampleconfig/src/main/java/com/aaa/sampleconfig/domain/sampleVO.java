package com.aaa.sampleconfig.domain;

public class sampleVO {
	String name;
	int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//to string 방식
	@Override
	public String toString() {
		return "sampleVO [name=" + name + ", price=" + price + "]";
	}
	
	
	

}
