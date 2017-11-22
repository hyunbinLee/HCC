<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="resources/js/sockjs.min.js"></script>
<!-- jQuery, bootstrap CDN -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script> <!-- msie 문제 해결 -->
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<!-- Zebra-Dialog CDN -->
	<script src="resources/js/zebra_dialog.src.js"></script>
	<link rel="stylesheet" href="resources/css/zebra_dialog.css" type="text/css"/>
	<!-- SocketJS CDN -->
	<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
	
	
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
						 //메세지 처리 방식.
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

<script type="text/javascript">


$(function(){	
	$("#chattinglistbtn").click(function(){
		var currentuser_session =$('#sessionuserid').val();
		var infodialog = new $.Zebra_Dialog('<strong>채팅방 참여자 리스트</strong><br><br><p>'+currentuser_session+'</p>',{
			title: 'Chatting List',
			type: 'confirmation',
			print: false,
			width: 260,
			buttons: ['닫기'],
			onClose: function(caption){
				if(caption == '닫기'){
					//alert('yes click');
				}
			}
		});
    });
});
</script>
</head>
<body>


	<h1>Chatting Page (id: ${userid})</h1>
	<div>
		<input type="button" id="chattinglistbtn" value="채팅 참여자 리스트">
	</div>
	<input type="hidden" id="sessionuserid" value="${userid }">
    <input type="text" id="message"/>
    <input type="button" id="sendBtn" value="전송"/>
    <div id="chatdata"></div>
    <br/>
    <input type="button" id="out" value="채팅방 나가기"/>
    


</body>
</html>