package com.misson.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardVO {
	private long bno;
	private int category;
	private String bname;
	private String writer;
	private String description;
	private String regAt;
	private String modAt;
	private int readCount;
	private int cmtQty;
	private int fileCount;
}
