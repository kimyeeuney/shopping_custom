<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.gallery.db.*" %>
<%request.setCharacterEncoding("UTF-8");%>

<%  
	GalleryBean ocb = (GalleryBean)session.getAttribute("gallerydto");
	int getprice = (Integer)session.getAttribute("getprice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C U S T O M </title>
</head>
<body>  

<!-- 주문내역 -->

	
		<table align="center" width="800">
		
			<tr align="center"><td colspan="2"><hr /></td></tr>
			<tr align="center"><th colspan="2">상품 상세보기 (<%=ocb.getGALLERY_NUM()%>번)</th></tr>
			<tr align="center"><td colspan="2"><hr /></td></tr>
			
			
			
			<tr><th align="center">내 상품명 : </th><th align="left"><%=ocb.getGALLERY_CUSTOM13() %></th></tr>
			<tr><td  width="170" align="center">키(cm) : </td><td width="130" align="left"><%=ocb.getGALLERY_CUSTOM1() %>cm</td></tr>
			<tr><td align="center">A.목둘레(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM2() %>cm</td></tr>
			<tr><td align="center">&nbsp;&nbsp;네크라인(택1) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM3() %></td></tr>
			<tr><td align="center">B.어깨(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM4() %>cm</td></tr>
			<tr><td align="center">C.왼  팔(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM5() %>cm</td></tr>
			<tr><td align="center">E.왼팔 소매(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM6() %>cm</td></tr>
			<tr><td align="center">D.오른팔(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM7() %>cm</td></tr>
			<tr><td align="center">F.오른팔 소매 : </td><td align="left"><%=ocb.getGALLERY_CUSTOM8() %>cm</td></tr>
			<tr><td align="center">G.가슴둘레(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM9() %>cm</td></tr>
			<tr><td align="center">H.밑단둘레(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM10() %>cm</td></tr>
			<tr><td align="center">I.총기장(cm) : </td><td align="left"><%=ocb.getGALLERY_CUSTOM11() %>cm</td></tr>
			<tr><td align="center">color : </td><td align="left"><%=ocb.getGALLERY_CUSTOM12() %></td></tr>
			
			<tr><td colspan="2"><hr /></td></tr>
			<tr align="right" bgcolor="gray"><td colspan="2">총 금액 : <%=getprice %>원</td></tr>
			<tr><td colspan="2"><hr /></td></tr> 
			
			
			<tr>
			<form action="./galleryOrder.ua" method="post" name="CustomOrderform" >
			<input type="hidden" name="num" value="<%=ocb.getGALLERY_NUM()%>"/>
			<td align="center"><input type="submit" value="주문하기" /></td>
					<td align="center"><input type="submit" formaction="./ChoiceCheck.ca" value="디자인 찜 하기" /></td></tr>
			</form>
		</table>

</body>
</html>