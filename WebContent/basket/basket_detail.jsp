<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.basket.db.*" %>
<%request.setCharacterEncoding("UTF-8");%>

<%  
	BasketBean ocb = (BasketBean)session.getAttribute("basketdto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C U S T O M</title>
</head>
<body>

<table align="center" width="900">
	<tr>
		<td width="200" align="left" height="50">
			<jsp:include page="/member/member_mypageMenu.jsp" />
		</td>
		<td width="700"><h1>GALLERY : Detail</h1></td>
	</tr> 
	
<!-- 상세내역 -->
		<tr><td></td>
	<td>
	<form action="./BasketOrderAction.ba" method="post" name="CustomOrderform" >
	<table align="center" width="700">
		
			<tr align="center"><td colspan="2"><hr style="border-style: ridge;"/></td></tr>
			
			<tr><th align="center">내 상품명 : </th><th align="left"><%=ocb.getBASKET_CUSTOM13() %></th></tr>
			<tr><td  width="170" align="center">키(cm) : </td><td width="130" align="left"><%=ocb.getBASKET_CUSTOM1() %>cm</td></tr>
			<tr><td align="center">A.목둘레(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM2() %>cm</td></tr>
			<tr><td align="center">&nbsp;&nbsp;네크라인(택1) : </td><td align="left"><%=ocb.getBASKET_CUSTOM3() %></td></tr>
			<tr><td align="center">B.어깨(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM4() %>cm</td></tr>
			<tr><td align="center">C.왼  팔(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM5() %>cm</td></tr>
			<tr><td align="center">E.왼팔 소매(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM6() %>cm</td></tr>
			<tr><td align="center">D.오른팔(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM7() %>cm</td></tr>
			<tr><td align="center">F.오른팔 소매 : </td><td align="left"><%=ocb.getBASKET_CUSTOM8() %>cm</td></tr>
			<tr><td align="center">G.가슴둘레(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM9() %>cm</td></tr>
			<tr><td align="center">H.밑단둘레(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM10() %>cm</td></tr>
			<tr><td align="center">I.총기장(cm) : </td><td align="left"><%=ocb.getBASKET_CUSTOM11() %>cm</td></tr>
			<tr><td align="center">color : </td><td align="left"><%=ocb.getBASKET_CUSTOM12() %></td></tr>
			
			<tr><td colspan="2"><hr /><input type="hidden" name="num" value="<%=ocb.getBASKET_NUM() %>" /></td></tr> 
			
			<tr><td colspan="2" align="center"><input type="submit" value="주문하기" /></td></tr>
			</form>
			 
	</td>
	</tr>
	</table>
		</table>

</body>
</html>