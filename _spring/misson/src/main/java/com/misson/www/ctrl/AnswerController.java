package com.misson.www.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misson.www.domain.AnswerVO;
import com.misson.www.domain.PagingVO;
import com.misson.www.handler.PagingHandler;
import com.misson.www.service.AnswerService;

@RequestMapping("/answer/*")
@Controller
public class AnswerController {
	private static Logger log = LoggerFactory.getLogger(AnswerController.class);
	
	@Inject
	private AnswerService asv;

	
	
	@DeleteMapping(value="/{cno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete(@PathVariable("cno") long cno){
		return asv.remove(cno) > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PutMapping(value="/{cno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> edit(@PathVariable("cno") long cno,
			@RequestBody AnswerVO avo){
		return asv.modify(avo) > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/{bno}/{pageNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PagingHandler> spread(@PathVariable("bno") long bno,
			@PathVariable("pageNo") int pageNo){
		PagingVO pgvo = new PagingVO(pageNo, 10);
		
		return new ResponseEntity<PagingHandler>(asv.spread(bno, pgvo), HttpStatus.OK);
	}
	
	@PostMapping(value = "/post", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> post(@RequestBody AnswerVO avo){	
		return asv.post(avo) > 0 ? 
				new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
