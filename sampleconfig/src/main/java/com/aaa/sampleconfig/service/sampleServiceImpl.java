package com.aaa.sampleconfig.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.aaa.sampleconfig.domain.sampleVO;
import com.aaa.sampleconfig.dao.sampleDAO;

@Service
public class sampleServiceImpl implements sampleService {
	//뼈대 DAO(인터페이스)->동작 클래스
	//inject가 뼈대를 끌고와 연동해줌
		@Inject
		private sampleDAO dao;
	
		@Override
		public void create(sampleVO samplevo) throws Exception{
			dao.create(samplevo); //dao에서 만든 메서드 중에서 사용하고 싶은 메서드를 지정
		}
		@Override
		public sampleVO allList() throws Exception{
			return dao.allList();
		}
		@Override
		public sampleVO whereList(String name) throws Exception{
			return dao.whereList(name);	
		}
		@Override
		public sampleVO ascList() throws Exception{
			return dao.ascList();
		}
		@Override
		public sampleVO descList() throws Exception{
			return dao.descList();
		}
		@Override
		public void update(sampleVO vo) throws Exception{
			dao.update(vo);
		}
		@Override
		public void delete(String name) throws Exception{
			dao.delete(name);
		}

}
