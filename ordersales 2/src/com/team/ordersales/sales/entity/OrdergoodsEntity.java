package com.team.ordersales.sales.entity;

public class OrdergoodsEntity {
	private int SEQ;
	private String GOODSCODE;
	private String GOODSNAME;
	private String RAWMATERIALCODE; 
	private int RAWMATERIALQTY;
	private String INSALES;
	private String IMGSOURCE;
	private String CATEGORY;
	
	public OrdergoodsEntity() {}
	
	public OrdergoodsEntity(int SEQ, String GOODSCODE, String GOODSNAME, 
			String RAWMATERIALCODE, int RAWMATERIALQTY, String INSALES, String IMGSOURCE, String CATEGORY) {
		this.SEQ = SEQ;
		this.GOODSCODE = GOODSCODE;
		this.GOODSNAME =GOODSNAME;
		this.RAWMATERIALCODE = RAWMATERIALCODE;
		this.RAWMATERIALQTY = RAWMATERIALQTY;
		this.INSALES = INSALES;
		this.IMGSOURCE = IMGSOURCE;
		this.CATEGORY = CATEGORY;
	}

	public int getSEQ() {
		return SEQ;
	}

	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}

	public String getGOODSCODE() {
		return GOODSCODE;
	}

	public void setGOODSCODE(String gOODSCODE) {
		GOODSCODE = gOODSCODE;
	}

	public String getGOODSNAME() {
		return GOODSNAME;
	}

	public void setGOODSNAME(String gOODSNAME) {
		GOODSNAME = gOODSNAME;
	}

	public String getRAWMATERIALCODE() {
		return RAWMATERIALCODE;
	}

	public void setRAWMATERIALCODE(String rAWMATERIALCODE) {
		RAWMATERIALCODE = rAWMATERIALCODE;
	}

	public int getRAWMATERIALQTY() {
		return RAWMATERIALQTY;
	}

	public void setRAWMATERIALQTY(int rAWMATERIALQTY) {
		RAWMATERIALQTY = rAWMATERIALQTY;
	}

	public String getINSALES() {
		return INSALES;
	}

	public void setINSALES(String iNSALES) {
		INSALES = iNSALES;
	}
	
	public String getIMGSOURCE() {
		return IMGSOURCE;
	}

	public void setIMGSOURCE(String iMGSOURCE) {
		IMGSOURCE = iMGSOURCE;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
}
