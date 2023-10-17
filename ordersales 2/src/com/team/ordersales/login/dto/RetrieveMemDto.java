package com.team.ordersales.login.dto;

public class RetrieveMemDto {
	private String id;
	private String passwd;
	private String role;
	private String addr;

	public RetrieveMemDto() {}

	public RetrieveMemDto(String id, String passwd, String role, String addr) {
		this.id = id;
		this.passwd = passwd;
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
