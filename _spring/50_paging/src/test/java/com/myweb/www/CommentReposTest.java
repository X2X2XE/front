package com.myweb.www;

import java.util.Iterator;
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
import com.myweb.www.repository.CommentDAO;
import com.myweb.www.repository.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentReposTest {
	private static Logger log = LoggerFactory.getLogger(CommentReposTest.class);
	
	@Inject
	private CommentDAO cdao;
	

	
}
