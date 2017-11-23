<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.2.0.min.js"></script>


<script>

$(function(){
	

	$("#back").click(function(){
		
		window.location.replace("/hcc/main");
		
	});
});

function checkList(){
	
	
	if(!$("#s_userid").is(":checked")){
		alert("채팅 할 대상이 없거나 선택되지 않았습니다.");
		window.location.replace("/hcc/main");
		return false;
	}

	return true;
	
}

</script>
</head>
<body>
<h1>사용자를 선택해 주세요</h1>

<c:url value="/chatting" var="chattingPage"></c:url>
<form action="${chattingPage }" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

<c:forEach items="${userList }" var="list">
<c:if test="${list ne currentuserid}">
<input type="radio" name="s_userid" id="s_userid" value="${list }">${list }<br/>
</c:if>
</c:forEach>

<c:if test="${userList eq null }">
<div id="errorMessage">로그인한 사용자가 없습니다.</div>
</c:if>

<input type="submit" id="gochatting" value="채팅하기" onclick="return checkList()" >

<c:if test="${userList eq null }">
<input type="button" id="back" value="메인으로" onclick="back()">
</c:if>

</form>

</body>
</html>