package com.hansei.hhh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hansei.hhh.domain.UserDto;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSession session;
		
	@Autowired
	DataSource ds;
	
	private static String namespace = "com.hansei.hhh.dao.UserMapper.";
	
	@Override
	public int insertUser(UserDto userdto) throws Exception{
		return session.insert(namespace+"insertUser", userdto);
	}

	
    @Override
    public void deleteUser()  throws Exception{
    	try (Connection conn = ds.getConnection();)
        {
            String sql = "DELETE FROM user_table ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        }
       // return session.delete(namespace+"deleteuser");
    } // int delete(String statement)
	
}
