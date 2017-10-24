package com.crossit.hcc.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossit.hcc.service.UserDetail;
import com.crossit.hcc.service.UserServiceImpl;
import com.crossit.hcc.util.MailService;
import com.crossit.hcc.vo.UserVO;


@Controller
public class JoinController {

	@Autowired
	private UserServiceImpl userDao;
	@Autowired
	private MailService mailService;

	@RequestMapping(value="/register", method = RequestMethod.POST)
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
	
	//회원 탈퇴 비밀번호 확인.
		@RequestMapping(value="/leavecheck", method = RequestMethod.GET)
		public String user_leave_check(Model model){
			//퍼블나오면 작업 예정
			//2017-10-16
			return "/User/userleavecheck";
		}
		
	//회원 탈퇴.
	@RequestMapping(value="/leave", method = RequestMethod.POST)
	public String user_leave(Model model,@RequestParam String passwordcheck){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		if(userDao.pwCheck(userdetail.getUsername(),passwordcheck)==true){
			userDao.leave(userdetail.getUser());
			//로그아웃.
			SecurityContextHolder.clearContext();//강제 로그아웃

			return "redirect:/main";			
			}
		else{
			return "/User/pwCheckFail";
	
			}
		//퍼블나오면 작업 예정
		//2017-10-16
	}
	//회원 정보 수정.
	@RequestMapping(value="/infoupdatecheck", method = RequestMethod.GET)
	public String user_info_update_check(Model model){//1
	
		//퍼블나오면 작업 예정
		
		return "/User/usermodifycheck";
	}
	
	@RequestMapping(value="/infoupdate", method = RequestMethod.POST)
	public String user_info_update(Model model,@RequestParam String passwordcheck){//2
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
	    UserVO vo = userdetail.getUser();
		if(userDao.pwCheck(userdetail.getUsername(),passwordcheck)==true){
		    model.addAttribute("UserId", vo.getUser_id());
		    model.addAttribute("UserName", vo.getUser_name());
		    model.addAttribute("UserGender", vo.getUser_gender());
		    
			return "/User/userinfomodify";
			}
		else{
			
			return "/User/pwCheckFail";
	
			}
	    
		//퍼블나오면 작업 예정
		
	}
	
	@RequestMapping(value="/infoupdatesaved", method = RequestMethod.POST)
	public String user_info_update_saved(Model model,@RequestParam String user_pw,@RequestParam String user_phone,@RequestParam String regi_email_f,@RequestParam String regi_email_b){//3
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
	    
		UserVO vo = new UserVO();
		vo.setUser_id(userdetail.getUsername());
		vo.setUser_pw(user_pw);
		vo.setUser_phone(user_phone);
		vo.setUser_email(regi_email_f+"@"+regi_email_b);

		userDao.infoupdate(vo);
		
		//퍼블나오면 작업 예정
		
		return "main";
	}
	
}
