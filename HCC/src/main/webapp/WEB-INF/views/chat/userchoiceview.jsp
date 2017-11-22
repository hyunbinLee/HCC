<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사용자를 선택해 주세요</h1>

<c:url value="/chatting" var="chattingPage"></c:url>
<form action="${chattingPage }" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<c:forEach items="${userList }" var="list">
<input type="radio" name="s_userid" id="s_userid" value="${list }">${list }<br/>
</c:forEach>

<input type="submit" value="채팅하기">

</form>

</body>
</html>