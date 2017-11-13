package com.crossit.hcc.vo;

import java.sql.Timestamp;

public class LikeVO {
	int like_seq;
	int like_code;
	int like_reg_seq;
	Timestamp like_reg_date;
	
	public int getLike_seq() {
		return like_seq;
	}
	public void setLike_seq(int like_seq) {
		this.like_seq = like_seq;
	}
	public int getLike_code() {
		return like_code;
	}
	public void setLike_code(int like_code) {
		this.like_code = like_code;
	}
	public int getLike_reg_seq() {
		return like_reg_seq;
	}
	public void setLike_reg_seq(int like_reg_seq) {
		this.like_reg_seq = like_reg_seq;
	}
	public Timestamp getLike_reg_date() {
		return like_reg_date;
	}
	public void setLike_reg_date(Timestamp like_reg_date) {
		this.like_reg_date = like_reg_date;
	}
	
	
}
