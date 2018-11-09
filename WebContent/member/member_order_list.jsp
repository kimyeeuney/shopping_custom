<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.member.db.*" %>
<%@ page import="net.custom.db.*" %>

<%
	List memberOrderlist=(List)request.getAttribute("memberOrderlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>

<html>
<head>
	<title>C U S T O M</title> 
</head>
<body>


<table align="center" width="900">
	<tr>
		<td width="200" align="left" height="50">
			<jsp:include page="/member/member_mypageMenu.jsp" />
		</td>
		<td width="700"><h1>CUSTOM : ALL Order List</h1></td>
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
		<th width = "300">주 문 번 호</th>
		<th width = "300">상 품 명</th>
		<th width = "300">주 문 시 간</th>
	</tr>
	<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<memberOrderlist.size();i++){
			OrderCustomBean gb=(OrderCustomBean)memberOrderlist.get(i);%>
		<%for(int j=0; j<1; j++){ %>
			
				<td align="center"><font size="3"><%=gb.getORDER_CUSTOM_NUM() %></font></td>
				<td align="center"><font size="3"><a href="./MemOrderDetailAction.me?num=<%=gb.getORDER_CUSTOM_NUM()%>">
												<%=gb.getORDER_CUSTOM13() %></a></font></td> 
				<td align="center"><font size="3"><%=gb.getORDER_CUSTOM_TRADE_DATE()%></font></td>
			<%}%>
				</tr>	
		<%}%> 

<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="3" style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./MemberOrderListAction.me?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./MemberOrderListAction.me?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./MemberOrderListAction.me?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<%
    }
	else
	{
	%>
	<tr><td colspan="3"><hr /></td></tr>
	<tr align="center" valign="middle">
		<td colspan="2">총 주문내역</td></tr>
	<tr><td><hr style="border-style: ridge;"/></td></tr>
	<tr>	
		<td align="center">
			<font size=2>구매하신 상품이 없습니다.</font>
		</td>
	</tr>
	<tr><td><hr /></td></tr>
	<%
	}
	%>
	
</td>
	</tr>
	</table>
</table>

</body>
</html>