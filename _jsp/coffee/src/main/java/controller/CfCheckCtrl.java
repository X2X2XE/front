package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfCheckVO;
import domain.CfMemberVO;

import service.CfCheckService;
import service.CfCheckServiceImpl;
import service.CfMemberService;
import service.CfMemberServiceImpl;


@WebServlet("/cfcheck/*")
public class CfCheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CfCheckCtrl.class);
	private CfMemberService cfmsv;
	private CfCheckService cfcsv;
	private int isUp;
	private int eql;
    public CfCheckCtrl() {
    	cfmsv = new CfMemberServiceImpl();
    	cfcsv = new CfCheckServiceImpl();
    }

    // service에 모든 로직을 담는다.
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : " + path);
		
		switch (path) {
		
		
		case "check":
			try {
				log.info("check 시작");
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>> sb : {}", sb.toString());
				
				JSONParser parser = new JSONParser();

				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				String check = jsonObj.get("id").toString();
				CfMemberVO getcfmvo = cfmsv.check_id(jsonObj.get("id").toString());
				
				
				if(getcfmvo.getId().equals(check)) {
					eql = getcfmvo.getId().equals(check) ? 3:-1;	
				}
				PrintWriter out = res.getWriter();
				out.print(eql);
			} catch (ParseException e) {
				log.info(">>> check > id > Error");
				e.printStackTrace();
			}
			
			break;
		case "list":
			try {
				List<CfCheckVO> list = cfcsv.getList();
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				
				for (int i = 0; i < list.size(); i++) {
					jsonObjArr[i] = new JSONObject(); // key:value
					jsonObjArr[i].put("pno", list.get(i).getPno());
					jsonObjArr[i].put("name", list.get(i).getName());
					jsonObjArr[i].put("price", list.get(i).getPrice());
					jsonObjArr[i].put("kind", list.get(i).getKind());
					jsonObjArr[i].put("sal", list.get(i).getSal());
					jsonObjArr[i].put("image_file", list.get(i).getImage_file());
					log.info("name : {}", list.get(i).getSal());
					jsonObjList.add(jsonObjArr[i]);
				}
				log.info("cfcheck list 실행");
				String jsonData = jsonObjList.toJSONString();
				
				PrintWriter out = res.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
				log.info(">>> Comment > list > Error");
			}
			break;
		default:
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
