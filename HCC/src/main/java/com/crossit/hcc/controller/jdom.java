package com.crossit.hcc.controller;

import java.util.List;
import java.util.Vector;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class jdom {
	
	public Vector apiTest(String searchSe) {
		Vector list = new Vector();
		String rvalUrl = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList?serviceKey=FHx3MZ5wfeyTMxpRxvpPc2EcmTn4Ypw%2BNGg8QXPHk0wbqRe47DQhFDrsM8ZzPDxpywj3IavwroLPuyPBK2Mvsg%3D%3D&yadmNm="+searchSe+"";
		
		try{
			SAXBuilder parser = new SAXBuilder();
			parser.setIgnoringElementContentWhitespace(true);
			Document doc = parser.build(rvalUrl);
			Element root = doc.getRootElement();
			List newAddressList = root.getChildren("newAddressList");
			List cmmMsgHeader = root.getChildren("cmmMsgHeader");
			if(newAddressList.size() == 0)
			{
				list.addElement(cmmMsgHeader.get(0));
			}
			else
			{
				list.addElement(cmmMsgHeader.get(0));
				for(int i=0; i<newAddressList.size(); i++)
					list.addElement(newAddressList.get(i));
			}
		} catch(Exception e) {
			
		}
		
		return list;
	}
}
