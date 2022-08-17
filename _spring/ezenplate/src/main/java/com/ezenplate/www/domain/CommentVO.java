package com.ezenplate.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentVO {
	private long cno;
	private long bno;
	private String writer;
	private String content;
	private int report;
	private String regAt;
	private String modAt;
}
