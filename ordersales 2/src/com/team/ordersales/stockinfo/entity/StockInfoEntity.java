package com.team.ordersales.stockinfo.entity;

public class StockInfoEntity {
	private String rawmaterialname;
	private String rawmaterialqty;
	private String rawmaterialcode;
	
	public StockInfoEntity() {}

	public StockInfoEntity(String rawmaterialname, String rawmaterialqty, String rawmaterialcode) {
		this.rawmaterialname = rawmaterialname;
		this.rawmaterialqty = rawmaterialqty;
		this.rawmaterialcode = rawmaterialcode;
		
	}

	public String getRawmaterialname() {
		return rawmaterialname;
	}

	public void setRawmaterialname(String rawmaterialname) {
		this.rawmaterialname = rawmaterialname;
	}

	public String getRawmaterialqty() {
		return rawmaterialqty;
	}

	public void setRawmaterialqty(String rawmaterialqty) {
		this.rawmaterialqty = rawmaterialqty;
	}

	public String getRawmaterialcode() {
		return rawmaterialcode;
	}

	public void setRawmaterialcode(String rawmaterialcode) {
		this.rawmaterialcode = rawmaterialcode;
	}
	
}