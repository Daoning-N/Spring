<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>http://localhost:8080/프로젝트명/sampleInsert?msg=값확인해주세요 요청을 하고</h3>
<h3>디스패치가 sampleController에 있는 sampleInsert를 메서드로 이동해서</h3>
<h3>msg값을 ModelAttribute에 저장을 해서</h3>
<h3>현재 페이지를 클라이언트에게 제공한 화면이 이 화면입니다.</h3>
<h3>@ModelAttribute("msg")에 선언된 이름을 변수로</h3>
<h3>컨트롤러로 부터 전달받은 msg 값은 ${msg }</h3>
</body>
</html>