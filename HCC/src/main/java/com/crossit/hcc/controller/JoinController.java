package com.crossit.hcc.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossit.hcc.service.UserServiceImpl;
import com.crossit.hcc.util.MailService;
import com.crossit.hcc.vo.UserVO;


@Controller
public class JoinController {

	@Autowired
	private UserServiceImpl userDao;
	@Autowired
	private MailService mailService;

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(UserVO vo,@RequestParam String regi_email_f,@RequestParam String regi_email_b){
		
		String user_email = regi_email_f+"@"+regi_email_b;		
		vo.setUser_email(user_email);
		
		if(vo.getUser_gender().equals("M"))
			vo.setUser_gender("M");
		else
			vo.setUser_gender("W");
		
		
		userDao.register(vo);
		
		
		return "main";
	}
	// 회원 가입 인증
	@RequestMapping(value = "/regiMail", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String sendMailAuth(HttpSession session, @RequestParam String email) {

		int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
		String joinCode = String.valueOf(ran);
		session.setAttribute("joinCode", joinCode);

		String subject = "회원가입 인증 코드 발급 안내 입니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("귀하의 인증 코드는 " + joinCode + " 입니다.");
		boolean check = mailService.send(subject, sb.toString(), "lhb5759@gmail.com", email, null);
		if (check == true)
			return "true";
		else
			return "false";

	}

	@RequestMapping(value = "/regiMail_check", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String checkMailAuth(HttpSession session, @RequestParam String code) {

		String joincode = (String) session.getAttribute("joinCode");

		if (joincode.equals(code))
			return "true";
		else
			return "false";

	}
	
	@RequestMapping(value = "/idCheck", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String idCheck(@RequestParam (value= "id") String id) {
		
		boolean check=userDao.idCheck(id);
		return check+"";
	}
	
	
	//회원 탈퇴.
	@RequestMapping(value="/leave", method = RequestMethod.POST)
	public String user_leave(UserVO vo,@RequestParam String regi_email_f,@RequestParam String regi_email_b){
		
		//퍼블나오면 작업 예정
		//2017-10-16
		return "main";
	}
	//회원 정보 수정.
	@RequestMapping(value="/infoupdate", method = RequestMethod.POST)
	public String user_info_update(UserVO vo,@RequestParam String regi_email_f,@RequestParam String regi_email_b){
		
		//퍼블나오면 작업 예정
		
		return "main";
	}
}
