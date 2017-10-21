package com.crossit.hcc.vo;

import java.sql.Timestamp;

public class Hospital_InfoVO {
	private int hospital_info_seq;
	private String hospital_info_title;
	private String hospital_info_content;
	private double hospital_score;
	private String hospital_info_type;
	private String hospital_info_status;
	private int hospital_info_like_cnt;
	private int hospital_info_unlike_cnt;
	private int hospital_info_blame_cnt;
	private int hospital_info_reg_seq;
	private Timestamp hospital_info_reg_date;
	private int hospital_info_upd_seq;
	private Timestamp hospital_info_upd_date;
	public int getHospital_info_seq() {
		return hospital_info_seq;
	}
	public void setHospital_info_seq(int hospital_info_seq) {
		this.hospital_info_seq = hospital_info_seq;
	}
	public String getHospital_info_title() {
		return hospital_info_title;
	}
	public void setHospital_info_title(String hospital_info_title) {
		this.hospital_info_title = hospital_info_title;
	}
	public String getHospital_info_content() {
		return hospital_info_content;
	}
	public void setHospital_info_content(String hospital_info_content) {
		this.hospital_info_content = hospital_info_content;
	}
	public double getHospital_score() {
		return hospital_score;
	}
	public void setHospital_score(double hospital_score) {
		this.hospital_score = hospital_score;
	}
	public String getHospital_info_type() {
		return hospital_info_type;
	}
	public void setHospital_info_type(String hospital_info_type) {
		this.hospital_info_type = hospital_info_type;
	}
	public String getHospital_info_status() {
		return hospital_info_status;
	}
	public void setHospital_info_status(String hospital_info_status) {
		this.hospital_info_status = hospital_info_status;
	}
	public int getHospital_info_like_cnt() {
		return hospital_info_like_cnt;
	}
	public void setHospital_info_like_cnt(int hospital_info_like_cnt) {
		this.hospital_info_like_cnt = hospital_info_like_cnt;
	}
	public int getHospital_info_unlike_cnt() {
		return hospital_info_unlike_cnt;
	}
	public void setHospital_info_unlike_cnt(int hospital_info_unlike_cnt) {
		this.hospital_info_unlike_cnt = hospital_info_unlike_cnt;
	}
	public int getHospital_info_blame_cnt() {
		return hospital_info_blame_cnt;
	}
	public void setHospital_info_blame_cnt(int hospital_info_blame_cnt) {
		this.hospital_info_blame_cnt = hospital_info_blame_cnt;
	}
	public int getHospital_info_reg_seq() {
		return hospital_info_reg_seq;
	}
	public void setHospital_info_reg_seq(int hospital_info_reg_seq) {
		this.hospital_info_reg_seq = hospital_info_reg_seq;
	}
	public Timestamp getHospital_info_reg_date() {
		return hospital_info_reg_date;
	}
	public void setHospital_info_reg_date(Timestamp hospital_info_reg_date) {
		this.hospital_info_reg_date = hospital_info_reg_date;
	}
	public int getHospital_info_upd_seq() {
		return hospital_info_upd_seq;
	}
	public void setHospital_info_upd_seq(int hospital_info_upd_seq) {
		this.hospital_info_upd_seq = hospital_info_upd_seq;
	}
	public Timestamp getHospital_info_upd_date() {
		return hospital_info_upd_date;
	}
	public void setHospital_info_upd_date(Timestamp hospital_info_upd_date) {
		this.hospital_info_upd_date = hospital_info_upd_date;
	}
}
