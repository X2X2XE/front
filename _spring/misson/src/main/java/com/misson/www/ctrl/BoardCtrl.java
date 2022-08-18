package com.misson.www.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.misson.www.domain.BoardDTO;
import com.misson.www.domain.BoardVO;
import com.misson.www.domain.FileVO;
import com.misson.www.domain.PagingVO;
import com.misson.www.handler.FileHandler;
import com.misson.www.handler.PagingHandler;
import com.misson.www.service.BoardService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardCtrl {
	@Inject
	private BoardService bsv;
	@Inject
	private FileHandler fhd;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO bvo, RedirectAttributes rttr,
			@RequestParam(name = "fileAttached", required = false) MultipartFile[] files) {
		List<FileVO> fileList =null;
		if(files[0].getSize() > 0) {
			fileList = fhd.getFileList(files);
			bvo.setFileCount(fileList.size());
		}
		int isUp = bsv.register(new BoardDTO(bvo, fileList));
		log.info(">>> product register : {} ", isUp > 0 ? "Ok" : "Fail");
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public void list(Model model, PagingVO pgvo, @RequestParam("category") int category) {
		pgvo.setCategory(category);
		List<BoardVO> list = bsv.getList(pgvo);
		model.addAttribute("list", list);
		int totalCount = bsv.getTotalCount(pgvo);
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
		model.addAttribute("cate", category);
	}
	
	@GetMapping({"/detail", "/modify"} )
	public void detail(@RequestParam("bno") long bno, Model model,
			@ModelAttribute("pgvo") PagingVO pgvo) {
		
		BoardDTO bdto = bsv.getDetail(bno,1);
		model.addAttribute("bdto", bdto);
		
	}
	
	@PostMapping("/modify")
	public String modifiy(BoardVO bvo, 
			@RequestParam(name ="fileAttached", required = false)MultipartFile[] files,
			RedirectAttributes rttr,
			PagingVO pgvo) {
		List<FileVO> fileList =null;
		if(files[0].getSize() > 0) {
			fileList = fhd.getFileList(files);
			bvo.setFileCount(fileList.size());
		}
		int isUp = bsv.modifiy(new BoardDTO(bvo, fileList));
		
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		rttr.addAttribute("type", pgvo.getType());
		rttr.addAttribute("kw", pgvo.getKw());
		log.info(">> product modi : {}", isUp >0 ? "OK" : "Fail");
		
		return "redirect:/board/detail?bno=" + bvo.getBno();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") long bno, RedirectAttributes rttr, PagingVO pgvo) {
		int isUp = bsv.remove(bno);
		
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		rttr.addAttribute("type", pgvo.getType());
		rttr.addAttribute("kw", pgvo.getKw());
		return "redirect:/";
	}
	
	@DeleteMapping(value="/file/{uuid}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> removeFile(@PathVariable("uuid") String uuid){
		
		return bsv.removeFile(uuid) > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK) 
				:new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
