package com.lyc.entity;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.lyc.util.JsonYmdhmsSerializer;

/**
 *
 * @author  liyc
 * @date 2016年9月20日 下午2:13:54
*/
public class UserInfo {
	private int id;
	private String userName;
	private String password;
	private String mobile;
	private boolean isValid;
	private Date regTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	@JsonSerialize(using = JsonYmdhmsSerializer.class)
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	
	
}
