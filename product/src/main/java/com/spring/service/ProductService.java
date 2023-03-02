package com.spring.service;

import java.util.List;

import com.spring.domain.ProductVO;

public interface ProductService {
	//DAO = Service (복붙)
	public List<ProductVO> list() throws Exception;
	public void write(ProductVO vo) throws Exception;
	public ProductVO view(int num) throws Exception;
	public void modify(ProductVO vo) throws Exception;
	public void delete(int num) throws Exception;

}
