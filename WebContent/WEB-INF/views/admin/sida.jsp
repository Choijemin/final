<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul class="nav flex-column">
	<li class="nav-item"><a class="nav-link disabled" href="#">회사소개</a></li>
	<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/change.do">비밀번호 변경</a></li>
	<li class="nav-item"><a class="nav-link" href="#">쪽지함</a></li>
	<li class="nav-item"><a class="nav-link" href="#">쪽지보내기</a></li>
</ul>
	<div id="alert" style="font-size: .75em">
			
	</div>

	<script>
		var ws = new WebSocket("ws://" + location.host + "${pageContext.servletContext.contextPath}/alert.do");
		ws.onmessage = function(evt) {
			var obj = JSON.parse(evt.data);
			switch (obj.mode) {
			case "login":
				loginAlertHandle(obj);
				break;
			case "overlap":
				overlapHandle(obj);
			}
		};
		var loginAlertHandle = function(obj) {
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>로그인</strong> " + obj.actor.NAME + "("
					+ obj.actor.DNAME + "/" + obj.actor.PNAME + ")";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		}
		
		var overlapHandle = function(obj) {
			window.alert("다른 기기에서 로그인이 되었습니다.\n 새로고침을 눌러주세요.");	
		}
	</script>