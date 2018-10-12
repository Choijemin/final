<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/signin.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<title>그룹웨어</title>
<body class="text-center">
	<form class="form-signin"
		action="${pageContext.servletContext.contextPath }/login.do"
		method="post">
		<img class="mb-4"
			src="${pageContext.servletContext.contextPath }/image/logo.PNG"
			alt="" width="150" height="130">
		<h1 class="h3 mb-3 font-weight-normal">GROUP WARE</h1>
		<p style="font-size: small;">
			해당 사용자 계정의 비밀번호를 변경합니다.<br/>
		</p>
		<label for="inputEmail" class="sr-only">기존 비밀번호</label> <input
			type="password" id="inputPassword" class="form-control"
			placeholder="기존 비밀번호" required autofocus name="pass"> 
			<br>
		<label for="inputPassword" class="sr-only">새 비밀번호</label> 
		<input
			type="password" id="inputPassword" class="form-control"
			placeholder="사원 비밀번호" required name="newpass">
			<br>
		<label for="inputPassword" class="sr-only">비밀번호 재확인(*)</label> 
		<input
			type="password" id="inputPassword" class="form-control"
			placeholder="비밀번호 재확인" required>
		<br>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			비밀번호 변경</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2018 MOCKING CORP</p>
	</form>
</body>
</html>