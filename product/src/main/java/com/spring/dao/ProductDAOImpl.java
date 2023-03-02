package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	//DAO에 복사
	//DB연결(빈에서 sqlSession 주입) -> DAO DB 작업,사용(질의어-mapper)
	//@AutoWired or @Inject 사용
	@Inject
	private SqlSession sql; //root-context.xml에 정보
	//DB 관련정보:id,pw
	//MyBatis에 오류 시 mybatis-config.xml, mappers폴더내의 파일 인식불능
	
	//사용할 mapper 지정
	//						productMapper.xml에 있는 namespace이름
	private static String namespace="com.spring.mappers.product";
	@Override
	public List<ProductVO> list() throws Exception{
		//batis에서 제공하는 메서드를 호출
		//ResultType가 있으면 return 사용(결과값이 있기 때문)
		//						Mybatis에 있는 id로 선언된 질의어 사용
		return sql.selectList(namespace+".list"); //사용할 mapper id 지정
	}
	@Override
	public void write(ProductVO vo) throws Exception{
		sql.insert(namespace+".write",vo);
	}
	@Override
	public ProductVO view(int num) throws Exception{
		//parameterType -> 입력인수를 지정
		return sql.selectOne(namespace+".view",num);
	}
	@Override
	public void modify(ProductVO vo) throws Exception{
		sql.update(namespace+".modify",vo);
	}
	@Override
	public void delete(int num) throws Exception{
		sql.delete(namespace+".delete",num);
	}
}
