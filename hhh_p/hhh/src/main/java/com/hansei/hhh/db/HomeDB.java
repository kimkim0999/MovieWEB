package com.hansei.hhh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hansei.hhh.domain.UserDto;

public class HomeDB {
	String DB_URL = "jdbc:mysql://localhost:3306/hhh?useUnicode=true&characterEncoding=utf8";
	
	// DB의 userid와 pwd를 알맞게 변경해야 함
	String DB_USER = "System";
	String DB_PASSWORD = "1234";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public HomeDB(){
	}
	
	public Boolean userPwCheck(UserDto user) throws SQLException {
        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
        String sql = "select user_pw from user_table where user_id = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, user.getUser_id());
        rs = ps.executeQuery();
		String pw =null;
		if(rs.next()) {
			pw = rs.getString("user_pw");			
		}
		
		return user.getUser_pw().equals(pw);
	}
	
	public int maxnum()  throws SQLException {
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
		String sql = "select max(user_num) as num from user_table";
		ps = con.prepareStatement(sql);
		
        rs = ps.executeQuery();
        
        int maxnum = 0;
		if(rs.next()) {
			maxnum = rs.getInt("num");	
		}
		
        return maxnum+1;
	}
	
	public Boolean insertUser(UserDto user) throws SQLException {
		int maxnum =maxnum();
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
		String sql = "insert into user_table "
				+ "(user_num, user_name, user_id, user_pw) "
				+ "values "
				+ "("+maxnum+", "+user.getUser_name()+", "+user.getUser_id()+", "+user.getUser_pw()+") ";
		ps = con.prepareStatement(sql);
		/*
		user.setUser_num(maxnum()+1);
		
		ps.setInt(1, user.getUser_num());
		ps.setString(2, user.getUser_name());
		ps.setString(3, user.getUser_id());
		ps.setString(4, user.getUser_pw());
		 * */
		return ps.executeUpdate() > 0;
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
