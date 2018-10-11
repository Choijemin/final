<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>사원등록</h1>
<c:if test="${!empty err }">
<div class="alert alert-danger" role="alert">
   	DB 처리중에 문제가 발생하였습니다.
</div>
</c:if>
<form action="${pageContext.servletContext.contextPath }/admin/employee/add.do" method="post">
<div class="form-group" >
		<label>사원 이름</label> 
		<input type="text" class="form-control" placeholder="이름을 입력하세요." name = "name">
	</div>
	<div class="form-group">
		<label>부서</label>
		<div class="row">
			<div class="col">
				<select class="form-control" name = "did">
					<c:forEach var = "d" items="${depart }">
						<option value="${d.DID }">${d.DNAME }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<select class="form-control" name = "pid">
					<c:forEach var = "p" items="${position }">
						<option value="${p.PID }">${p.PNAME }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label>입사일</label> <input
			type="date" class="form-control" placeholder="Another input" name = "joindate">
	</div>
	<div class="form-group">
		<button type = "submit" class="form-control btn btn-outline-primary">사원등록</button>
</form>