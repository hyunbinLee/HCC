package com.crossit.hcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String page_change_post(Model model) {

		System.out.println("게시판");

		return "post";
	}

	@RequestMapping(value = "/hospital_info", method = RequestMethod.GET)
	public String page_change_hospital_info(Model model) {

		System.out.println("병원정보");

		return "hospital_info";
	}
}