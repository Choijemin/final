<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>사원등록</h1>
<form>
<div class="form-group" action="${pageContext.servletContext.contextPath }/admin/employee/add.do" method="post">
		<label>사원 이름</label> 
		<input type="text" class="form-control" placeholder="이름을 입력하세요." name = "nick">
	</div>
	<div class="form-group">
		<label>부서</label>
		<div class="row">
			<div class="col">
				<select class="form-control" name = "dpart">
					<c:forEach var = "d" items="${depart }">
						<option value="${d }">${d }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<select class="form-control" name = "pst">
					<c:forEach var = "p" items="${position }">
						<option value="${p }">${p }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="form-group" name = "date">
		<label>입사일</label> <input
			type="date" class="form-control" placeholder="Another input">
	</div>
	<div class="form-group">
		<button type = "submit" class="form-control btn btn-outline-primary">사원등록</button>
</form>