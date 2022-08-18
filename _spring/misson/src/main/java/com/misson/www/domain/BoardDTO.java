package com.misson.www.domain;

import lombok.ToString;

import lombok.Setter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BoardDTO {
	
	private BoardVO bvo;
	private List<FileVO> fileList;
}
