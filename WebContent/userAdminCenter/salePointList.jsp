<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.admin.sale.db.*" %>
<%
	List PointList=(List)request.getAttribute("Pointlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	int maxPoint=((Float)request.getAttribute("maxPoint")).intValue();
%>  
<html>
<head>
	<title>C U S T O M</title> 
</head>
<body>
<table align="center" width="900">




	
<%
if(listcount > 0){
%>
<tr><td colspan="5" height="50"></td></tr>
	<tr><td></td>
	<td>
	<table align="center" width="100%">
	
	<tr><td colspan="4"  height="20" ></td></tr>
	<tr><td colspan="4" height="50" align="center">내 누적 판매POINT : <%=maxPoint %>P</td></tr>
	<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	<tr><td colspan="4" height="50"></td></tr>
	<tr><th colspan="4"><font size ="2">날짜별 포인트 누적 내역</font></th></tr>
	<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	
	<tr height="10">  
		<th width = "300" height="10"><font size ="2">누적 날짜</font></th>
		<th width = "300" height="10"><font size ="2">+PLUS POINT</font></th>
		<th width = "300" height="10"><font size ="2">구매자 ID</font></th>
		<th width = "300" height="10"><font size ="2">선물하기</font></th>
	</tr>  
	<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	  
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<PointList.size();i++){
			SalePointBean gb=(SalePointBean)PointList.get(i);%>
		<%for(int j=0; j<1; j++){ %>
			
				<td align="center"><font size="3"><%=gb.getPOINT_DATE() %></font></td>
				<td align="center"><font size="3"><%=gb.getPOINT_PLUS()%></font></td>
				<td align="center"><font size="3"><%=gb.getPOINT_OR_ID()%></font></td>
				<td align="center"><font size="3">
					
					<font size="2"><a href="./SalePointListAction_2.sa">쿠폰보내러가기</a></font>
				</td>
			<%}%>
				</tr>	
		<%}%> 

<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="4" style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./SalePointListAction.sa?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./SalePointListAction.sa?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./SalePointListAction.sa?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<%
    }
	else
	{
	%>
	<tr><td colspan="4" height="50"></td></tr>
	<tr><td colspan="4"><hr /></td></tr>
	<tr align="center" valign="middle">
		<td colspan="4">POINT</td></tr>
	<tr><td><hr style="border-style: ridge;"/></td></tr>
	
	<tr>	
		<td align="center">
			<font size=2>판매 포인트가 없습니다.</font>
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