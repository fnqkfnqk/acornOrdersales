package com.team.ordersales.prod.entity;

public class ProductInfoEntity {
	private int seq;
	private String goodsCode;
	private String goodsName;
	private String rawMaterialCode;
	private int RAWMATERIALQTY;
	private String imgsource;
	private String category;
	
	public ProductInfoEntity() {}
	
	public ProductInfoEntity(int seq, String goodsCode, String goodsName, 
			String rawMaterialCode, int RAWMATERIALQTY, String imgsource,
			String category) {
		this.seq = seq;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.rawMaterialCode = rawMaterialCode;
		this.RAWMATERIALQTY = RAWMATERIALQTY;
		this.imgsource = imgsource;
		this.category = category;
	}

	public int getSeq() {
		return seq;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getRawMaterialCode() {
		return rawMaterialCode;
	}

	public int getRAWMATERIALQTY() {
		return RAWMATERIALQTY;
	}

	public String getImgsource() {
		return imgsource;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setRawMaterialCode(String rawMaterialCode) {
		this.rawMaterialCode = rawMaterialCode;
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
