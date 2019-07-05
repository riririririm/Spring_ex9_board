package com.rim.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="FileMapper.";
	
	public int setWrite(List<FileVO> files) throws Exception {
		return sqlSession.insert(NAMESPACE+"insert",files);
	}
	
	public int setSelect(int fnum) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect",fnum);
	}
	
	public int setDelete(int fnum) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete",fnum);
	}
	
public int setDeleteByNum(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"deleteByNum",num);
	}

}
