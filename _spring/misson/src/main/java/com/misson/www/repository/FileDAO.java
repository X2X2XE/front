package com.misson.www.repository;

import java.util.List;

import com.misson.www.domain.FileVO;



public interface FileDAO {
	int insertFile(FileVO fvo);
	int insert_user_th(FileVO file);
	List<FileVO> selectListFile(long pno);

	int deleteFile(String uuid);
	int deleteAllFile(long pno);
	
	FileVO selectFile(String email);
	List<FileVO> selectAllFiles();
	
}