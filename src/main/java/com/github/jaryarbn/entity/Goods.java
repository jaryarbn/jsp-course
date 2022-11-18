package com.github.jaryarbn.entity;


import java.math.BigDecimal;

public class Goods {
	
	private String goodsName;
	private BigDecimal price;
	public Goods() {
		super();
		
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
