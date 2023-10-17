package com.team.ordersales.sales.entity;

public class SalesInfoEntity {
	private String goodsname;
	private String orderquantity;
	private String salesdate;
	

	public SalesInfoEntity() {}


	public SalesInfoEntity(String goodsname, String orderquantity, String salesdate) {
		this.goodsname = goodsname;
		this.orderquantity = orderquantity;
		this.salesdate = salesdate;
		}


	public String getGoodsname() {
		return goodsname;
	}


	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	public String getOrderquantity() {
		return orderquantity;
	}


	public void setOrderquantity(String orderquantity) {
		this.orderquantity = orderquantity;
	}


	public String getSalesdate() {
		return salesdate;
	}


	public void setSalesdate(String salesdate) {
		this.salesdate = salesdate;
	}

}
