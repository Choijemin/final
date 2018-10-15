<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">ChatRoom</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary">Share</button>
			<button class="btn btn-sm btn-outline-secondary">Export</button>
		</div>
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> This week
		</button>
	</div>

</div>
	
<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th>#</th>
				<th>채팅</th>
			</tr>
		</thead>
	</table>
</div>
<h4>Chat Room <small>(All Departments)</small></h4>
<div style="height: 520px; overflow-y: scroll; " id = "chatView">
	
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">CHAT</span>
  </div>
  <input type="text" class="form-control" aria-describedby="basic-addon1" id = "input">
</div>
<script>
	var chatws = new WebSocket("ws://" + location.host + "${pageContext.servletContext.contextPath}/chat.do");
	
	chatws.onmessage= function(evt) {
		console.log(evt.data);
		var obj = JSON.parse(evt.data);
		switch(obj.mode) {
		case "public":
			publicHandle(obj);
			break;
		}
	} 
	var publicHandle = function(obj) {
		var txt = obj.text;
		var html = "<div class=\"alert alert-success\" role=\"alert\" style=\"padding:3px; margin-bottom:3px;\">";
		html += obj.text;
		html +="</div>";
		
		document.getElementById("chatView").innerHTML += html 
			+"<div style=\"text-align:right\"><small>" + obj.id + "(" + obj.name + "/" + obj.dname + "/" + obj.pname + ")" + "</div></small>";
		document.getElementById("chatView").scrollTop = document.getElementById("chatView").scrollHeight; 
	}
	
	document.getElementById("input").onchange= function() {
		console.log(this.value);
		var msg = {
			"mode":"public",
			"text":this.value,
			"id":"${log.ID}",
			"name":"${log.NAME}",
			"dname":"${one.DNAME}",
			"pname":"${one.PNAME}"
			
		};
		chatws.send(JSON.stringify(msg));
		this.value="";
	};
	
	
	
	
	
</script>
	
	