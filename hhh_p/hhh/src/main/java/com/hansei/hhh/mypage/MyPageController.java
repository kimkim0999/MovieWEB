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
	
	
	@GetMapping("/mypage") //mypage url ���ý� mypage/mypage.jsp �� �Ѿ��
	public String home(HttpServletRequest request) {
		
		//�α��ν� ������ ������ �α��������� // ������ mypage
		if(!loginCheck(request)) {
			return "redirect:/home/login?toURL="+request.getRequestURL();
		}
		
		return "/mypage/mypage";
	}
	
	
	
	
	
	
	
	private boolean loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		//������ id�� ������ true �� ��ȯ���ش�
		return session.getAttribute("id") != null; //������ id�� ������ false
	}
}
