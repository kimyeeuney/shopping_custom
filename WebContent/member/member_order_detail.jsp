<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.custom.db.*" %>
<%request.setCharacterEncoding("UTF-8");%>

<%  
	OrderCustomBean ocb = (OrderCustomBean)session.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C U S T O M </title>
</head>
<body>  
<table>
	<tr>
		<td width="100" align="left" height="50">
			<jsp:include page="../member/member_mypageMenu.jsp" />
		</td>
		<td width="900"><h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;CUSTOM : ALL Order List</h1></td>
	</tr> 
	
</table>
<!-- 주문내역 -->
		<table align="center" width="800">
		
			<tr align="center"><td colspan="2"><hr /></td></tr>
			<tr align="center"><th colspan="2">내 주문 상품 상세정보</th></tr>
			<tr align="center"><td colspan="2"><hr /></td></tr>
			
			
			
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
			
			<tr><td colspan="2"><hr /></td></tr>
			<tr align="center"><td colspan="2"><font size="2">총 금액 : <%=ocb.getORDER_CUSTOM_RECEIVE_PHONE() %>원</font></td></tr>
			<tr><td colspan="2"><hr /></td></tr> 
			
			<!-- 배송정보 출력 -->
			<tr align="center"><td colspan="2"><font size="2">배송정보</font></td></tr>
			<tr><th align="center">받는이 : </th><th align="left"><%=ocb.getORDER_CUSTOM13() %></th></tr>
			<tr><td  width="170" align="center">우편번호 : </td><td width="130" align="left"><%=ocb.getORDER_CUSTOM_ZIPCODE1() %> - <%=ocb.getORDER_CUSTOM_ZIPCODE2() %></td></tr>
			<tr><td align="center">집주소 : </td><td align="left"><%=ocb.getORDER_CUSTOM_RECEIVE_ADDR1() %></td></tr>
			<tr><td align="center">상세주소 : </td><td align="left"><%=ocb.getORDER_CUSTOM_RECEIVE_ADDR2() %></td></tr>
			<tr><td align="center">연락처 : </td><td align="left"><%=ocb.getORDER_CUSTOM_RECEIVE_MOBILE() %></td></tr>
			<tr><td align="center">메모 : </td><td align="left"><%=ocb.getORDER_CUSTOM_MEMO() %></td></tr>
			<tr><td align="center">결제방법 : </td><td align="left"><%=ocb.getORDER_CUSTOM_TRADE_TYPE() %></td></tr>
			
			<%
				int pay = ocb.getORDER_CUSTOM_TRADE_PAYER();
				String payPlay = null;
				if(pay == 1){
					payPlay = "결제완료";
				}
			%>
			<tr><td align="center">결제여부 : </td><td align="left"><%=payPlay %></td></tr>
		</table>
		
</body>
</html>