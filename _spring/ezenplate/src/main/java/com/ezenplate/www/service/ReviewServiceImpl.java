package com.ezenplate.www.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezenplate.www.domain.FileVO;
import com.ezenplate.www.domain.PagingVO;
import com.ezenplate.www.domain.ReviewDTO;
import com.ezenplate.www.domain.ReviewVO;
import com.ezenplate.www.repository.FileDAO;
import com.ezenplate.www.repository.ReviewDAO;
import com.ezenplate.www.repository.StoreDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

	@Inject
	private ReviewDAO rdao;
	@Inject
	private StoreDAO sdao;
	@Inject
	private FileDAO fdao;

	@Override
	public int register(ReviewDTO rdto) {
		int isUp = rdao.insert_review(rdto.getRvo());
		if (rdto.getFileList() != null) {
			if (isUp > 0 && rdto.getFileList().size() > 0) {
				long rno = rdao.select_last_rno();
				for (FileVO fvo : rdto.getFileList()) {
					fvo.setRno(rno);
					isUp *= fdao.insert_review_file(fvo);
				}
			}
		}
		sdao.up_cmt(rdto.getRvo().getSno());
		return isUp;
	}

	@Override
	public List<ReviewDTO> get_list(long sno) {
		List<ReviewDTO> dto = new ArrayList<ReviewDTO>();
		List<ReviewVO> rvo = rdao.review_list(sno);
		float rate = 0;
		int i=0;
		for (ReviewVO reviewVO : rvo) {
			List<FileVO> fvo = fdao.select_review(reviewVO.getRno());
			dto.add(new ReviewDTO(reviewVO, fvo));
			rate +=reviewVO.getRate();
			i++;
		}
		sdao.request_rate(rate/i, sno);
		return dto;
	}

	@Override
	public ReviewDTO get_review(long rno) {
		ReviewVO rvo = rdao.get_review(rno);
		List<FileVO> fvo = fdao.select_review(rno);

		return new ReviewDTO(rvo, fvo);
	}

	@Override
	public int remove(long rno) {
		int isUp = rdao.delete_review(rno);
		if (isUp > 0) {
			fdao.delete_review_File(rno);
			log.info("review_delete !!!!");
		}
		return isUp;
	}

	@Override
	public int modify(ReviewDTO rdto) {
		int isUp = rdao.update(rdto.getRvo());
		if (rdto.getFileList() != null) {
			if (isUp > 0 && rdto.getFileList().size() > 0) {
				for (FileVO fvo : rdto.getFileList()) {
					fvo.setRno(rdto.getRvo().getRno());
					isUp *= fdao.insertFile(fvo);

				}
			}
		}
		return 0;
	}

	@Override
	public void report(long rno) {
		rdao.update_report(rno);

	}
	
	
	
	@Override
	public List<ReviewVO> getList(PagingVO pgvo) {
		return rdao.selectList(pgvo);
	}

	@Override
	public ReviewDTO getDetail(long rno) {
		return new ReviewDTO(rdao.selectOne(rno), fdao.selectReviewListFile(rno));
	}

	
	@Override
	public int getTotalCount(PagingVO pgvo) {
		return rdao.selectTotalCount(pgvo);
	}

	@Override
	public int removeFile(String uuid) {
		return fdao.deleteFile(uuid);
	}
	
	

}