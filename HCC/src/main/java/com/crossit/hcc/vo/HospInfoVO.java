package com.crossit.hcc.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class HospInfoVO {
	
	@XmlElement(name = "ykiho") // 암호화된 요양기호
	private String ykiho;

	@XmlElement(name = "yadmNm") // 병원명
	private String yadmNm;

	@XmlElement(name = "clCd") // 종별코드
	private String clCd;
	
	@XmlElement(name = "clCdNm") // 종별코드명
	private String clCdNm;
	
	@XmlElement(name = "addr") // 주소
	private String addr;
	
	@XmlElement(name = "emdongNm") // 읍면동명
	private String emdongNm;
	
	@XmlElement(name = "sgguCd") // 시군구코드
	private String sgguCd;
	
	@XmlElement(name = "sgguCdNm") // 시군구명
	private String sgguCdNm;
	
	@XmlElement(name = "sidoCd") // 시도코드
	private String sidoCd;
	
	@XmlElement(name = "sidoCdNm") // 시도명
	private String sidoCdNm;
	
	@XmlElement(name = "telno") // 전화번호
	private String telno;
	
	@XmlElement(name = "hospUrl") // 홈페이지
	private String hospUrl;
	
	
	/*
	@XmlElement(name = "distance") // 거리
	private String distance;
	
	@XmlElement(name = "drTotCnt") // 의사총수
	private String drTotCnt;
	
	@XmlElement(name = "estbDd") // 개설일자
	private String estbDd;
	
	@XmlElement(name = "gdrCnt") // 일반의 인원수
	private String gdrCnt;
	
	@XmlElement(name = "intnCnt") // 인턴 인원수
	private String intnCnt;
	
	@XmlElement(name = "postNo") // 우편번호
	private String postNo;
	
	@XmlElement(name = "resdntCnt") // 레지던트 인원수
	private String resdntCnt;
	
	@XmlElement(name = "sdrCnt") // 전문의 인원수
	private String sdrCnt;
	
	@XmlElement(name = "XPos") // x좌표
	private String XPos;
	
	@XmlElement(name = "YPos") // y좌표
	private String YPos;
	
	*/
	
	
	
	
	
	
	
}
