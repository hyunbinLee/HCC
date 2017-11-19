<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="resources/js/sockjs.min.js"></script>
<script type="text/javascript">

var sock = new SockJS("/hcc/echo");//echoHandler 호출해서 sock 변수에 저장 ,사용자끼리 채팅 가능하게 구현.
sock.onmessage = onMessage;
sock.onclose = onClose;

$(function(){
	$("#sendBtn").click(function(){
		console.log('send message...');
		sendMessage();
	});
});

function sendMessage(){
	
	sock.send($("#message").val());//text 인풋의 값을 send 함수로 보낸다.
}

function onMessage(evt){ //전송 버튼 누를시에 호출. evt는  채팅방에 저장되있는 상대방의 아이디와 텍스트를 저장해놓는다. handleTextMessage sess.sendMessage 호출됨.
	
	var data = evt.data;
	var sessionid = null;
	var message = null;
	
	
	var strArray = data.split('|');
	
	for(var i=0; i<strArray.length; i++){
		console.log('str['+i+']: ' + strArray[i]);
	}
	
	var currentuser_session =$('#sessionuserid').val();
	
	console.log('current session id : ' + currentuser_session);
	
	sessionid = strArray[0];
	message = strArray[1];
	
	if(sessionid == currentuser_session){
		
		var printHTML = "<div class='well'>";
		printHTML += "<div class = 'alert alert-info'>";
		printHTML += "<strong>["+sessionid+"] -> "  + message + "</strong>";
		printHTML += "</div>";
		printHTML += "</div>";
		
		$('#chatdata').append(printHTML);
	}
	else{
		var printHTML = "<div class='well'>";
		printHTML += "<div class='alert alert-warning'>";
		printHTML += "<strong>["+sessionid+"] -> " +message+"</strong>";
		printHTML += "</div>";
		printHTML += "</div>";
		$("#chatdata").append(printHTML);
	}
	console.log('chatting data : ' + data);
}
 
 
$(function(){
	$("#out").click(function(){
		console.log('exit room...');
		exitRoom();
	});
});

function exitRoom(){
	
	sock.onclose();//text 인풋의 값을 send 함수로 보낸다.
}

function onClose(evt){//아직 구현 안함.
	$('#data').append("연결 끊김");

}

</script>
</head>
<body>

	<input type="hidden" id="sessionuserid" value="${userid }">
    <input type="text" id="message"/>
    <input type="button" id="sendBtn" value="전송"/>
    <div id="chatdata"></div>
    <br/>
    <input type="button" id="out" value="채팅방 나가기"/>
    


</body>
</html>