package com.crossit.hcc.vo;

import java.sql.Timestamp;

public class Hospital_Info_reply_VO {
	private int hospital_info_seq;
	private int hospital_info_reply_seq;
	private int hospital_info_reply_subseq;
	private String hospital_info_reply_comment;
	private String hospital_info_reply_status;
	private int hospital_info_reply_blame_cnt;
	private int hospital_info_reply_reg_seq;
	private Timestamp hospital_info_reply_reg_date;
	private int hospital_info_reply_upd_seq;
	private Timestamp hospital_info_reply_upd_date;
	
	public int getHospital_info_seq() {
		return hospital_info_seq;
	}
	public void setHospital_info_seq(int hospital_info_seq) {
		this.hospital_info_seq = hospital_info_seq;
	}
	public int getHospital_info_reply_seq() {
		return hospital_info_reply_seq;
	}
	public void setHospital_info_reply_seq(int hospital_info_reply_seq) {
		this.hospital_info_reply_seq = hospital_info_reply_seq;
	}
	public int getHospital_info_reply_subseq() {
		return hospital_info_reply_subseq;
	}
	public void setHospital_info_reply_subseq(int hospital_info_reply_subseq) {
		this.hospital_info_reply_subseq = hospital_info_reply_subseq;
	}
	public String getHospital_info_reply_comment() {
		return hospital_info_reply_comment;
	}
	public void setHospital_info_reply_comment(String hospital_info_reply_comment) {
		this.hospital_info_reply_comment = hospital_info_reply_comment;
	}
	public String getHospital_info_reply_status() {
		return hospital_info_reply_status;
	}
	public void setHospital_info_reply_status(String hospital_info_reply_status) {
		this.hospital_info_reply_status = hospital_info_reply_status;
	}
	public int getHospital_info_reply_blame_cnt() {
		return hospital_info_reply_blame_cnt;
	}
	public void setHospital_info_reply_blame_cnt(int hospital_info_reply_blame_cnt) {
		this.hospital_info_reply_blame_cnt = hospital_info_reply_blame_cnt;
	}
	public int getHospital_info_reply_reg_seq() {
		return hospital_info_reply_reg_seq;
	}
	public void setHospital_info_reply_reg_seq(int hospital_info_reply_reg_seq) {
		this.hospital_info_reply_reg_seq = hospital_info_reply_reg_seq;
	}
	public Timestamp getHospital_info_reply_reg_date() {
		return hospital_info_reply_reg_date;
	}
	public void setHospital_info_reply_reg_date(Timestamp hospital_info_reply_reg_date) {
		this.hospital_info_reply_reg_date = hospital_info_reply_reg_date;
	}
	public int getHospital_info_reply_upd_seq() {
		return hospital_info_reply_upd_seq;
	}
	public void setHospital_info_reply_upd_seq(int hospital_info_reply_upd_seq) {
		this.hospital_info_reply_upd_seq = hospital_info_reply_upd_seq;
	}
	public Timestamp getHospital_info_reply_upd_date() {
		return hospital_info_reply_upd_date;
	}
	public void setHospital_info_reply_upd_date(Timestamp hospital_info_reply_upd_date) {
		this.hospital_info_reply_upd_date = hospital_info_reply_upd_date;
	}
}
