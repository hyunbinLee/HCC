package com.crossit.hcc.vo;

import java.sql.Timestamp;

public class HCCFmb_replyVO {
	private int fmb_seq;
	private int fmb_reply_seq;
	private int fmb_reply_subseq;
	private String fmb_reply_comment;
	private int fmb_reply_blame_cnt;
	private int fmb_reply_reg_seq;
	private Timestamp fmb_reply_reg_date;
	private int fmb_reply_upd_seq;
	private Timestamp fmb_reply_upd_date;
	
	public int getFmb_seq() {
		return fmb_seq;
	}
	public void setFmb_seq(int fmb_seq) {
		this.fmb_seq = fmb_seq;
	}
	public int getFmb_reply_seq() {
		return fmb_reply_seq;
	}
	public void setFmb_reply_seq(int fmb_reply_seq) {
		this.fmb_reply_seq = fmb_reply_seq;
	}
	public int getFmb_reply_subseq() {
		return fmb_reply_subseq;
	}
	public void setFmb_reply_subseq(int fmb_reply_subseq) {
		this.fmb_reply_subseq = fmb_reply_subseq;
	}
	public String getFmb_reply_comment() {
		return fmb_reply_comment;
	}
	public void setFmb_reply_comment(String fmb_reply_comment) {
		this.fmb_reply_comment = fmb_reply_comment;
	}
	public int getFmb_reply_blame_cnt() {
		return fmb_reply_blame_cnt;
	}
	public void setFmb_reply_blame_cnt(int fmb_reply_blame_cnt) {
		this.fmb_reply_blame_cnt = fmb_reply_blame_cnt;
	}
	public int getFmb_reply_reg_seq() {
		return fmb_reply_reg_seq;
	}
	public void setFmb_reply_reg_seq(int fmb_reply_reg_seq) {
		this.fmb_reply_reg_seq = fmb_reply_reg_seq;
	}
	public Timestamp getFmb_reply_reg_date() {
		return fmb_reply_reg_date;
	}
	public void setFmb_reply_reg_date(Timestamp fmb_reply_reg_date) {
		this.fmb_reply_reg_date = fmb_reply_reg_date;
	}
	public int getFmb_reply_upd_seq() {
		return fmb_reply_upd_seq;
	}
	public void setFmb_reply_upd_seq(int fmb_reply_upd_seq) {
		this.fmb_reply_upd_seq = fmb_reply_upd_seq;
	}
	public Timestamp getFmb_reply_upd_date() {
		return fmb_reply_upd_date;
	}
	public void setFmb_reply_upd_date(Timestamp fmb_reply_upd_date) {
		this.fmb_reply_upd_date = fmb_reply_upd_date;
	}
}
