package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="user")
public class UserTruyum {

	@Id
	@Column(name="userid" ,length=20)
	private String userid;
	@Column(name="upassword",length=20)
	private String upassword;
	@Column(name="uname",length=20)
	private String uname;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public UserTruyum(String userid, String upassword, String uname) {
		super();
		this.userid = userid;
		this.upassword = upassword;
		this.uname = uname;
	}
	public UserTruyum() {
		super();
	}
	@Override
	public String toString() {
		return "UserTruyum [userid=" + userid + ", upassword=" + upassword + ", uname=" + uname + "]";
	}
	
	
	
	
}
