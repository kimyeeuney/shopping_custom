<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.member.db.*" %>
<%@ page import="net.custom.db.*" %>
    <%
	List deliverylist=(List)request.getAttribute("deliverylist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	String print_1 = null;
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
		<td width="700"><h1>CUSTOM : Delivery List</h1></td>
	</tr> 




	
<%
if(listcount > 0){
%>
	<tr><td></td>
	<td>
	
	
	<table align="center" width="700">
	<tr>
		<td colspan="3" align="right"><font size="3">총 상품(${ listcount })</font></td>
	</tr>
	<tr><td colspan="3"><hr /></td></tr>
	
	
	
	<tr>
		<th align="center"> 상 품 번 호</th>
		<th align="center">상 품 명</th>
		<th align="center">배 송 상 태</th>
	</tr>
	<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	
	
	<tr>
		<%for(int i=0;i<deliverylist.size();i++){
			OrderCustomBean gb=(OrderCustomBean)deliverylist.get(i);%>
		
			
			
		<td style="font-family:Tahoma;font-size:10pt;" width="300" height="30" align="center">
			
			
			 <%
			 int deliveryNum = gb.getORDER_CUSTOM_TRADE_PAYER();
			 	if (deliveryNum == 1){
			 		print_1 = "결제완료";
			 	}else if(deliveryNum == 2){
			 		print_1 = "배송중";
			 	}else if(deliveryNum == 2){
			 		print_1 = "배송완료";
			 	}else if(deliveryNum == 2){
			 		print_1 = "반품중";
			 	}
			 %><%=gb.getORDER_CUSTOM_NUM()%></td>
			 
			 <td align="center"><a href="./MemOrderDetailAction.me?num=<%=gb.getORDER_CUSTOM_NUM()%>">
			 <%=gb.getORDER_CUSTOM13()%> </a></td>
			 
			 <td align="center"><%=print_1 %></td>
			 </tr>
			<%}%>
					 
	<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height=20>
		<td colspan=3 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./MemberDeliveryAction.me?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./MemberDeliveryAction.me?page=<%=a %>">[<%=a %>]</a>&nbsp;&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./MemberDeliveryAction.me?page=<%=nowpage+1 %>">&nbsp;[다음]</a>
			<%} %>
		</td>
	</tr>
	<%
    }
	else
	{
	%>
	<tr align="center" valign="middle">
		<td colspan="3">Delivery List</td>
	</tr>
	<tr>
		<td align="center">
			<font size=2>배송확인이 가능한 상품이 존재하지 않습니다.</font>
		</td>
	</tr>
	<%
	}
	%>
	
	</td>
	</tr>
	</table>
</table>


</body>
</html>