package com.team.ordersales.order.dto;

public class IdentifyInsalesDto {
	private int SEQ;
	private String GOODSCODE;
	private String GOODSNAME;
	private String RAWMATERIALCODE; 
	private int RAWMATERIALQTY;
	private String INSALES;
	
	public IdentifyInsalesDto() {}
	
	public IdentifyInsalesDto(int SEQ, String GOODSCODE, String GOODSNAME, 
			String RAWMATERIALCODE, int RAWMATERIALQTY, String INSALES) {
		this.SEQ = SEQ;
		this.GOODSCODE = GOODSCODE;
		this.GOODSNAME =GOODSNAME;
		this.RAWMATERIALCODE = RAWMATERIALCODE;
		this.RAWMATERIALQTY = RAWMATERIALQTY;
		this.INSALES = INSALES;
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

}