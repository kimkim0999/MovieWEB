package com.hansei.hhh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hansei.hhh.domain.MovieDto;
import com.hansei.hhh.domain.UserDto;

public class MovieDB {
	String DB_URL = "jdbc:mysql://localhost:3306/hhh?useUnicode=true&characterEncoding=utf8";
	
	// DB의 userid와 pwd를 알맞게 변경해야 함
	String DB_USER = "System";
	String DB_PASSWORD = "1234";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<MovieDto> movieList() throws Exception {
        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
        String sql = "select * from movie_table where movie_start_day > now() order by movie_start_day asc";
        ps = con.prepareStatement(sql);
        List<MovieDto> m = new ArrayList<MovieDto>();
        MovieDto mdao = new MovieDto();
        rs = ps.executeQuery();
        
		if(rs.next()) {
			mdao.setMovie_name(rs.getString("movie_name"));
			mdao.setMovie_img(rs.getString("movie_img"));
			//mdao.setMovie_start_dat(rs.getDate("movie_start_day"));
			m.add(mdao);
		}
        System.out.println("상영예정 영화"+m.get(0));
        end();
        return m;
	}
	
	
	
	
	void end(){
		try {
			if(rs != null) { rs.close();}
			if(ps != null) { ps.close();}
			if(con != null) {con.close();}
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
}
