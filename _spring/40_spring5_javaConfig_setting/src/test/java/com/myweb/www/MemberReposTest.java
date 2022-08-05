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
import com.myweb.www.repository.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberReposTest {
	private static Logger log = LoggerFactory.getLogger(MemberReposTest.class);
	
	@Inject
	private MemberDAO mdao;
	
	
	
	@Test
	public void remove_test() throws Exception{
		mdao.delete("guest32@guest.com");
		getListMemberList();
	}
	
	@Test
	public void mod_test() throws Exception{
		detail_test();
		mdao.update(new MemberVO("tester@tester.com", "1221", "Thrander", 3));
		detail_test();
	}
	
	@Test
	public void detail_test() throws Exception{
		MemberVO mvo = mdao.selectDetail("tester@tester.com");
		log.info("{}, {}, {}, {}, {}, {}",
				mvo.getEmail(), mvo.getPwd(),
				mvo.getNickName(), mvo.getRegAt(),
				mvo.getLastLogin(), mvo.getGrade());
	}
	
	
	@Test
	public void LoginMemberTest() throws Exception {
		MemberVO login_info = mdao.selectOne(new MemberVO("tester@tester.com", "1111"));
		log.info("{}, {}, {}, {}", 
				login_info.getEmail(), login_info.getNickName(),
				login_info.getLastLogin(), login_info.getGrade());	
	}
	
	
	@Test
	public void getListMemberList() throws Exception {
		List<MemberVO> list =  mdao.selectList();
		for (MemberVO mvo : list) {
			log.info(">>> {}, {}, {}, {}, {}",
					mvo.getEmail(), mvo.getNickName(), 
					mvo.getRegAt(),mvo.getLastLogin(),
					mvo.getGrade());
		}
	}
	
	
	@Test
	public void insertMemberDummies100() throws Exception {
		// guest1@guest.com, 1111, GUEST1 부터 100까지 데이터베이스에 입력하기
		for (int i = 1; i <= 100; i++) {
			mdao.insert(new MemberVO("guest"+i+"@guest.com", "1111", "GUEST"+i));
		}
	}
	
	@Test
	public void insertMemberDummy() throws Exception {
		MemberVO mvo = new MemberVO();
		mvo.setEmail("tester@tester.com");
		mvo.setPwd("1111");
		mvo.setNickName("TESTER");
		mdao.insert(mvo);
		
		int isUp = mdao.insert(new MemberVO("tester2@tester.com", "1111", "TESTER2"));
		log.info(">>> Test of insert Member {}", isUp > 0 ? "OK" : "FAIL");
		
	}
	
}
