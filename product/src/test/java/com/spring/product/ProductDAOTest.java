//여기서 오류바면 보통 DAOImpl 또는 Mapper을 중점적으로 확인
//오류 발생 시 구간별로 주석처리 후 run 돌리기
package com.spring.product;

import com.spring.domain.ProductVO;
import com.spring.dao.ProductDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class ProductDAOTest {
	  @Inject
	    private ProductDAO productDAO;

	    private static Logger logger = LoggerFactory.getLogger(ProductDAOTest.class);
	    
	    //DAO에 선언된 메서드를 모두 조작
	    @Test
	    public void testWrite() throws Exception {
	    		logger.info("저장 작업 성공!!!");
	            ProductVO productVO = new ProductVO();
	            productVO.setProduct("테스트상품");
	            productVO.setPrice(10000);
	            productVO.setQuantity(100);
	            productVO.setCompany("테스트회사");
	            productDAO.write(productVO);
	            
	    }

	    @Test
	    public void testList() throws Exception {
	    	logger.info("조회 작업 성공!!!");
	        productDAO.list();
	    }
	    
	    @Test
	    public void testView() throws Exception {
	    	logger.info("1개 조회 성공!!!");
	    	productDAO.view(1);
	    }

	    @Test
	    public void testUpdate() throws Exception {
	    	logger.info("수정 작업 성공!!!");
	        ProductVO productVO = new ProductVO();
	        productVO.setNum(1);
            productVO.setProduct("수정테스트상품");
            productVO.setPrice(9999);
            productVO.setQuantity(999);
            productVO.setCompany("수정테스트회사");
	        productDAO.modify(productVO);
	    }

	    @Test
	    public void testDelete() throws Exception {
	    	logger.info("삭제 작업 성공!!!");
	        productDAO.delete(2);
	    }
}
