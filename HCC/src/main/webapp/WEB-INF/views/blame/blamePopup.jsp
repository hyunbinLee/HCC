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
		<option value="1" >�ϳ� </option>
		<option value="2" >�� </option>
		<option value="3" >�� </option>
		<option value="4" >�� </option>
		<option value="5" >�ټ� </option>
		<option value="6" >����</option>
	</select>
	<br/>
	<textarea rows="10" cols="40" name="blame_content" id="blame_content"></textarea>
	<br/>
	
	<button onclick="insertBlameAction()">�Ű��ϱ�</button>


</body>
</html>