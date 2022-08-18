package com.misson.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misson.www.domain.UserVO;
import com.misson.www.repository.UserDAO;
@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO udao;
	@Override
	public int register(UserVO uvo) {
		
		return udao.insert(uvo);
	}

	@Override
	public UserVO login(UserVO uvo) {
		
		return udao.select_login(uvo);
	}

	@Override
	public int dupleCheck(String email) {
		// TODO Auto-generated method stub
		return udao.select_email(email);
	}

}
