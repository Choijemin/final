<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">메시지 전송</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		</div>
</div>
<form class="form-signin"
		action="${pageContext.servletContext.contextPath }/send.do" method="post">
		<p style="font-size: small;">
			받을 사람과 내용을 입력 해주세요.<br/>
		</p>
		<c:if test="${!empty err }">
			<div class="alert alert-danger" role="alert" style="width: 300px;">
				받을 사람과 내용을 입력해주세요.
			</div>
		</c:if>
		<p>
			받을사람(*)<br>
			<input type = "text" name = "receiver" style="width: 220px; "/>
		</p>
		<p>
		<label for="text" class="sr-only">내용</label> 
		<input
			type="text" id="inputContent" required name="content" style="height: 300px; width: 250px;">
		</p>
	
		<br>
		<button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 250px;">
			전송</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2018 MOCKING CORP</p>
	</form>
</div>