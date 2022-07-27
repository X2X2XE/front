package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.Session;

import domain.CfMemberVO;
import domain.CfMenuVO;
import domain.CfOrderVO;

import service.CfMemberService;
import service.CfMemberServiceImpl;
import service.CfMenuService;
import service.CfMenuServiceImpl;
import service.CfOrderService;
import service.CfOrderServiceImpl;

@WebServlet("/cfo/*")
public class CfOrderCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CfOrderCtrl.class);
	private RequestDispatcher rdp;
	private CfOrderService cfosv;
	private CfMenuService cfmesv;
	private CfMemberVO cfmvo;
	private CfOrderVO getid;
	private HttpSession ses;
	private int isUp;
	private String destPage;

	public CfOrderCtrl() {
		cfosv = new CfOrderServiceImpl();
		cfmesv = new CfMenuServiceImpl();
	}

	// service에 모든 로직을 담는다.
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");

		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path : " + path);

		switch (path) {

		case "order_list":
			ses = req.getSession();
			cfmvo = (CfMemberVO) ses.getAttribute("sscfmvo");
			List<CfOrderVO> list = cfosv.order_list(cfmvo.getId());
			req.setAttribute("list", list);
			destPage = "/cforder/order_list.jsp";
			break;
		case "order_cancel":
			getid = cfosv.getid(req.getParameter("ono")); 
			isUp = cfosv.order_cancel(req.getParameter("ono"));
			log.info(">>> order_cancel > update > {}", isUp > 0 ? "Ok" : "Fail");
			
			destPage = "order_list?id="+getid.getId();
			break;
		case "order_remove":
			getid = cfosv.getid(req.getParameter("ono")); 
			isUp = cfosv.order_remove(req.getParameter("ono"));
			log.info(">>> order_cancel > update > {}", isUp > 0 ? "Ok" : "Fail");
			
			destPage = "order_list?id="+getid.getId();
			break;
		case "host_order_list":
			
			List<CfOrderVO> host_order = cfosv.host_order();
			req.setAttribute("list", host_order);
			destPage = "/cforder/host_order_list.jsp";
			break;
		case "host_order_finish":
			
			isUp = cfosv.host_finish(req.getParameter("ono"));
			log.info(">>> order_finish > update > {}", isUp > 0 ? "Ok" : "Fail");
			destPage = "host_order_list";
			break;
		case "host_order_cancel":
			
			isUp = cfosv.host_cancel(req.getParameter("ono"));
			log.info(">>> order_finish > update > {}", isUp > 0 ? "Ok" : "Fail");
			destPage = "host_order_list";
			break;
		case "cart_ss":
			ses = req.getSession();
			cfmvo = (CfMemberVO) ses.getAttribute("sscfmvo");
			CfMenuVO cfmevo = cfmesv.prd_info(req.getParameter("pno"));
			log.info(req.getParameter("pno"));
			log.info("id : {}", cfmvo.getId());
			log.info("name : {}", cfmevo.getName());
			log.info("pno : {}", cfmevo.getPno());
			log.info("image : {}", cfmevo.getImage_file());
			log.info("price : {}", cfmevo.getPrice());
			
			isUp = cfosv.cart_add(
					new CfOrderVO(cfmvo.getId(), 
					cfmevo.getName(), 
					cfmevo.getPno(),
					cfmevo.getImage_file(), 
					cfmevo.getPrice(),
					cfmevo.getKind()));
			log.info(">>> cart_ss > add > {}", isUp > 0 ? "Ok" : "Fail");

			destPage = "/";
			break;
		case "cart_list":
			List<CfOrderVO> cart_list = cfosv.cart_list(req.getParameter("id"));
			req.setAttribute("list", cart_list);
			destPage ="/cforder/cart_list.jsp";
			break;
		case "cart_order":
			log.info(req.getParameter("ono"));
			log.info(req.getParameter("the_number"));
			log.info(req.getParameter("etc"));
			CfOrderVO cfovo = new CfOrderVO(Integer.parseInt(req.getParameter("ono")), 
											req.getParameter("id"), 
											Integer.parseInt(req.getParameter("temper")), 
											Integer.parseInt(req.getParameter("the_number")), 
											Integer.parseInt(req.getParameter("etc")));
			isUp = cfosv.cart_order(cfovo);
			log.info(">>> cart_order > update > {}", isUp > 0 ? "Ok" : "Fail");
			destPage ="cart_list?id="+req.getParameter("id");
			break;
		case "cart_cancel":
			getid = cfosv.getid(req.getParameter("ono"));
			isUp = cfosv.cart_cancel(req.getParameter("ono"));
			log.info(">>> cart_cancel > delete > {}", isUp > 0 ? "Ok" : "Fail");
			destPage ="cart_list?id="+getid.getId();
			break;
		default:
			break;
		}
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
