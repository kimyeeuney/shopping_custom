<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8");%>
<%
	String orderNumber=(String)request.getAttribute("orderNumber");
	int check=((Integer)(request.getAttribute("check"))).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제창</title>
<script>

function windowclose(){
	opener.document.OrderTradeform;
	self.close();
}

</script>
</head>
<body>
	
	
	<% if(check == 1){ %>
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr><td><hr/></td></tr>
	<tr align="center"><th><font size="2">step3. C U S T O M 결 제</font></th></tr>
	<tr><td><hr/></td></tr>
	<tr align="center">
	<td height="30">
		<font size="2">결제 완료</font>
	</td>
	</tr>
</table>


<% }else{ %>
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
		<font size="2">유효하지 않은 카드입니다.</font>
</table>		
		
<form action="'./ordertypeAction.co" method="post" name="OrderTradeform" >
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		<input type="text" size="10" maxlength="16" name="orderNumber"/>
		<input type="submit" value="결제하기" />
<% } %>
		
		<tr><td><hr/></td></tr>
		
</table>
</form>




</body>
</html>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	