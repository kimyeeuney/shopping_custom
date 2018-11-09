<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="net.custom.db.*" %>
    <%request.setCharacterEncoding("UTF-8");%>
    
<%  
	String nnum = (String)session.getAttribute("nnum");
	int getprice = (int)session.getAttribute("getprice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C U S T O M</title>

<script>  
/* function check(){
	var ort=ordertypeform.ordertype.value;
	var forms = document.getElementById("ordertypeform");
} */
	

function openOrdertype(ordertypeform){		
	var id=ordertypeform.orderNumber.value;
	var url="./galleryOrdeAction.ua?orderNumber="+ordertypeform.orderNumber.value;
	  
	if(id.length == 0){
		alert("계좌번호를 입력하세요.");
		ordertypeform.orderNumber.focus();
		return false;
	}
	
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
	 "scrollbars=no,resizable=no,width=400,height=200");
}






</script>

</head>
<body>


<table>
	<tr  bgcolor="#F7D5D5" >
		<td align="center" width="800" height="100"><font size="4" >주문이 완료되었습니다.</font></td>
	</tr>
	<tr bgcolor="#E6DCDC"><th>결 제 하 기</th></tr>
	<tr bgcolor="#E6DCDC" align="center">	<td><font size="2">결제를 완료하시면 배송이 시작됩니다.</font></td></tr>
	<tr bgcolor="#E6DCDC">	<th><font size="2">선택하신 결제방법 : <%=nnum %></font></th></tr>
	
	<%
	String occ = nnum; 
	String occ2= "무통장";
	if(occ.equals(occ2)){ 
	%>
	<tr>	<th><font size="2">입금하실 은행을 선택하세요.</font></th></tr>
	<tr>	<td><font size="2">
		
			<input type="radio" value="농협" name="ORDER_TRADE_TYPE" />농협
			<input type="radio" value="국민" name="ORDER_TRADE_TYPE" />국민
			<input type="radio" value="카카오" name="ORDER_TRADE_TYPE" />카카오
			<%=getprice %>
		</font>
		</td></tr>
	<%
	}else if(occ != occ2){  
	%>
	  
	<form action="index.jsp?page=/gallery/galleryOrder3" name="ordertypeform" method="post" onsubmit="return check()"> 
	<tr align="center" bgcolor="#E6DCDC"> 
			<th><p><font size="2">
				계좌번호  <input type="text" name="orderNumber" />
					
				<input type="hidden" name="getprice2" value="<%=getprice %>">
				<% session.setAttribute("getprice2", getprice); %>
				<% int customnum = (int)session.getAttribute("customnum"); %>
				<% session.setAttribute("customnum", customnum); 
					   int point = (int)session.getAttribute("point"); %>
				<% session.setAttribute("point", point); %>
				<input type="button" value="결제하기" name="ordertype_num" onclick="openOrdertype(this.form)" />
			</font></p></th>
		</tr>
 
	<tr align="center">	<td><font size="2">
	
		</font><!-- //1을 반환받아서 가져가자 -->
		<input type="submit" value="결제 완료">
		  
		</td></tr>
	<%
	}  
	%>
	</form>
</table>


</body>
</html>