<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.member.db.*" %>
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
	<tr>
		<td width="200" align="left" height="50">
			<jsp:include page="/member/member_mypageMenu.jsp" />
		</td>
		<td width="700"><h1>CUSTOM : DESIGN BOX</h1><br>내 현재 사용 가능 포인트 : (${maxPoint})P</td>
	</tr> 




	
<%
if(listcount > 0){
%>
	<tr><td></td>
	<td>
	<table align="center" width="700">
	
	<tr><td colspan="4" height="50"></td></tr>
	<tr><th colspan="4"><font size ="2">날짜별 포인트 사용 내역</font></th></tr>
	<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	
	<tr  height="10">  
		<th width = "300" height="10"><font size ="2">날 짜</font></th>
		<th width = "300" height="10"><font size ="2">포인트 종류</font></th>
		<th width = "300" height="10"><font size ="2">받은 포인트</font></th>
		<th width = "300" height="10"><font size ="2">차감 포인트</font></th>
	</tr>
	<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	  
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<PointList.size();i++){
			MemberPointBean gb=(MemberPointBean)PointList.get(i);%>
		<%for(int j=0; j<1; j++){ %>
			
				<td align="center"><font size="3"><%=gb.getPOINT_DATE() %></font></td>
				
				<%
				int num = gb.getPOINT_TYPE();
				String PointType=null;
				if(num == 1){
					PointType = "구매 포인트";
				}else{
					PointType = "판매 포인트";
				}
				%>
				<td align="center"><font size="3"><%=PointType%></font></td> 
				<td align="center"><font size="3"><%=gb.getPOINT_PLUS()%></font></td>
				<td align="center"><font size="3"><%=gb.getPOINT_DEDUCTION()%></font></td>
			<%}%>
				</tr>	
		<%}%> 

<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="4" style=font-family:Tahoma;font-size:10pt;>
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
	<tr><td colspan="4"><hr /></td></tr>
	<tr align="center" valign="middle">
		<td colspan="4">POINT</td></tr>
	<tr><td><hr style="border-style: ridge;"/></td></tr>
	<tr>	
		<td align="center">
			<font size=2>포인트 사용 내역이 없습니다.</font>
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