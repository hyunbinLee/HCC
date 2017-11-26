/**
 * 
 */

//var token = $("meta[name='_csrf']").attr("content");
//var header = $("meta[name='_csrf_header']").attr("content");
//
//$(function() {
//	$(document).ajaxSend(function(e, xhr, options) {
//		xhr.setRequestHeader(header, token);
//	});
//});

$(document).ready(function() {
	
	var bak_height = $('html').height();
	$('.bak_bl').css('height', bak_height);
	
	//2017-11-21 배너 사이즈를 위해 추가
	/*화면에 따른 배너 길이 */
	var banner_size = $('.banner_area').width()/2;
	/*배너 이미지 갯수*/
	var banner_cnt = $('.banner_area li').length;
	/*배너 *2 길이*/
	var banner_area = banner_size * banner_cnt;
	/*배너 첫 슬라이드 길이지정*/
	$('.banner_area ul').css('width',banner_area+'px')
	/*배너 이미지 사이즈 지정*/
	$('.banner_area img').css('width',banner_size+'px');
	for(var i=1; i < banner_cnt; i++){
		var a = banner_size *i;
		var a_cnt = $('.banner_area ul').css('left');
		if (a_cnt == 1){
			$('.banner_area ul').animate({
				left:"0"
			},1000)
			i=1;
		}else{
			$('.banner_area ul').animate({
				left:-banner_size*i+"px"
			},5000)
		}
		
	}
		
	
	
//	for(var i = banner_size; i <= banner_area; i+=banner_size ){
//		if (banner_size = banner_area){
//			$('.banner_area ul').animate('left','0');
//		}else{
//			$('.banner_area ul').animate('left',i+'px');
//		}
//	}
});


function lay_pop_close() {
	$('.login_wrap').hide();
	$('.bak_bl').hide();
}

function join() {
	$('.login_wrap').show();
	$('.bak_bl').show();
}

/**
 * 
 */

$(function() {// 아이디 중복 확인
	$("#regi_id_auth").bind("click", function() {
		var id = $("#user_id").val();

		$.ajax({
			type : "GET",
			data : {
				"id" : id
			},
			dataType : "json",
			url : "/hcc/idCheck",
			success : function(data) {

				if (data == false) {
					alert("사용 할 수 있는 아이디 입니다.");
					$("#dupCheck").val("true");
				} else
					alert("사용 할 수 없는 아이디 입니다.");
			},
			error : function(request, status, error) {
				alert("code1 = " + request.status + " error1 = " + error); // 실패 시 처리

			}
		});
	});
});

$(function() {// 이메일 전송
	$("#regi_auth").bind("click", function() {

		var email = $("#regi_email_f").val() + "@" + $("#regi_email_b").val();
		$.ajax({
			type : "GET",
			dataType : "json",
			data : {
				"email" : email
			},
			url : "/hcc/regiMail",
			success : function(data) {

				if (data == true)
					alert("이메일이 성공적으로 전송되었습니다.");
				else
					alert("이메일 전송 실패");

			},
			error : function(request, status, error) {
				alert("code2 = " + request.status + " error2 = " + error); // 실패 시
																			// 처리

			}
		});
	});
});

$(function() {// 이메일 인증번호 확인
	$("#regi_auth_confirm").bind("click", function() {

		var code = $("#input_code").val();

		$.ajax({
			type : "GET",
			dataType : "json",
			data : {
				"code" : code
			},
			url : "/hcc/regiMail_check",
			success : function(data) {

				if (data == true) {
					alert("이메일 인증이 완료 되었습니다.");
					$("#authCheck").val("true");

				} else
					alert("이메일 인증코드가 다릅니다.");

			},
			error : function(request, status, error) {
				alert("code3 = " + request.status + " error3 = " + error); // 실패 시
																			// 처리

			}
		});
	});
});
