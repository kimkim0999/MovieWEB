package com.hansei.hhh.home;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hansei.hhh.dao.UserDaoImpl;
import com.hansei.hhh.db.HomeDB;
import com.hansei.hhh.db.MovieDB;
import com.hansei.hhh.domain.UserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home") //@RequestMapping("/home/*")
public class HomeController {
	
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	��¥ ��ȯ//��¥ Ÿ���� �ȸ����� ���⼭ �������ش�
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	@InitBinder
	public void daDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		//�迭 ���� #�� �������� ������ �������ش�
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	Ȩ������
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	//@GetMapping("/home") //Ȩ������
	@RequestMapping(value = "/home", method= {RequestMethod.GET,RequestMethod.POST})
	public String home(Locale locale, Model model) throws Exception {
		System.out.println("����?");
		MovieDB moviedb = new MovieDB(); 
		moviedb.movieList();
		
		model.addAttribute("movie",moviedb.movieList());
		
		return "/home/home";
	}
	
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	ȸ������
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	@RequestMapping(value = "/join", method= {RequestMethod.GET,RequestMethod.POST})
	public String homejoin() {
		
		return "/home/join";
	}
	
	@PostMapping("/joinOk") //ȸ������ ���������� ���� �Է� �� Ȩ? �α���������?
	public String homejoinOk(UserDto user, Model m) throws Exception {//�Ƹ� ���񽺴�����(�� ����) ���� �ٷ� Ȩ���� ��������

		HomeDB h = new HomeDB();
		
		if(!h.insertUser(user)) { //ȸ�����Խ� id �Է��� �̻��ϸ� �ٽ� �ǵ����ش�
			String msg = URLEncoder.encode("ID�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			//return "forward:/home/join?msg"+msg;
			return "forward:/home/join";
		}
		
		System.out.println("ȸ������ �Ϸ�");
		return "/home/home";
	}
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	�α��� / �α׾ƿ�
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	@GetMapping("/login")
	public String homelogin() {//HttpServletRequest�� ���͵� ������ �̷��� ���� ��� ����
		return "/home/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {		
		session.invalidate(); //���� ����
		return "redirect:/home/home";
	}
	
	
	@PostMapping("/login")
	public String login(UserDto user, String toURL, boolean rememberId,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		//1. id�� pwd Ȯ��
		if(!loginCheck(user)){
			String msg = URLEncoder.encode("ID �Ǵ� PWD�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/home/login";
		}
		//2. id�� pwd ������ ���ǿ� id ����
		//���� ��ü�� �ҷ��ͼ�
		HttpSession session = request.getSession();
		//���� ��ü�� id�� ����
		session.setAttribute("id", user.getUser_id());
		
		System.out.println(user.getUser_id() + "���� Ȯ��");
		
		
		//��Ű�� �������� ����Ǳ� ������ id��� ������ �ϰ� // ������ ������ �����̶� �α��� ��������
		if(rememberId) {//üũ�� ������ Ȯ���ϰ�
			//3. üũ�� ��Ű�� ����� �ֱ�
			Cookie cookie = new Cookie("id", user.getUser_id());
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("id", user.getUser_id());
			cookie.setMaxAge(0); //��Ű �ð��� 0���� �־� ���Ž�Ŵ
			response.addCookie(cookie);
		}
		//toURL�� ���� �ִٸ� �ʿ��� ������ �ּҸ� ��Ƽ� �������ش�
		String[] result = toURL.split("/");
		toURL = toURL == null || toURL.equals("") ? "home/home" : result[4]+"/"+result[5];
		return "redirect:/"+toURL;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean loginCheck(UserDto user) throws Exception {
		HomeDB h = new HomeDB();
		return h.userPwCheck(user);
	}
	
}
