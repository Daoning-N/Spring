//페이지 연결이 안되는 경우 servlet-config.xml
package com.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;
import com.spring.domain.ProductVO;
import com.spring.service.ProductService;

@Controller
public class ProductController {
	//Service 주입 => Controller에서 사용
	@Inject
	private ProductService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	/*1.페이지 연결
	 * (기본) JSP(디자인)->Controller연결->DB->VO->MyBatis->DAO->Service->Controller
	 * (현재수업) DB->VO->MyBatis->DAO->Service->Controller->JSP
	 * 
	 * 2.RequestMapping("접근자") -> get,post 구분없이 접근
	 * RequestMapping(value="접근자", method="전달방식") -> get,post 2가지로 접근
	 * get->첫화면 접근, 결과
	 * post->form을 이용한 값을 전달해서 처리
	 */
	
	//Service의 메소드나 jsp 파일명과 동일 또는 유사하게
	//클라이언트 -> 서버로 전달하는 방식은 2가지 존제(GET,POST)
	//기본 전달방법은 POST	
	//일반적으로 접근했을 때
	@RequestMapping(value="/list",method=RequestMethod.GET)
	//@RequestMapping("/list") -> get,post 상관없이 연결
	public void ListGET(Model model) throws Exception{ //페이지에 값을 전달한 필요가 있으면
		//list는 입력받는 것이니 post가 필요없음 따라서 get
		
		logger.info("list 호출중...");
		
		List<ProductVO> vo = null;
		vo = service.list(); //DB에 접근해서 데이터목록을 읽어옴
		model.addAttribute("list", vo); //list로 값을 전달
		//void => value-"/list"=>list.jsp 연결
		//한 부분 당 페이지 하나씩 연결하는 것, 한 부분 끝날때 테스트 해보기
		//test: 주소 뒤에 list입력
		//servler-context 에 해당 controller 추가 돼 있는지 확인 할 것
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public void ViewGET(@RequestParam("num")int num, Model model) throws Exception{
		ProductVO vo = null;
		vo = service.view(num);
		model.addAttribute("view",vo);
	}
	//메뉴나 버튼으로 저장화면으로 이동할 때 넘어오는 창
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public void WriterGET(Model model) throws Exception{
		//Model : 화면에 Controller에서 작업한 값을 전달하고 싶을 때 사용(필요없으면 생략 가능)
		//연결 후 특별한 작업이 없다.
	}
	//저장화면에서 저장버튼을 클릭했을 때 넘어오는 창
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String WritePOST(ProductVO vo) throws Exception{
		//입력폼에서 입력한 내용을 ProductVO로 전달 후
		//전달받은 데이터를 DB에 저장
		//작업 후 목록페이지로 이동
		service.write(vo);
		
		//return 명령을 사용하고 싶으면 String로 꼭 변경해야함
		return "redirect:/list"; // -> @RequestMapping 에서 /list를 사용하는 메서드로 이동
	}
	
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void ModifyGET(@RequestParam("num")int num, Model model) throws Exception{
		//Controller  처리한 결과값을 페이지에 전달하려고 하면 Model이 필요
		//해당번호의 레코드를 읽어와서
		//읽어온 레코드를 수정페이지에 전달
		ProductVO vo = service.view(num);
		
		model.addAttribute("view",vo); //페이지에 저장된 vo값을 view라는 이름으로 전달,${이름이 같아야 함}
	}
	//수정버튼을 눌렀을 때
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String ModifyPOST(ProductVO vo) throws Exception{
		service.modify(vo);
		
		return "redirect:/list";
	}
	//./delete?		num=123
	//@RequestParam(num) 		===> int num에 저장
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteGET(@RequestParam("num")int num) throws Exception{
		//서비스를 이용해서 삭제를 진행
		service.delete(num);//->해당하는 번호의 레코드를 삭제
		
		return "redirect:/list"; //value와 다른 페이지 이동시 redirect 이용
	} 
}
