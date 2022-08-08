package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String email;
	private String pwd;
	private String nickName;
	private String regAt;
	private String lastLogin;
	private int grade;

	public MemberVO() {
	}

	// login
	public MemberVO(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	// register
	public MemberVO(String email, String pwd, String nickName) {
		this(email, pwd);
		this.nickName = nickName;
	}

	// modifiy
	public MemberVO(String email, String pwd, String nickName, int grade) {
		this(email, pwd, nickName);
		this.grade = grade;
	}
	
	// detail
	public MemberVO(String email, String nickName, String regAt, String lastLogin, int grade) {
		this.email = email;
		this.nickName = nickName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.grade = grade;
	}

	// All
	public MemberVO(String email, String pwd, String nickName, String regAt, String lastLogin, int grade) {
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.grade = grade;
	}


	

}
