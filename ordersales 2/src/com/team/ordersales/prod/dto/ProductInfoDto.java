package com.team.ordersales.prod.dto;

public class ProductInfoDto {
	private String goodsCode;
	private String goodsName;
	private int RAWMATERIALQTY;
	private String imgsource;
	private String category;
	
	public ProductInfoDto() {}
	
	public ProductInfoDto(String goodsCode, String goodsName, 
			int RAWMATERIALQTY, String imgsource, String category) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.RAWMATERIALQTY = RAWMATERIALQTY;
		this.imgsource = imgsource;
		this.category = category;
	}


	public String getGoodsCode() {
		return goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public int getRAWMATERIALQTY() {
		return RAWMATERIALQTY;
	}

	public String getImgsource() {
		return imgsource;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setRAWMATERIALQTY(int rAWMATERIALQTY) {
		RAWMATERIALQTY = rAWMATERIALQTY;
	}

	public void setImgsource(String imgsource) {
		this.imgsource = imgsource;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
