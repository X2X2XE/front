package com.misson.www.service;

import com.misson.www.domain.UserVO;

public interface UserService {
	int register(UserVO uvo);
	UserVO login(UserVO uvo);
	int dupleCheck(String string);
}
