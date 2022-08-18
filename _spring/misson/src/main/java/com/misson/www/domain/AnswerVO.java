package com.misson.www.domain;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//@Data // 불필요한 기능까지 선언하므로 추천하지 않는다
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class AnswerVO {
	private long cno;
	private long bno;
	private String writer;
	private String content;
	private String regAt;
	private String modAt;
	
	
}
