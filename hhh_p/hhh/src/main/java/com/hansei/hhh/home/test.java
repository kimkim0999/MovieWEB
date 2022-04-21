package com.hansei.hhh.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
	/*
	 * public static void main(String[] args) throws Exception { UserDaoImpl d = new
	 * UserDaoImpl();
	 * 
	 * User u = new User();
	 * 
	 * u.setUser_num("111"); u.setUser_id("222"); u.setUser_pw("1234");
	 * u.setUser_name("이규");
	 * 
	 * d.insert(u); }
	 */
	public static void main(String[] args) throws Exception {
        // 스키마의 이름(springbasic)이 다른 경우 알맞게 변경해야 함
        String DB_URL = "jdbc:mysql://localhost:3306/hhh?useUnicode=true&characterEncoding=utf8";

        // DB의 userid와 pwd를 알맞게 변경해야 함
        String DB_USER = "System";
        String DB_PASSWORD = "1234";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
        String query = "INSERT INTO user_table "
        		+ "	    (user_num, user_name, user_id, user_pw) "
        		+ "	    VALUES "
        		+ "	    ('12','1234','1234','1234')";
        PreparedStatement ps = conn.prepareStatement(query);
        
        if(ps.executeUpdate() >0) {
        	System.out.println("성공");
        }else {
        	System.out.println("실패");
        }
        
    } // main()
}
