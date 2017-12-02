<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="resources/js/blame.js"></script>


</head>
<body>


	<select name="blame_type" id="blame_type">
		<option value="1" >a </option>
		<option value="2" >b </option>
		<option value="3" >c </option>
		<option value="4" >d </option>
		<option value="5" >e </option>
		<option value="6" >f </option>
	</select>
	<br/>
	<textarea rows="10" cols="40" name="blame_content" id="blame_content"></textarea>
	<br/>
	
	<button onclick="insertBlameAction()">신고하기</button>


</body>
</html>