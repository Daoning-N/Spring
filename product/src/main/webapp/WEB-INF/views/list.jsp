<!-- section제외 부분 작업 후 따로 form 저장(기본 뼈대) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 명령어를 이용해서 jsp 구성 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- ㄴ format을 이용해서 데이터값의 모양을 꾸미기 -->
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 현재 페이지는 섹션을 사용하지 않음 -->
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<!-- ㄴ HTML을 구성하는 언어(생략가능) -->
<head>
<!-- 부트스트랩에서 긁긁 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- ㄴ 부트스트랩 스타일시트를 이용해서 모양 꾸밈 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- ㄴ 부트스트랩에 있는 JQuery를 이용한 자바스크립트 이용(애니메이션효과) -->
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>

<section>
	<div class="container mt-3">
		<h2>게시물 목록</h2>
		<p>현재 등록된 상품들의 목록입니다.</p>
		<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>제조사</th>
				<th>작업</th>
				<th>버튼</th>
			</tr>
		</thead>
		<tbody>
		<!-- ㄴ 작업영역, 읽어온 데이터 갯수만큼 반복적으로 행을 구성 -->
			<c:forEach items="${list }" var="list">
				<tr>
				<!-- td부분 modal.attribute에 이름과 VO에 있는 변수명으로 조합 -->
					<td>${list.num }</td>
					<td>${list.product }</td>
					<td>${list.price }</td>
					<td>${list.quantity }</td>
					<td>${list.company }</td>
					<td><a href="./modify?num=${list.num }">수정</a>
					<td><a href="./delete?num=${list.num}">삭제</a></td>
					<td><button type="button" onclick="location.href='./modify?num=${list.num}'">수정</button></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</section>
</body>
</html>