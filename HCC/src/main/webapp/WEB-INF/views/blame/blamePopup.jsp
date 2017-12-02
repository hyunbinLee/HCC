<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript" src="resources/js/blame.js"></script>


</head>
<body>


	<select name="blame_type" id="blame_type">
		<option value="1" >하나 </option>
		<option value="2" >둘 </option>
		<option value="3" >셋 </option>
		<option value="4" >넷 </option>
		<option value="5" >다섯 </option>
		<option value="6" >여섯</option>
	</select>
	<br/>
	<textarea rows="10" cols="40" name="blame_content" id="blame_content"></textarea>
	<br/>
	
	<button onclick="insertBlameAction()">신고하기</button>


</body>
</html>