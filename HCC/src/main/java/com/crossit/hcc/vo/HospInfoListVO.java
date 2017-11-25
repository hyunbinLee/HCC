package com.crossit.hcc.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;





@XmlRootElement(name = "body")
public class HospInfoListVO {
	
	private List<HospInfoVO> hospInfo;
	
	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public List<HospInfoVO> getHospInfo() {
		return hospInfo;
	}
	
}
