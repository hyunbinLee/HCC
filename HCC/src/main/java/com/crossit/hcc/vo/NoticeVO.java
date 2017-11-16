package com.crossit.hcc.vo;

import java.sql.Timestamp;

public class NoticeVO {
	private int notice_seq;
	private String notice_title;
	private String notice_content;
	private char notice_type;
	private char notice_status;
	private int notice_cnt;
	private int notice_like_cnt;
	private int notice_unlike_cnt;
	private int notice_blame_cnt;
	private int notice_reg_seq;
	private Timestamp notice_reg_date;
	private Timestamp notice_upd_date;
	public int getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public char getNotice_type() {
		return notice_type;
	}
	public void setNotice_type(char notice_type) {
		this.notice_type = notice_type;
	}
	public char getNotice_status() {
		return notice_status;
	}
	public void setNotice_status(char notice_status) {
		this.notice_status = notice_status;
	}
	public int getNotice_cnt() {
		return notice_cnt;
	}
	public void setNotice_cnt(int notice_cnt) {
		this.notice_cnt = notice_cnt;
	}
	public int getNotice_like_cnt() {
		return notice_like_cnt;
	}
	public void setNotice_like_cnt(int notice_like_cnt) {
		this.notice_like_cnt = notice_like_cnt;
	}
	public int getNotice_unlike_cnt() {
		return notice_unlike_cnt;
	}
	public void setNotice_unlike_cnt(int notice_unlike_cnt) {
		this.notice_unlike_cnt = notice_unlike_cnt;
	}
	public int getNotice_blame_cnt() {
		return notice_blame_cnt;
	}
	public void setNotice_blame_cnt(int notice_blame_cnt) {
		this.notice_blame_cnt = notice_blame_cnt;
	}
	public int getNotice_reg_seq() {
		return notice_reg_seq;
	}
	public void setNotice_reg_seq(int notice_reg_seq) {
		this.notice_reg_seq = notice_reg_seq;
	}
	public Timestamp getNotice_reg_date() {
		return notice_reg_date;
	}
	public void setNotice_reg_date(Timestamp notice_reg_date) {
		this.notice_reg_date = notice_reg_date;
	}
	public Timestamp getNotice_upd_date() {
		return notice_upd_date;
	}
	public void setNotice_upd_date(Timestamp notice_upd_date) {
		this.notice_upd_date = notice_upd_date;
	}
	
	
}
