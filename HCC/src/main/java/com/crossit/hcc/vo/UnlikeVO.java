package com.crossit.hcc.vo;

import java.sql.Timestamp;

public class UnlikeVO {
	int unlike_seq;
	int unlike_code;
	char unlike_gugun;
	int unlike_reg_seq;
	Timestamp like_reg_date;
	public int getUnlike_seq() {
		return unlike_seq;
	}
	public void setUnlike_seq(int unlike_seq) {
		this.unlike_seq = unlike_seq;
	}
	public int getUnlike_code() {
		return unlike_code;
	}
	public void setUnlike_code(int unlike_code) {
		this.unlike_code = unlike_code;
	}
	public char getUnlike_gugun() {
		return unlike_gugun;
	}
	public void setUnlike_gugun(char unlike_gugun) {
		this.unlike_gugun = unlike_gugun;
	}
	public int getUnlike_reg_seq() {
		return unlike_reg_seq;
	}
	public void setUnlike_reg_seq(int unlike_reg_seq) {
		this.unlike_reg_seq = unlike_reg_seq;
	}
	public Timestamp getLike_reg_date() {
		return like_reg_date;
	}
	public void setLike_reg_date(Timestamp like_reg_date) {
		this.like_reg_date = like_reg_date;
	}
	
	
	
}
