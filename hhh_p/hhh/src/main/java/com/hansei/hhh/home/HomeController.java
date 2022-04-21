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
	날짜 변환//날짜 타입이 안맞을시 여기서 변경해준다
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	@InitBinder
	public void daDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		//배열 값을 #을 기준으로 나눠서 저장해준다
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	홈페이지
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	//@GetMapping("/home") //홈페이지
	@RequestMapping(value = "/home", method= {RequestMethod.GET,RequestMethod.POST})
	public String home(Locale locale, Model model) throws Exception {
		System.out.println("여기?");
		MovieDB moviedb = new MovieDB(); 
		moviedb.movieList();
		
		model.addAttribute("movie",moviedb.movieList());
		
		return "/home/home";
	}
	
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	회원가입
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	@RequestMapping(value = "/join", method= {RequestMethod.GET,RequestMethod.POST})
	public String homejoin() {
		
		return "/home/join";
	}
	
	@PostMapping("/joinOk") //회원가입 페이지에서 정보 입력 후 홈? 로그인페이지?
	public String homejoinOk(UserDto user, Model m) throws Exception {//아마 서비스단으로(뷰 없이) 가서 바로 홈으로 보내주자

		HomeDB h = new HomeDB();
		
		if(!h.insertUser(user)) { //회원가입시 id 입력이 이상하면 다시 되돌려준다
			String msg = URLEncoder.encode("ID를 잘못입력하셨습니다.", "utf-8");
			
			//return "forward:/home/join?msg"+msg;
			return "forward:/home/join";
		}
		
		System.out.println("회원가입 완료");
		return "/home/home";
	}
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	로그인 / 로그아웃
	 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	@GetMapping("/login")
	public String homelogin() {//HttpServletRequest로 얻어와도 되지만 이렇게 직접 사용 가능
		return "/home/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {		
		session.invalidate(); //세션 종료
		return "redirect:/home/home";
	}
	
	
	@PostMapping("/login")
	public String login(UserDto user, String toURL, boolean rememberId,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		//1. id와 pwd 확인
		if(!loginCheck(user)){
			String msg = URLEncoder.encode("ID 또는 PWD가 일치하지 않습니다.", "utf-8");
			return "redirect:/home/login";
		}
		//2. id와 pwd 맞으면 세션에 id 저장
		//세션 객체를 불러와서
		HttpSession session = request.getSession();
		//세션 객체에 id를 저장
		session.setAttribute("id", user.getUser_id());
		
		System.out.println(user.getUser_id() + "세션 확인");
		
		
		//쿠키는 브라우저에 저장되기 때문에 id기억 같은거 하고 // 세션은 서버에 저장이라 로그인 유지해쥼
		if(rememberId) {//체크에 유무를 확인하고
			//3. 체크시 쿠키를 만들고 넣기
			Cookie cookie = new Cookie("id", user.getUser_id());
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("id", user.getUser_id());
			cookie.setMaxAge(0); //쿠키 시간을 0으로 주어 제거시킴
			response.addCookie(cookie);
		}
		//toURL에 값이 있다면 필요한 페이지 주소만 담아서 리턴해준다
		String[] result = toURL.split("/");
		toURL = toURL == null || toURL.equals("") ? "home/home" : result[4]+"/"+result[5];
		return "redirect:/"+toURL;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean loginCheck(UserDto user) throws Exception {
		HomeDB h = new HomeDB();
		return h.userPwCheck(user);
	}
	
}
