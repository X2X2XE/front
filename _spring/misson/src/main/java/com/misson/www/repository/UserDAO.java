package com.misson.www.repository;

import org.apache.ibatis.annotations.Param;

import com.misson.www.domain.UserVO;

public interface UserDAO {
	int insert(UserVO uvo);
	UserVO select_login(UserVO uvo);
	int select_email(@Param ("email") String email);
	
}
