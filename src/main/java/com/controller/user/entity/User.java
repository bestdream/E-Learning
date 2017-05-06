package com.controller.user.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ccuser")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4105283816814685879L;
	
	@Id
	private String username;    //用户名称
	private String password;    //用户密码
	private String nickname;    //用户昵称
	private String pwdQuestion; //用户密码保护问题
	private String pwdAnswer;   //用户密码保护答案
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPwdQuestion() {
		return pwdQuestion;
	}
	public void setPwdQuestion(String pwdQuestion) {
		this.pwdQuestion = pwdQuestion;
	}
	public String getPwdAnswer() {
		return pwdAnswer;
	}
	public void setPwdAnswer(String pwdAnswer) {
		this.pwdAnswer = pwdAnswer;
	}
	
	
}
