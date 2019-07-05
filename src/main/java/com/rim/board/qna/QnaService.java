package com.rim.board.qna;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.rim.board.BoardDAO;
import com.rim.board.BoardVO;
import com.rim.file.FileDAO;
import com.rim.file.FileVO;
import com.rim.util.FileSaver;
import com.rim.util.PageMaker;

import oracle.net.aso.p;

public class QnaService implements BoardDAO{

	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setWrite(BoardVO boardVO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		//qna Insert
		int result = qnaDAO.setWrite(boardVO, multipartFiles, session);
		String realPath = session.getServletContext().getRealPath("/resources/qna");
		
		//file Insert
		
		//num = boardVO.getNum();
		//oname = multipartFile.getOriginalName();
		//fname= fileSaver.savefile(realPath, multipartFile)
		ArrayList<FileVO> files = new ArrayList<FileVO>();
		for(MultipartFile file: multipartFiles) {
			if(file.getOriginalFilename().length()>0) {
				FileVO fileVO = new FileVO();
				fileVO.setNum(boardVO.getNum());
				fileVO.setOname(file.getOriginalFilename());
				fileVO.setFname(fileSaver.saveFile(realPath, file));
				files.add(fileVO);
			}
		}
		fileDAO.setWrite(files);
		
		return 0;
	}

	@Override
	public int setDelete(int num) throws Exception {
		
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getSelect(int num) throws Exception {
		
		return qnaDAO.getSelect(num);
	}

	@Override
	public List<BoardVO> getList(PageMaker pageMaker) throws Exception {
		// 1.startRow, lastRow
		pageMaker.makeRow();
		List<BoardVO> lists=qnaDAO.getList(pageMaker);
		
		// 2.paging, totalCount
		int totalCount = qnaDAO.getTotalCount(pageMaker);
		pageMaker.makePage(totalCount);
		
		return lists;
	}
	
	//reply
	public int setReply(QnaVO qnaVO) throws Exception {
		//1. 사전작업
		int result = qnaDAO.setReply(qnaVO);
		//2. insert
		result = qnaDAO.setReply(qnaVO);
		
		return result;
	}

}
