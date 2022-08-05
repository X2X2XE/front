package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.service.CommentService;
import com.myweb.www.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentSvcTest {
	private static Logger log = LoggerFactory.getLogger(MemberReposTest.class);
	
	@Inject
	private CommentService csv;
	
	
	@Test
	public void join_test() throws Exception{
		int isUp = csv.post(new CommentVO(100, 100, "TEST3", "TEST"));
		log.info(">>>> reg >>> {}", isUp > 0 ? "Ok" : "Fail");
	}
}
