package com.spring.dao;

import java.util.List;
import com.spring.domain.ProductVO;

public interface ProductDAO {
	//Mybatis내에 질의어 개수만큼
	//메소드명은 mybatis에 있는 id명과 동일 또슷 비슷하게
	//parameterType, resultType
	
	//목록
	//		resultType			()=parameterType
	public List<ProductVO> list() throws Exception;
	
	//삽입
	public void write(ProductVO vo) throws Exception;
	
	//개별조회
	public ProductVO view(int num) throws Exception;
	
	//수정
	public void modify(ProductVO vo) throws Exception;
	
	//삭제
	public void delete(int num) throws Exception;
}
