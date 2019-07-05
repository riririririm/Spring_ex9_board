package com.rim.file;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rim.board.BoardVO;
import com.rim.util.FileSaver;

@Service
public class FileService {
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;

	public int setDeleteByNum(int num) throws Exception {
		return fileDAO.setDeleteByNum(num);
	}
	
	public int setDelete(int fnum) throws Exception {
		return fileDAO.setDelete(fnum);
	}

	public int setWrite(BoardVO boardVO, MultipartFile f1, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("/resources/upload");

		ArrayList<FileVO> files = new ArrayList<FileVO>();

		String fname = fileSaver.saveFile(realPath, f1);
		FileVO fileVO = new FileVO();
		fileVO.setNum(boardVO.getNum());
		fileVO.setFname(fname);
		fileVO.setOname(f1.getOriginalFilename());
		files.add(fileVO);

		return fileDAO.setWrite(files);
	}
}
