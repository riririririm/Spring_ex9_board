package com.rim.board.qna;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.rim.board.BoardDAO;
import com.rim.board.BoardVO;
import com.rim.util.PageMaker;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="QnaMapper.";


	//답글사전작업
	public int setReplyUpdate(QnaVO qnaVO) throws Exception {
		return sqlSession.update(NAMESPACE+"setReplyUpdate",qnaVO);
	}
	
	//답글
	public int setReply(QnaVO qnaVO) throws Exception {
		return sqlSession.update(NAMESPACE+"setReply", qnaVO);
	}
	
	@Override
	public int setWrite(BoardVO boardVO, List<MultipartFile> files,  HttpSession session) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setWrite", boardVO);
	}

	@Override
	public int setDelete(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"setDelete",num);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setUpdate", boardVO);
	}

	@Override
	public BoardVO getSelect(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getSelect",num);
	}


	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE, pageMaker);
	}

	@Override
	public List<BoardVO> getList(PageMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return  sqlSession.selectList(NAMESPACE+"getList",pageMaker);
	}

	

}
