package com.ssafy.answer.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Answer : 답변정보", description = "게시글의 상세 정보를 나타낸다.")
public class Answer {
	@ApiModelProperty(value = "글번호")
	private int articleno;
	@ApiModelProperty(value = "질문번호")
	private int refno;
	@ApiModelProperty(value = "작성자 아이디")
	private String userid;
	@ApiModelProperty(value = "글제목")
	private String subject;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "추천수")
	private int likeval;
	@ApiModelProperty(value = "작성일")
	private String regtime;

	public Answer() {
	}

	public Answer(int articleno, int refno, String userid, String subject, String content, int likeval,
			String regtime) {
		super();
		this.articleno = articleno;
		this.refno = refno;
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.likeval = likeval;
		this.regtime = regtime;
	}

	public int getArticleno() {
		return articleno;
	}

	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}

	public int getRefno() {
		return refno;
	}

	public void setRefno(int refno) {
		this.refno = refno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikeval() {
		return likeval;
	}

	public void setLikeval(int likeval) {
		this.likeval = likeval;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "Answer [articleno=" + articleno + ", refno=" + refno + ", userid=" + userid + ", subject=" + subject
				+ ", content=" + content + ", likeval=" + likeval + ", regtime=" + regtime + "]";
	}
	
}