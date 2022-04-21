package com.hansei.hhh.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDto {
	private int user_num;//회원번호
	private String user_name;//이름
	private String user_id;//아이디
	private String user_pw;//비밀번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date user_date;//가입날짜
	private String user_phone;//전화번호
	private String user_address;//주소
	private String user_grade;//회원등급
	private String user_point;//보유 포인트
	private String user_img;//회원 이미지
	private String coupone_num;//쿠폰번호
	private String user_sns;// sns 연동?
	
	public UserDto() {}
	public UserDto(String user_name, String user_id, String user_pw) {
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	public UserDto(int user_num, String user_name, String user_id, String user_pw) {
		this.user_num = user_num;
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_pw = user_pw;
		
	}
	

	
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public Date getUser_date() {
		return user_date;
	}
	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
	public String getUser_point() {
		return user_point;
	}
	public void setUser_point(String user_point) {
		this.user_point = user_point;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getCoupone_num() {
		return coupone_num;
	}
	public void setCoupone_num(String coupone_num) {
		this.coupone_num = coupone_num;
	}
	public String getUser_sns() {
		return user_sns;
	}
	public void setUser_sns(String user_sns) {
		this.user_sns = user_sns;
	}
	@Override
	public String toString() {
		return "User [user_num=" + user_num + ", user_name=" + user_name + ", user_id=" + user_id + ", user_pw="
				+ user_pw + ", user_date=" + user_date + ", user_phone=" + user_phone + ", user_address=" + user_address
				+ ", user_grade=" + user_grade + ", user_point=" + user_point + ", user_img=" + user_img
				+ ", coupone_num=" + coupone_num + ", user_sns=" + user_sns + "]";
	}
	
}
