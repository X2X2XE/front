package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import domain.CfMenuVO;
import handler.FileHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.CfMenuService;
import service.CfMenuServiceImpl;

@WebServlet("/cfme/*")
public class CfMenuCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CfMenuCtrl.class);
	private final String UTF8 = "utf-8";
	private RequestDispatcher rdp;
	private CfMenuService cfmesv;
	private int isUp;
	private String destPage;
	private String savePath;
	
	
	
    public CfMenuCtrl() {
    	cfmesv = new CfMenuServiceImpl();
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
		
		case "add":
			destPage="/cfmenu/register.jsp";
			break;
		case "add_menu":
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);

				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(2 * 1024 * 1024); // 저장을 위한 임시 메모리 저장용량 : byte단위

				CfMenuVO cfmevo = new CfMenuVO();
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

				List<FileItem> itemList = fileUpload.parseRequest(req);
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "name":
						cfmevo.setName(item.getString(UTF8));
						break;
					case "price":
						cfmevo.setPrice(Integer.parseInt(item.getString(UTF8)));
						break;
					case "kind":
						
						cfmevo.setKind(Integer.parseInt(item.getString(UTF8)));
						break;
					case "imageFile":
						
						if (item.getSize() > 0) {
							String fileName = item.getName() // 경로가 포함된 전체 이름
									.substring(item.getName().lastIndexOf(File.separator) + 1);
							// \로 구분된 경로 이후의 파일이름

							// 실제 저장될 path로 파일을 객체화
							fileName = System.currentTimeMillis() + "_" + fileName;
							File UploadFilePath = new File(fileDir + File.separator + fileName);

							try {
								item.write(UploadFilePath); // 자바객체를 디스크에 쓰기
								cfmevo.setImage_file(fileName);

								Thumbnails.of(UploadFilePath).size(300, 200)
										.toFile(new File(fileDir + File.separator + "th_" + fileName));

								// 썸네일 작업 필요 : 리스트 페이지에서 트래픽 과다사용 방지
							} catch (Exception e) {
								log.info(">>> File Write on disk Fail");
								e.printStackTrace();
							}
						}
						isUp = cfmesv.register(cfmevo);
						log.info(">>> CfMenuCtrl > insert > {}", isUp > 0 ? "OK" : "Fail");
						destPage = "/";
						break;
					default:
						break;
					}
				}

			} catch (FileUploadException e) {

				e.printStackTrace();
			}
		case "list_page":
			req.setAttribute("list", cfmesv.getList());
			destPage ="/cfmenu/list.jsp";
			break;
		case"detail":
			req.setAttribute("prd_info", cfmesv.prd_info(req.getParameter("pno")));
			destPage = "/cfmenu/modify.jsp";
			break;
		case "modify":

			String savePath = getServletContext().getRealPath("/_fileUpload");
			File fileDir = new File(savePath);

			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(fileDir);
			fileItemFactory.setSizeThreshold(2 * 1024 * 1024); // 저장을 위한 임시 메모리 저장용량 : byte단위

			CfMenuVO cfmvo = new CfMenuVO();
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

			 
			try {
				List<FileItem> itemList = fileUpload.parseRequest(req);

				String old_file = null;
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "pno":
						cfmvo.setPno(Integer.parseInt(item.getString(UTF8)));
						break;
					case "name":
						cfmvo.setName(item.getString(UTF8));
						break;
					case "price":
						cfmvo.setPrice(Integer.parseInt(item.getString(UTF8)));
						break;
					case "kind":
						cfmvo.setKind(Integer.parseInt(item.getString(UTF8)));
						break;
			
					case "image_file":
						old_file = item.getString(UTF8);
						break;
					case "new_file":
						if (item.getSize() > 0) {

							if (old_file != null) {
								FileHandler fileHandler = new FileHandler();
								savePath = getServletContext().getRealPath("/_fileUpload");

								isUp = fileHandler.deleteFile(old_file, savePath);
							}

							String fileName = item.getName() // 경로가 포함된 전체 이름
									.substring(item.getName().lastIndexOf(File.separator) + 1);
							// \로 구분된 경로 이후의 파일이름

							// 실제 저장될 path로 파일을 객체화
							fileName = System.currentTimeMillis() + "_" + fileName;
							File UploadFilePath = new File(fileDir + File.separator + fileName);

							try {
								item.write(UploadFilePath); // 자바객체를 디스크에 쓰기
								cfmvo.setImage_file(fileName);

								Thumbnails.of(UploadFilePath).size(300, 200)
										.toFile(new File(fileDir + File.separator + "th_" + fileName));

								// 썸네일 작업 필요 : 리스트 페이지에서 트래픽 과다사용 방지
							} catch (Exception e) {
								log.info(">>> File Write on disk Fail");
								e.printStackTrace();
							}

						} else {
							cfmvo.setImage_file(old_file);
						}
						isUp = cfmesv.modify(cfmvo);
						log.info(">>> cfmenu >modify > Update > {}", isUp > 0 ? "OK" : "Fail");
						destPage = "detail?pno=" + cfmvo.getPno();
						break;
					
					default:
						break;
					}

				}
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			} catch (FileUploadException e) {
				
				e.printStackTrace();
			}
		case "remove":
			log.info(req.getParameter("pno"));
			isUp = cfmesv.remove(req.getParameter("pno"));
			log.info(">>> cfmenu > remove > delete > {}", isUp > 0 ? "OK" : "Fail");
			destPage = "list_page";
			break;
		case "sal_change":
			CfMenuVO sal_before = cfmesv.prd_info(req.getParameter("pno"));
			log.info("sal : {}",sal_before.getSal());
			isUp = sal_before.getSal() > 1 ? cfmesv.update_sal(new CfMenuVO(Integer.parseInt(req.getParameter("pno")), 1)) : cfmesv.update_sal(new CfMenuVO(Integer.parseInt(req.getParameter("pno")), 2));
			log.info(">>> cfmenu > change > sal > {}", isUp > 0 ? "OK" : "Fail");
			destPage = "list_page";
			break;
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
