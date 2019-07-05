package com.rim.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.rim.util.PageMaker;


public interface BoardDAO {

	//글 등록
		public int getTotalCount(PageMaker pageMaker)throws Exception;
		
		public int setWrite(BoardVO boardVO, List<MultipartFile> files,  HttpSession session) throws Exception;
		
		public int setDelete(int num)throws Exception;
		
		public int setUpdate(BoardVO boardVO) throws Exception;
		
		public BoardVO getSelect(int num) throws Exception;
		
		public List<BoardVO> getList(PageMaker pageMaker) throws Exception;

		
}
