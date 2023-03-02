<!-- 
1.write.jsp 작업 -> 2.productController '/write'부분 작업 -> 3.menu.jsp 상품등록 href부분 경로 지정"./write"
 -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>프로젝트</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<!-- ㄴ 가져올 파일 생성 -->
<section>
<!-- 부트스트랩 forms에서 긁긁 -->
	<div class="container mt-3" style="max-width:500px;">
	<h2>상품등록</h2>
	<!-- action="접근자" method="전달방식" -->
		<form action="./write" method="post">
			<div class="mb-3 mt-3">
				<label for="product" class="form-label">제목</label>
				<input type="text" id="product" name="product" class="form-control" placeholder="상품명을 입력하세요.">
			</div>
			<div class="mb-3">
				<label for="price" class="form-label">가격</label>
				<input type="number" id="price" name="price" class="form-control">
			</div>
			<div class="mb-3">
				<label for="quantity" class="form-label">수량</label>
				<input type="number" id="quantity" name="quantity" class="form-control">
			</div>
			<div class="mb-3">
				<label for="company" class="form-label">제조사</label>
				<input type="text" id="company" name="company" class="form-control">
			</div>
			<button type="submit" class="btn btn-primary">저장</button>
			<button type="reset" class="btn btn-secondary">새로작성</button>
		</form>
	  
	</div>
</section>
</body>
</html>