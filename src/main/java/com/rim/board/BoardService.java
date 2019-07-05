package com.rim.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.rim.util.PageMaker;

public interface BoardService {

	public int setWrite(BoardVO boardVO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception;
	
	public int setDelete(int num)throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public BoardVO getSelect(int num) throws Exception;
	
	public List<BoardVO> getList(PageMaker pageMaker) throws Exception;
}
