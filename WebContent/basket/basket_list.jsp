<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.basket.db.*" %>

<%
	List basketlist=(List)request.getAttribute("basketlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	String c=null;
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
		<td width="700"><h1>CUSTOM : DESIGN BOX</h1></td>
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
	
	  
	<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<basketlist.size();i++){
			BasketBean gb=(BasketBean)basketlist.get(i);%>
		<%for(int j=0; j<1; j++){ %>
				
				
				<td align="center"><font size="3"><%=gb.getBASKET_CUSTOM1()%></font></td>
				<td align="center"><font size="3"><a href="./BasketDetailAction.ba?num=<%=gb.getBASKET_NUM()%>">
												<%=gb.getBASKET_CUSTOM13() %></a></font></td> 
				<td align="center"><font size="3"><a href="./BasketDeleteAction.ba?num=<%=gb.getBASKET_NUM()%>">
												<button>삭제</button></a></font></td> 
												
			<%}%>
				</tr>	
		<%}%> 

<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="3" style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./BasketListAction.ba?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./BasketListAction.ba?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./BasketListAction.ba?page=<%=nowpage+1 %>">[다음]</a>
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
		<td colspan="2">CUSTOM : DESIGN BOX</td></tr>
	<tr><td><hr style="border-style: ridge;"/></td></tr>
	<tr>	
		<td align="center">
			<font size=2>보관하신 디자인이 없습니다.</font>
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