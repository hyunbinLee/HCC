<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../../common/inc_common.jsp"%>

<%@ include file="../../common/inc_header.jsp"%>
  
  <script>
  	var box_cnt=2;
	function ctr_QA(add_num,ox){
		if(ox=='x'){
			var ab=add_num-1;
			$('label[for='+ab+']').removeClass('on');
			$('label[for='+add_num+']').addClass('on');
			addBox();
		}else{
			var ab=add_num+1;
			$('label[for='+ab+']').removeClass('on');
			$('label[for='+add_num+']').addClass('on');
			open_pop();
		}
	}
  		

	function open_pop() {
		$('.back_screen').show();
		$('.test-result-laypop').show();
		$('html, body').css({
			'overflow' : 'hidden'
		});

		$('#element').on('scroll touchmove mousewheel', function(event) {
			event.preventDefault();
			event.stopPropagation();
			return false;
		});
	}
	function close_pop() {
		if (confirm("저장 하시겠습니까?")) {
			location.href = "마이페이지"
			$('.test-result-laypop').hide();
			$('.back_screen').hide();
			$('html, body').css({
				'overflow' : 'auto'
			});
			$('#element').off('scroll touchmove mousewheel');
		} else {
			$('.test-result-laypop').hide();
			$('.back_screen').hide();
			$('html, body').css({
				'overflow' : 'auto'
			});
			$('#element').off('scroll touchmove mousewheel');
		}
	}

	function addBox(){
 		$('.question_box:nth-child('+box_cnt+')').css('display','block');
 		box_cnt+=1;
 	}

</script>

</head>
<body>
	<div class="wrap">
	
	    <!-- Top Menu -->
		<%@ include file="../../common/inc_top.jsp"%>
		
		
		</div>
		<div class="question_area">
				<!--문제 순서대로 on 클래스가 추가 삭제됨.-->
				<div class="question_box">
					<p>Question. 01</p>
					<h1>술을 마신 뒤에 예전만큼 잘 깨지 않는다.</h1>
					<div>
						<input type="radio" name="btn_ox" id="1" style="display:none"/>
						<label for="1" class="test-ox-btn m_r10" onclick="ctr_QA(1);">O</label>
						<input type="radio" name="btn_ox" id="2" style="display:none"/>
						<label for="2" class="test-ox-btn" onclick="ctr_QA(2,'x');">X</label>
					</div>
				</div>
				<div class="question_box">
					<p>Question. 02</p>
					<h1>아침에 일어나기가 힘들다.</h1>
					<div>
						<input type="radio" name="btn_ox" id="3" style="display:none"/>
						<label for="3" class="test-ox-btn m_r10" onclick="ctr_QA(3);">O</label>
						<input type="radio" name="btn_ox" id="4" style="display:none"/>
						<label for="4" class="test-ox-btn" onclick="ctr_QA(4,'x');">X</label>
					</div>
				</div>
				<div class="question_box">
					<p>Question. 03</p>
					<h1>튀김이나 고열량 식품을 즐겨먹는다.</h1>
					<input type="radio" name="btn_ox" id="5" style="display:none"/>
					<label for="5" class="test-ox-btn m_r10" onclick="ctr_QA(5);">O</label>
					<input type="radio" name="btn_ox" id="6" style="display:none"/>
					<label for="6" class="test-ox-btn" onclick="ctr_QA(6,'x');">X</label>
				</div>
				<div class="question_box">
					<p>Question. 04</p>
					<h1>입냄새가 심하게 난다.</h1>
					<input type="radio" name="btn_ox" id="7" style="display:none"/>
					<label for="7" class="test-ox-btn m_r10" onclick="ctr_QA(7);">O</label>
					<input type="radio" name="btn_ox" id="8" style="display:none"/>
					<label for="8" class="test-ox-btn" onclick="ctr_QA(8,'x');">X</label>
				</div>
				<div class="question_box">
					<p>Question. 06</p>
					<h1>간건강 관련하여 가족 중에 질환을 앓은 사람이 있다.</h1>
					<div>
						<input type="radio" name="btn_ox" id="9" style="display:none"/>
						<label for="9" class="test-ox-btn m_r10" onclick="ctr_QA(9);">O</label>
						<input type="radio" name="btn_ox" id="10" style="display:none"/>
						<label for="10" class="test-ox-btn" onclick="ctr_QA(10,'x');">X</label>
					</div>
				</div>
				<div class="question_box">
					<p>Question. 06</p>
					<h1>아침에 일어날 때 기운이 넘친다.</h1>
					<div>
						<input type="radio" name="btn_ox" id="11" style="display:none"/>
						<label for="11" class="test-ox-btn m_r10" onclick="ctr_QA(11);">O</label>
						<input type="radio" name="btn_ox" id="12" style="display:none"/>
						<label for="12" class="test-ox-btn" onclick="ctr_QA(12,'x');">X</label>
					</div>
				</div>
				<div class="question_box">
					<p>Question. 07</p>
					<h1>여행 중에도 쉽게 지치지 않는다.</h1>
					<div>
						<input type="radio" name="btn_ox" id="13" style="display:none"/>
						<label for="13" class="test-ox-btn m_r10" onclick="ctr_QA(13);">O</label>
						<input type="radio" name="btn_ox" id="14" style="display:none"/>
						<label for="14" class="test-ox-btn" onclick="ctr_QA(14,'x');">X</label>
					</div>
				</div>
				<div class="question_box">
					<p>Question. 08</p>
					<h1>술을 많이 마시지 않고, 마셔도 금방 깨는 편이다.</h1>
					<div>
						<input type="radio" name="btn_ox" id="15" style="display:none"/>
						<label for="15" class="test-ox-btn m_r10" onclick="ctr_QA(15);">O</label>
						<input type="radio" name="btn_ox" id="16" style="display:none"/>
						<label for="16" class="test-ox-btn" onclick="ctr_QA(16,'x');">X</label>
					</div>
				</div>
				<div class="question_box">
					<p>Question. 09</p>
					<h1>음식을 골고루 챙겨먹는 편이다.</h1>
					<input type="radio" name="btn_ox" id="17" style="display:none"/>
					<label for="17" class="test-ox-btn m_r10" onclick="ctr_QA(17);">O</label>
					<input type="radio" name="btn_ox" id="18" style="display:none"/>
					<label for="18" class="test-ox-btn" onclick="ctr_QA(18,'x');">X</label>
				</div>
				<div class="question_box">
					<p>Question. 10</p>
					<h1>스트레스를 잘 받지 않는 편이다.</h1>
					<div>
						<input type="radio" name="btn_ox" id="19" style="display:none"/>
						<label for="19" class="test-ox-btn m_r10" onclick="ctr_QA(19);">O</label>
						<input type="radio" name="btn_ox" id="20" style="display:none"/>
						<label for="20" class="test-ox-btn" onclick="ctr_QA(20,'x');">X</label>
					</div>
				</div>

			</div>
			<!-- <a class="selfcheck_btn m_t30 m_b30" href="#" onclick="open_pop()">결과보기</a>-->
		<div class="test-result-laypop" style="display: none">
			<button type="button" class="btn_close" onclick="close_pop()">X</button>
			<div class="test-result-txtbox">
				<dl>
					<dt>테스트 결과</dt>
					<dd class="test-result-txtbox-def">
						내 나이는 24세, <strong>신체 나이는 24세!</strong>
					</dd>
					<dd class="test-result-txtbox-txt">
						꽉 찬 수분으로 촉촉한 피부를 가지고 있는 당신은 매끈매끈, 물광 피부 돌고래입니다.<br>물속을 헤엄치는
						돌고래 처럼 촉촉한 피부결을 가지고 있습니다.<br>지금 당신은 주변 친구들의 부러움을 사는 물광 피부를
						뽐내고 있군요.<br>지금처럼 매끈함과 촉촉함을 유지한다면 시간을 거스르는 물광 피부를 유지할 수 있습니다!
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="back_screen" style="display: none"></div>
</body>
</html>