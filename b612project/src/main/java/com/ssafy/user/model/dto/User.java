package com.ssafy.user.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class User {
	
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String tel;
	private String question;
	private String answer;
	private String joindate;

	public User() {
	}

	public User(String id, String pwd, String name, String address, String tel, String question, String answer) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.question = question;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address + ", tel=" + tel
				+ ", question=" + question + ", answer=" + answer + "]";
	}
	
}
