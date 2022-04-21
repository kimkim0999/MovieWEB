package com.hansei.hhh.mypage;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	
	@GetMapping("/mypage") //mypage url 선택시 mypage/mypage.jsp 로 넘어간다
	public String home(HttpServletRequest request) {
		
		//로그인시 세션이 없으면 로그인페이지 // 있으면 mypage
		if(!loginCheck(request)) {
			return "redirect:/home/login?toURL="+request.getRequestURL();
		}
		
		return "/mypage/mypage";
	}
	
	
	
	
	
	
	
	private boolean loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		//세션의 id가 있으면 true 를 반환해준다
		return session.getAttribute("id") != null; //세션의 id가 없으면 false
	}
}
