package com.team.ordersales.login.dto;

public class RegisMemDto {
	private String id;
	private String passwd;
	private String phonenum;
	private String role;
	private String addr;

	public RegisMemDto() {}

	public RegisMemDto(String id, String passwd, String phonenum, String role, String addr) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.phonenum = phonenum;
		this.role = role;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
