//Controller은 각 테이블별로 생성, 몇개를 만들어도 상관 없음
//서블렛은 클래스가 하나의 컨트롤, 스프링은 메서드가 하나의 컨트롤로 동작
//Mapper.xml -> DAO -> DAOImpl -> Service - >ServiceImpl -> 다시 Controller 추가작업
//Controller은 Service만 불러올 수 있기에 Service 사용 반대로 Service는 DAO만 불러올 수 있기에 DAO 사용
package com.aaa.sampleconfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aaa.sampleconfig.domain.sampleVO;
import com.aaa.sampleconfig.service.sampleService;

import javax.inject.Inject;

//생략가능(println문 대신 사용하기 위함)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//1.view에 있는 페이지와 연결 작업
//2.service 를 이용해서 페이지에 값을 주고받기 위함
//해당클래스가 컨트롤인지 등록
@Controller
public class sampleController {
	//해당 클래스에 대한 로그 변수를 선언
	private static final Logger logger = LoggerFactory.getLogger(sampleController.class);
	
	@Inject
	private sampleService samService;
	
	//1.웹페이지 연결하는 기본연결방식
	//주소창에서 접속할 값을 등록
	//http://localhost:3306/sampleconfig/sampleList(이 마지막 부분이 하단""과 똑같으면 아래 메서드 실행) 접속시
	//주소창에 마지막단어가 sampleList이면 아래 메서드를 실행
	
	//method 사용 방법 1.@RequestMapping("값") 2.@RequestMapping(value="값", method="전달방식")
	//JSP에 값을 전달하고 싶을 때는 Mobel 인수 선언
	@RequestMapping(value="sampleList", method = RequestMethod.GET)
	
	public void sampleList(Model model) throws Exception {//작업하고자 하는 메소드(요청받아서 해당 페이지를 연결)
		logger.info("sampleList로 접속을 했습니다.");
		//요청한 페이지에 값을 전달하기 위해 저장
		//addAttribute(저장할 변수명, 값)
		//DB처리가 필요하면 서비스를 통해서 DB 처리
		//모든데이터를 검색해서 sampleVO에 저장해서 요청페이지에 전달
		//목록=>처리->목록
		model.addAttribute("sampleVO", samService.allList());
		//sampleList.jsp 페이지로 연결
	}

	//2.요청과 연결페이지 이름이 다른 경우
	//void -> String로 데이터형 변경 후 return 페이지이름 지정
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String edit(sampleVO vo, Model model) throws Exception {
		//logger.info() 는 console에 출력되는 부분
		logger.info("update로 접속을 했습니다.");
		//수정폼->처리->완료->수정확인창
		samService.update(vo);
		return "updateView";
	}
	
	//3.요청과 함께 값을 전달했을 때 해당페이지에 값을 재전달
	//Model=페이지, Attribute=변수&DTO 저장
	//Attribute 는 jsp에서 $로 전달
	//String msg에 있는 값을 ModelAttribute("msg")저장
	//form에서 input 태그에 입력된 값들을 전달받음
	@RequestMapping(value="sampleInsert", method=RequestMethod.POST)
	//                       전달받을 값이 저장, 페이지 정보  , 작업완료 후 다른페이지 이동
	public String sampleInsert(sampleVO vo, Model model, RedirectAttributes rttr) throws Exception {//주소로부터 msg변수로 값을 전달받는다.
		logger.info("msg값을 전달했습니다.");
		//삽임폼->처리->완료->목록
		samService.create(vo); //삽입처리
		//형식적 선언
		rttr.addFlashAttribute("msg","INSERT"); //다른페이지로 이동할 때 전달할 메세지
		return "redirect:/sampleList";
	}
	
	//4.DB의 DTO 결과물을 해당페이지에 전달, 목록, 상세페이지 구현
	//편한 곳에 VO 생성
	//DTO로 값을 전달할 때는 반드시 Model 선언
	
	//삭제나 부분조회, 수정할 레코드 조회 -> 기본키 값만 가져와서 처리
	//http://localhoset:8080/delete?name=홍길동
	@RequestMapping("sampleDelete")
	//메서드 1개가 하나의 페이지(JSP)
	//                           저장               '?'전달받은 값
	public String sampleDelete(@RequestParam("name") String name, Model model) throws Exception {
		logger.info("DTO의 값을 전달했습니다.");
		//dto 생성하고 기본값을 저장
		samService.delete(name);
		//전달페이지에 변수를 추가 ==> samVO DTO를
		return "sampleDeleteResult"; // DB 사용하고 페이지 이동할거면 redirect:/ 사용
	}
}
