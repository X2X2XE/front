package com.ezenplate.www.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@NoArgsConstructor
public class ReviewVO {
	private long sno;
	private long rno;
	private float rate;
	private String regAt;
	private String modAt;
	private String content;
	private int report;
	private String writer;
	private String title;
}
