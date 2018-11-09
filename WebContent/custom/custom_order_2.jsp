<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="net.custom.db.*" %>
    <%request.setCharacterEncoding("UTF-8");%>
    
<%  
	OrderCustomBean ocb = (OrderCustomBean)session.getAttribute("orderdata");
	int point = (int)session.getAttribute("point");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>주문하기</title>
<script language="javascript">
	function addorder() {
		CustomOrderform.submit();
	}
</script>
<script type="text/javascript">
function check(){
	var name=CustomOrderform.ORDER_CUSTOM_RECEIVE_NAME.value;
	var addr1=CustomOrderform.ORDER_CUSTOM_RECEIVE_ADDR1.value;
	var addr1=CustomOrderform.ORDER_CUSTOM_RECEIVE_ADDR2.value;
	var phone=CustomOrderform.ORDER_CUSTOM_RECEIVE_PHONE.value;
	var mobile=CustomOrderform.ORDER_CUSTOM_RECEIVE_MOBILE.value;
	var ordertype=CustomOrderform.ORDER_TRADE_TYPE.value;
	
	var forms = document.getElementById("CustomOrderform");

	if ((forms.ORDER_CUSTOM_RECEIVE_NAME.value=="")||(forms.ORDER_CUSTOM_RECEIVE_NAME.value.length<=1)){
		alert("이름을 입력해 주세요.");
		forms.ORDER_CUSTOM_RECEIVE_NAME.focus();
         		return false;
	}
	if(phone.length == 0){
		alert("집 전화를 입력하세요.");
		CustomOrderform.ORDER_CUSTOM_RECEIVE_PHONE.focus();
		return false;
	} 
	if((forms.ORDER_CUSTOM_ZIPCODE1.value=="")||(forms.MEMBER_ZIPCODE1.value.length<3)){
		alert("우편번호 앞의 3자리를 입력해 주세요.");
      	forms.ORDER_CUSTOM_ZIPCODE1.focus();
        return false;
 	}
 	if((forms.ORDER_CUSTOM_ZIPCODE2.value=="")||(forms.MEMBER_ZIPCODE2.value.length<3)){
		alert("우편번호 뒤의 3자리 입력해 주세요.");
      	forms.ORDER_CUSTOM_ZIPCODE2.focus();
        return false;
	}  
	if(addr1.length == 0){
		alert("집 주소를 입력하세요.");
		CustomOrderform.ORDER_CUSTOM_RECEIVE_ADDR1.focus();
		return false;
	} 
	if(addr2.length == 0){
		alert("상세 주소를 입력하세요.");
		CustomOrderform.ORDER_CUSTOM_RECEIVE_ADDR2.focus();
		return false;
	} 
	if(mobile.length == 0){
		alert("휴대폰 번호를 입력하세요.");
		CustomOrderform.ORDER_CUSTOM_RECEIVE_MOBILE.focus();
		return false;
	}
	if(ordertype.length == 0){
		alert("결제방법을 체크하세요.");
		CustomOrderform.ORDER_TRADE_TYPE.focus();
		return false;
	}
	
	return true;
}



function openZipcode(CustomOrderform){			
	var url="./Zipcode.me"
	open(url, "confirm", "toolbar=no,location=no,"
						+"status=no,menubar=no,"
						+"scrollbars=yes,resizable=no,"
						+"width=410,height=400");
}	

function gNumCheck(){
	if(event.keyCode >=48 && event.keyCode <=57) {
		return true;
	}else{
		event.returnValue=false;	
	}
}
</script>

</head>
<body>

<table align="center" width="900">
  

<tr height="120"><th colspan="3" align="left"><font size="7">CUSTOM : DESIGN</font></th></tr>
<tr><td colspan="3" ><hr /></td></tr>
<tr><th colspan="3" align="center" height="30">step2. 배송정보</th></tr>
<tr><td colspan="3"><hr style="border-style: ridge;" /></td></tr>
</table>
			<!-- 주문내역 -->
		<table align="center" width="900">
			
			
			
			<tr><th align="center">내 상품명 : </th><th align="left"><%=ocb.getORDER_CUSTOM13() %></th></tr>
			<tr><td  width="170" align="center">키(cm) : </td><td width="130" align="left"><%=ocb.getORDER_CUSTOM1() %>cm</td></tr>
			<tr><td align="center">A.목둘레(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM2() %>cm</td></tr>
			<tr><td align="center">&nbsp;&nbsp;네크라인(택1) : </td><td align="left"><%=ocb.getORDER_CUSTOM3() %></td></tr>
			<tr><td align="center">B.어깨(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM4() %>cm</td></tr>
			<tr><td align="center">C.왼  팔(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM5() %>cm</td></tr>
			<tr><td align="center">E.왼팔 소매(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM6() %>cm</td></tr>
			<tr><td align="center">D.오른팔(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM7() %>cm</td></tr>
			<tr><td align="center">F.오른팔 소매 : </td><td align="left"><%=ocb.getORDER_CUSTOM8() %>cm</td></tr>
			<tr><td align="center">G.가슴둘레(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM9() %>cm</td></tr>
			<tr><td align="center">H.밑단둘레(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM10() %>cm</td></tr>
			<tr><td align="center">I.총기장(cm) : </td><td align="left"><%=ocb.getORDER_CUSTOM11() %>cm</td></tr>
			<tr><td align="center">color : </td><td align="left"><%=ocb.getORDER_CUSTOM12() %></td></tr>
			
			
			
			
				<% 
			/* 가격 */
			int ORDER_CUSTOM2 = ocb.getORDER_CUSTOM2(); //목둘레
			String ORDER_CUSTOM3 = ocb.getORDER_CUSTOM3(); //네크라인
			int ORDER_CUSTOM4 = ocb.getORDER_CUSTOM4(); //어깨
			int ORDER_CUSTOM5 = ocb.getORDER_CUSTOM5(); //왼팔
			int ORDER_CUSTOM6 = ocb.getORDER_CUSTOM6(); //왼팔소매
			int ORDER_CUSTOM7 = ocb.getORDER_CUSTOM7(); //오른팔
			int ORDER_CUSTOM8 = ocb.getORDER_CUSTOM8(); //오른팔소매
			int ORDER_CUSTOM9 = ocb.getORDER_CUSTOM9(); //가슴둘레
			int ORDER_CUSTOM10 = ocb.getORDER_CUSTOM10(); //밑단둘레
			int ORDER_CUSTOM11 = ocb.getORDER_CUSTOM11(); //총기장
			
			/* 팔 (양길이)40cm이상이면 추가금 +2000원 
				총기장 50cm이상이면 추가금 +2000원
				가슴둘레 45cm이상이면 추가금 +2000원
			*/
			int sum = 9900;
			int a = ORDER_CUSTOM5 + ORDER_CUSTOM7;
			
			if(a >= 40){
				sum += 2000; 
			}
			
			if(ORDER_CUSTOM11 >= 50){  
				sum += 2000;
			}
			
			if(ORDER_CUSTOM9 >= 45){
				sum += 2000;
			}
			
		%>
		
		
			<tr><td colspan="2"><hr /></td></tr>
			<tr align="right" bgcolor="#E3DEDF"><td colspan="2">총 금액 : <%=sum %></td></tr>
			<tr><td colspan="2"><hr /></td></tr> 
		</table> 
		
		
		
		
	
		

		
		
		
		
<form action="./CustomOrderAction_3.co" method="post" name="CustomOrderform" >
			
		<!-- 주문정보(기존등록정보/신규) -->
		<table align="center">		
		<tr>
			<th colspan="2">step3. 배 송 정 보 확 인</th>
		</tr>  
		<tr><input type="hidden" name="ORDER_CUSTOM_NUM" value=<%=ocb.getORDER_CUSTOM_NUM() %> /><td></td></tr>
		<tr>
		<td width="150" bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;성함</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="ORDER_CUSTOM_RECEIVE_NAME" size="20"/>
		</td>
		</tr>
		
		
		<tr>
			<td bgcolor="#f5f5f5">
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;우편번호</font>
			</td>
			<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="ORDER_CUSTOM_ZIPCODE1" size="6" 
				onkeypress="gNumCheck()" maxlength="3"/>- 
			<input type="text" name="ORDER_CUSTOM_ZIPCODE2" size="6" 
				onkeypress="gNumCheck()" maxlength="3" />&nbsp;&nbsp;
			<input type="button" name="zipcode" value="우편번호 검색" 
				onclick="openZipcode(this.form)" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#f5f5f5">
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;집주소</font>
			</td>
			<td>
				&nbsp;&nbsp;&nbsp;
				<input type="text" name="ORDER_CUSTOM_RECEIVE_ADDR1" size="50" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#f5f5f5">
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;상세주소</font>
			</td>
			<td>
				&nbsp;&nbsp;&nbsp;
				<input type="text" name="ORDER_CUSTOM_RECEIVE_ADDR2" size="50" />
			</td>
		</tr>
		
		<!-- <tr>    //이 컬럼을 총 금액으로 사용
			<td bgcolor="#f5f5f5">
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;집전화</font>
			</td>
			<td>
				&nbsp;&nbsp;&nbsp;
				<input type="text" name="ORDER_CUSTOM_RECEIVE_PHONE" size="24"/>
			</td>
		</tr> -->
		
		<tr>
			<td bgcolor="#f5f5f5">
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;휴대폰</font>
			</td>
			<td>
				&nbsp;&nbsp;&nbsp;
				<input type="text" name="ORDER_CUSTOM_RECEIVE_MOBILE" size="24" />
				</td>
			</tr>
			
			<tr>
			<td bgcolor="#f5f5f5">
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;MEMO</font>
			</td>
			<td> 
			&nbsp;&nbsp;&nbsp;
				<input type="text" name="ORDER_CUSTOM_MEMO" size="50" height="100" />
				</td>
			</tr>  
			
			<!-- 결제방법 1,2선택시 무통장이면 다음 페이지에서 계좌주고, 
					카드결제면 다음페이지에서 id유효성 검사하듯 카드번호검사(카드번호들어있는 테이블만들기)-->
			<tr>
				<td bgcolor="#f5f5f5">
				<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;결제방법</font>
			</td>
			<td>
			&nbsp;&nbsp;&nbsp;
				<input type="radio" name="ORDER_CUSTOM_TRADE_TYPE" value="무통장">무통장</input>
				<input type="radio" name="ORDER_CUSTOM_TRADE_TYPE" value="카드결제">카드결제</input>
				<input type="hidden" name="ORDER_CUSTOM_GALLERY" value="ORDER_CUSTOM_GALLERY"/>
				<input type="hidden" name="ORDER_CUSTOM_RECEIVE_PHONE" value="<%=sum%>"/>
			</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5" rowspan="2">
					<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;포인트</font><br><font size="1">&nbsp;&nbsp;&nbsp;&nbsp;*100원단위로 사용가능</font>
				</td>
				<td>
				&nbsp;&nbsp;&nbsp;
					<font size="2">사용가능 포인트 : <%=point %>P</font>
			</tr>
			<tr>
				<td>
				&nbsp;&nbsp;&nbsp;
					
					<font size="2">사용하실 포인트 : </font><input type="text" name="POINT" value ="0" size="5"/>P
				</td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="주문하기" />
				</td>
			</tr> 
			
		</table>
	</form>
	
</body>
</html>