package com.cognizant.model;

public class AuthResponse {
	private String Uid;
	private String Name;
	private boolean isValid;
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public AuthResponse(String uid, String name, boolean isValid) {
		super();
		Uid = uid;
		Name = name;
		this.isValid = isValid;
	}
	public AuthResponse() {
		super();
	}
	

}
