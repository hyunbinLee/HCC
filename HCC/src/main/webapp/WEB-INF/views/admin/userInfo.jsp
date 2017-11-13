<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<br/>아이디: ${user.user_id }
<br/>이름:${user.user_name }
<br/>성별:${user.user_gender }
<br/>회원 구분:${user.user_kind }
<br/>생년월일:${user.user_birth }
<br/>전화번호:${user.user_phone }
<br/>이메일:${user.user_email }
<br/>신고 횟수:${user.user_blame_cnt }

<br/><br/>

<a href="./deleteUser?id=${user.user_id }">탈퇴</a> &nbsp;&nbsp;
<a href="./memberManagement">회원목록</a> &nbsp;&nbsp;
<form action="./changePassword" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" id="id" name="id" value = "${user.user_id }">
	<input type="text" id="newPassword" name="newPassword" width="10">
	<input type="submit" value="비밀번호 변경">
</form>

</body>
</html>