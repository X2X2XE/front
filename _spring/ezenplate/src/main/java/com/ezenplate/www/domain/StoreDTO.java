package com.ezenplate.www.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class StoreDTO {
	private StoreVO svo;
	private List<FileVO> fileList;
}
