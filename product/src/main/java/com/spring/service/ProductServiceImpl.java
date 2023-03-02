package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.domain.ProductVO; //DAO에서 추가
import com.spring.dao.ProductDAO; //DAO는 Service에 추가

@Service
public class ProductServiceImpl implements ProductService{
	//DAO Impl 복붙
	//Service는 Test 불가
	//DAO 주입 => Service에서 사용
	
	@Inject
	private ProductDAO dao; //Service 에 DAO 주입
	
	@Override
	public List<ProductVO> list() throws Exception{
		//DAO에 있는 메서드를 지정
		return dao.list();//service->dao 에 메서드 지정
	}
	public void write(ProductVO vo) throws Exception{
		dao.write(vo);	
	}
	public ProductVO view(int num) throws Exception{
		//parameter type => 입력인수를 지정
		return dao.view(num);
	}
	public void modify(ProductVO vo) throws Exception{
		dao.modify(vo);
	}
	public void delete(int num) throws Exception{
		dao.delete(num);
	}

}
