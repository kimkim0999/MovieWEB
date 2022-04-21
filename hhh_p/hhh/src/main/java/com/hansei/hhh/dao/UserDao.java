package com.hansei.hhh.dao;

import java.util.List;

import com.hansei.hhh.domain.UserDto;

public interface UserDao {

	public int insertUser(UserDto userdto) throws Exception;
	//public List<UserDto> selectList(UserDto userdto) throws Exception;
	public void deleteUser()  throws Exception;
}


