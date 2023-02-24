//root에 bean을 이용해서 데이터베이스 환경을 설정했을 경우
//환경 설정으로 데이터베이스가 연동되는지 확인

package com.aaa.sampleconfig;

import java.sql.Connection;

import javax.inject.Inject; //bean을 주입시켜주는 라이브러리
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith; //현재 클래스를 JUnit에서 사용할 스프링으로 연결

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; //스프링으로 연동
import org.springframework.test.context.ContextConfiguration; //context환경파일

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DataSourceTest {
   //xml파일에 있는 bean을 사용할 때는 반드시 Inject로 주입 해야함
   //bean에 있는 id 기준
   //bean에서 dataSource를 읽어와서 ds에 주입
   @Inject
   private DataSource ds;
   
   @Test
   public void testConnection() throws Exception {
      try {
         Connection con = ds.getConnection();
         System.out.println(con);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}