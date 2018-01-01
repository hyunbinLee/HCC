<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../../common/inc_common.jsp"%>

<%@ include file="../../common/inc_header.jsp"%>

<script>

	function div_q1(v) {
		if(v == "y") {
			document.getElementById('q2').style.display = "none";
			document.getElementById('q3').style.display = "none";
			document.getElementById('q4').style.display = "none";
			document.getElementById('q5').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q2').reset();
			document.getElementById('q3').reset();
			document.getElementById('q4').reset();
			document.getElementById('q5').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('A').style.display = "";
			document.getElementById('result').value = "A";
			document.getElementById('but').style.display = "";
		} else if(v == "n") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q4').style.display = "none";
			document.getElementById('q5').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q4').reset();
			document.getElementById('q5').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('q2').style.display = "";
		}
	}
	
	function div_q2(v) {
		if(v == "y") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q5').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q5').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('q4').style.display = "";
		} else if(v == "n") {
			document.getElementById('q4').style.display = "none";
			document.getElementById('q5').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('q5').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('q3').style.display = "";
		}
	}
	
	function div_q3(v) {
		if(v == "y") {
			document.getElementById('q4').style.display = "none";
			document.getElementById('q5').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('q5').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('C').style.display = "";
			document.getElementById('result').value = "C";
			document.getElementById('but').style.display = "";
		} else if(v == "n") {
			document.getElementById('q4').style.display = "none";
			document.getElementById('q5').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('q5').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('B').style.display = "";
			document.getElementById('result').value = "B";
			document.getElementById('but').style.display = "";
		}
	}
	
	function div_q4(v) {
		if(v == "y") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q5').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q5').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('H').style.display = "";
			document.getElementById('result').value = "H";
			document.getElementById('but').style.display = "";
		} else if(v == "n") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q6').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('q5').style.display = "";
		}
	}
	
	function div_q5(v) {
		if(v == "y") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q6').reset();
			
			document.getElementById('q7').style.display = "";
		} else if(v == "n") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('q6').style.display = "";
		}
	}

	function div_q6(v) {
		if(v == "y") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('E').style.display = "";
			document.getElementById('result').value = "E";
			document.getElementById('but').style.display = "";
		} else if(v == "n") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q7').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q7').reset();
			
			document.getElementById('D').style.display = "";
			document.getElementById('result').value = "D";
			document.getElementById('but').style.display = "";
		}
	}
	
	function div_q7(v) {
		if(v == "y") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('F').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q6').reset();
			
			document.getElementById('G').style.display = "";
			document.getElementById('result').value = "G";
			document.getElementById('but').style.display = "";
		} else if(v == "n") {
			document.getElementById('q3').style.display = "none";
			document.getElementById('q6').style.display = "none";
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('G').style.display = "none";
			document.getElementById('H').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q6').reset();
			
			document.getElementById('F').style.display = "";
			document.getElementById('result').value = "F";
			document.getElementById('but').style.display = "";
		}
	}
</script>
</head>
<body>
	<div class="wrap">
	
	<form action="./insertSelfDiagno_acutestomachache">
	    <!-- Top Menu -->
		<%@ include file="../../common/inc_top.jsp"%>
		
		<div id="q1">
		<tr>
			<td>
				Q1. 급성복통이 있으면서 다음 항목 중 한가지라도 해당하거나 동반되는 사항이 있습니까?
						- 38도 이상의 발열이 있는 경우
						- 수일간 음식 섭취를 전혀 못함
						- 지속적인 구토 또는 변비 동반
						- 소변을 자주 보거나 배뇨 시 통증이 있음
						- 아파서 배를 만지기 어려움
						- 최근 외상이 있은 후 시작된 통증
						- 참기 힘든 심한 통증이 지속됨
						- 혈변
						- 급격한 혈압 저하
						- 체중 감소
			</td>
			<td>
				<input name="q1" type="radio" value="y" onclick="div_q1(this.value);"/>
				<input name="q1" type="radio" value="n" onclick="div_q1(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q2" style="display:none">
		<tr>
			<td>
				Q2. 지속적인 통증
			</td>
			<td>
				<input name="q2" type="radio" value="y" onclick="div_q2(this.value);"/>
				<input name="q2" type="radio" value="n" onclick="div_q2(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q3" style="display:none">
		<tr>
			<td>
				Q3. 통증부위가 우상복부 혹은 옆구리입니까?
			</td>
			<td>
				<input name="q3" type="radio" value="y" onclick="div_q3(this.value);"/>
				<input name="q3" type="radio" value="n" onclick="div_q3(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q4" style="display:none">
		<tr>
			<td>
				Q4. 통증 부위가 복부 전체입니까?
			</td>
			<td>
				<input name="q4" type="radio" value="y" onclick="div_q4(this.value);"/>
				<input name="q4" type="radio" value="n" onclick="div_q4(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q5" style="display:none">
		<tr>
			<td>
				Q5. 누르면 통증이 심해집니까?
			</td>
			<td>
				<input name="q5" type="radio" value="y" onclick="div_q5(this.value);"/>
				<input name="q5" type="radio" value="n" onclick="div_q5(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q6" style="display:none">
		<tr>
			<td>
				Q6. 통증부위가 명치 혹은 옆구리 입니까?
			</td>
			<td>
				<input name="q6" type="radio" value="y" onclick="div_q6(this.value);"/>
				<input name="q6" type="radio" value="n" onclick="div_q6(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q7" style="display:none">
		<tr>
			<td>
				Q7. 통증부위가 하복부 혹은 우상복부입니까?
			</td>
			<td>
				<input name="q7" type="radio" value="y" onclick="div_q7(this.value);"/>
				<input name="q7" type="radio" value="n" onclick="div_q7(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="A" style="display:none">
		<tr>
			<td>
				빨리 의사의 진료를 받으시기 바랍니다.
			</td>
		</tr>
		</div>
		
		<div id="B" style="display:none">
		<tr>
			<td>
				담석증
			</td>
		</tr>
		</div>
		
		<div id="C" style="display:none">
		<tr>
			<td>
				요로결석
			</td>
		</tr>
		</div>
		
		<div id="D" style="display:none">
		<tr>
			<td>
				역류성식도염
				소화성궤양
				심근경색
			</td>
		</tr>
		</div>
		
		<div id="E" style="display:none">
		<tr>
			<td>
				신우신염
			</td>
		</tr>
		</div>
		
		<div id="F" style="display:none">
		<tr>
			<td>
				대장염
				게실염
				급성충수염
				국소회장염
				배란통 (여성)
				자궁외임신 (여성)
				난관염 (여성)
			</td>
		</tr>
		</div>
		
		<div id="G" style="display:none">
		<tr>
			<td>
				급성담낭염
			</td>
		</tr>
		</div>
		
		<div id="H" style="display:none">
		<tr>
			<td>
				복막염
				대장염
			</td>
		</tr>
		</div>
		
		<input type="hidden" name="result" id="result">
		
		<div id="but" style="display:none">
			<button type="button" onclick="javascript:location.href='./selfDiagno_acutestomachache'"> 다시 </button>
			<input type="submit" value="저장" id="reg_btn">
		</div>
		
		
	</form>
	</div>
			

</body>
</html>