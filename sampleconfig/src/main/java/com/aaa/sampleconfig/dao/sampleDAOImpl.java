package com.aaa.sampleconfig.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession; //mybatis를 이용해서 SQL 사용
import org.springframework.stereotype.Repository;

import com.aaa.sampleconfig.domain.sampleVO;

//DAO는 repository 어노테이션 선언
@Repository
public class sampleDAOImpl implements sampleDAO {
	//root-context.xml의 빈을 사용할 때는 Inject 어노테이션으로 선언
	@Inject
	private SqlSession sqlSession;
	
	//사용할 mapper 지정
	private static final String NAMESPACE ="com.aaa.sampleconfig.mapper.BoardMapper";
	//붙여넣기 후 ';'삭제 후 {} 추가
	
	//인터페이스의 내용을 수정
	//Override 생략 가능
	@Override
	public void create(sampleVO samplevo) throws Exception{
		//mybatis의 질의어를 이용해서 작업지시
		//sqlSession(DB)+NAMESPACE(질의어)
		//sqlSession.질의어(batis+".질의어id", 전달값)
		//member_Mapper에 create 질의어를 sqlSession DB에 insert(삽입)작업으로 전달
		sqlSession.insert(NAMESPACE+".create",samplevo);
	}
	@Override
	//여러개 사용 시 List<sampleVO> -> DAO파트 참고하기
	public sampleVO allList() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".allList");
	}
	@Override
	public sampleVO whereList(String name) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".whereList", name);
	}
	@Override
	public sampleVO ascList() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".ascList");
	}
	@Override
	public sampleVO descList() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".descList");
	}
	@Override
	public void update(sampleVO vo) throws Exception{
		sqlSession.update(NAMESPACE+".update",vo);
	}
	@Override
	public void delete(String name) throws Exception{
		sqlSession.delete(NAMESPACE+".delete", name );
	}
}
