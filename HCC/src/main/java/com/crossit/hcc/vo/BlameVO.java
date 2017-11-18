package com.crossit.hcc.vo;

import java.sql.Timestamp;

public class BlameVO {
	int blame_seq;
	int blame_code;
	char blame_type;
	String blame_content;
	int blame_reg_seq;
	Timestamp blame_reg_date;
	public int getBlame_seq() {
		return blame_seq;
	}
	public void setBlame_seq(int blame_seq) {
		this.blame_seq = blame_seq;
	}
	public int getBlame_code() {
		return blame_code;
	}
	public void setBlame_code(int blame_code) {
		this.blame_code = blame_code;
	}
	public char getBlame_type() {
		return blame_type;
	}
	public void setBlame_type(char blame_type) {
		this.blame_type = blame_type;
	}
	public String getBlame_content() {
		return blame_content;
	}
	public void setBlame_content(String blame_content) {
		this.blame_content = blame_content;
	}
	public int getBlame_reg_seq() {
		return blame_reg_seq;
	}
	public void setBlame_reg_seq(int blame_reg_seq) {
		this.blame_reg_seq = blame_reg_seq;
	}
	public Timestamp getBlame_reg_date() {
		return blame_reg_date;
	}
	public void setBlame_reg_date(Timestamp blame_reg_date) {
		this.blame_reg_date = blame_reg_date;
	}
	
	
}
