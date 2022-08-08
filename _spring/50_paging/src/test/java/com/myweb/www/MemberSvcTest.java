package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
public class MemberSvcTest {
	
	
	@Inject
	private MemberService msv;
	
	@Test
	public void remove_test() throws Exception{
		int isUp = msv.remove("tester3@test.com");
		log.info(">>>> remove >>>> {}", isUp > 0 ? "Ok" : "Fail");
	}
	
	@Test
	public void mod_test() throws Exception {
		int isUp = msv.modifiy(new MemberVO("tester3@test.com", "1331", "Thrander", 2));
		log.info(">>>> mod >>>> {}", isUp > 0 ? "Ok" : "Fail");
	}
	
	@Test
	public void detail_test() throws Exception{
		MemberVO mvo = msv.detail("tester3@test.com");
		log.info("{}, {}, {}, {}, {}, {}",
				mvo.getEmail(), mvo.getPwd(),
				mvo.getNickName(), mvo.getRegAt(),
				mvo.getLastLogin(), mvo.getGrade());
	}
	
	@Test
	public void login_test() throws Exception{
		MemberVO mvo = msv.login(new MemberVO("tester3@test.com", "1111"));
		log.info("{}, {}, {}, {}",
				mvo.getEmail(), mvo.getNickName(),
				mvo.getLastLogin(), mvo.getGrade());
	}	
	
	@Test
	public void list_test() throws Exception{
		List<MemberVO> list = msv.list();
		for (MemberVO mvo : list) {
			log.info(">>> {}, {}, {}, {}, {}",
					mvo.getEmail(), mvo.getNickName(), 
					mvo.getRegAt(),mvo.getLastLogin(),
					mvo.getGrade());
		}
	}
	
	@Test
	public void join_test() throws Exception{
		int isUp = msv.register(new MemberVO("tester3@test.com", "1111", "TEST3"));
		log.info(">>>> reg >>> {}", isUp > 0 ? "Ok" : "Fail");
	}
}
