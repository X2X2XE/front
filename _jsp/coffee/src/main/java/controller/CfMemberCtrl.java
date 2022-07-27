package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfMemberVO;

import service.CfMemberService;
import service.CfMemberServiceImpl;


@WebServlet("/cfm/*")
public class CfMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CfMemberCtrl.class);
	private RequestDispatcher rdp;
	private CfMemberService cfmsv;
	private int isUp;
	private String destPage;
	private int eql;
    public CfMemberCtrl() {
    	cfmsv = new CfMemberServiceImpl();
    }

    // service에 모든 로직을 담는다.
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : " + path);
		
		switch (path) {
		
		case "join":
			
			destPage = "/cfmember/join.jsp";
			break;
		case "register":			
			isUp = cfmsv.register(new CfMemberVO(req.getParameter("id"),
											req.getParameter("pwd"),
											req.getParameter("tel")));
			log.info(">>> JOIN > {}", isUp > 0 ? "Success":"Fail");
			req.setAttribute("msg_join", isUp);
			destPage = "/";
			break; 
		case "login":
			destPage = "/cfmember/login.jsp";
			break;
		case "login_auth":
			
			CfMemberVO cfvo = cfmsv.login(new CfMemberVO(req.getParameter("id"),req.getParameter("pwd")));
			
			if (cfvo != null) {
				log.info("성공");
				HttpSession ses = req.getSession();
				ses.setAttribute("ses", cfvo);
				ses.setMaxInactiveInterval(600);
			} else {
				req.setAttribute("msg_login", 0);
			}
			destPage = "/";
			break;
		case "logout":
			HttpSession ses = req.getSession();
			ses.invalidate();
			req.setAttribute("msg_logout", 1);
			destPage="/";
			break;

		case "detail":
			
			
			CfMemberVO cfvo_user = cfmsv.detail(req.getParameter("id"));
			if(cfvo_user != null) {
				isUp = 1;
			}
			
			req.setAttribute("cfmvo", cfvo_user);
			log.info(">>> detail > {}", isUp > 0 ? "Success":"Fail");
			req.setAttribute("msg_mod", isUp);
			destPage = "/cfmember/detail.jsp";
			break;
		case "modify":
			
			req.setAttribute("cfmvo", cfmsv.detail(req.getParameter("id")));
			destPage = "/cfmember/modify.jsp";
			break;
		case "modify_up":
			
			isUp = cfmsv.modify(new CfMemberVO(req.getParameter("id"),req.getParameter("pwd") ,req.getParameter("tel")));
			log.info(">>> modify > {}", isUp > 0 ? "Success":"Fail");
			destPage="/";
			break;
		case "remove":
			isUp = cfmsv.remove(req.getParameter("id"));
			destPage="logout";
		default:
			break;
		}
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
