package com.lyc.shiro.entity;
/**
 *
 * @author  liyc
 * @date 2016年9月28日 上午10:11:18
*/
public class User {

	private String name;
	private String psaaword;
	
	public User(String name,String password){
		this.name=name;
		this.psaaword=password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsaaword() {
		return psaaword;
	}

	public void setPsaaword(String psaaword) {
		this.psaaword = psaaword;
	}
	
}
