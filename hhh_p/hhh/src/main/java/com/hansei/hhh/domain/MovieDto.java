package com.hansei.hhh.domain;

import java.util.Date;

public class MovieDto {
	int movie_num;
	String movie_name;
	String movie_text;
	String movie_img;
	int movie_count;
	Date movie_start_dat; //∞≥∫¿ øπ¡§¿œ
	
	
	public int getMovie_num() {
		return movie_num;
	}
	public void setMovie_num(int movie_num) {
		this.movie_num = movie_num;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_text() {
		return movie_text;
	}
	public void setMovie_text(String movie_text) {
		this.movie_text = movie_text;
	}
	public String getMovie_img() {
		return movie_img;
	}
	public void setMovie_img(String movie_img) {
		this.movie_img = movie_img;
	}
	public int getMovie_count() {
		return movie_count;
	}
	public void setMovie_count(int movie_count) {
		this.movie_count = movie_count;
	}
	public Date getMovie_start_dat() {
		return movie_start_dat;
	}
	public void setMovie_start_dat(Date movie_start_dat) {
		this.movie_start_dat = movie_start_dat;
	}
	@Override
	public String toString() {
		return "MovieDto [movie_num=" + movie_num + ", movie_name=" + movie_name + ", movie_text=" + movie_text
				+ ", movie_img=" + movie_img + ", movie_count=" + movie_count + ", movie_start_dat=" + movie_start_dat
				+ "]";
	}
	
	
}
