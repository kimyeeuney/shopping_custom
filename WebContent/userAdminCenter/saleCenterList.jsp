<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.admin.sale.db.*" %>

<%
	List salelist=(List)request.getAttribute("salelist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>
<html>
<head>
<meta charset="UTF-8">
<title>C U S T O M</title>
<!-- 판매중인 상품리스트 -->


</head>
<body>


<table align="center" width="900"> 

	
<%
if(listcount > 0){
%>
	<tr><td colspan="5" height="50"></td></tr>
	<tr>
		<td colspan="5" align="right"><font size="3">총 상품(${ listcount })</font></td>
	</tr>
	<tr><td colspan="5"><hr /></td></tr>
	
	<tr>
		<th width = "300">갤 러 리 번 호</th>
		<th width = "300">상 품 명</th>
		<th width = "300">조 회 수</th>
		<th width = "300">찜 ♥</th>
		<th width = "300"> - </th>
	</tr>
	<tr><td colspan="5"><hr style="border-style: ridge;"/></td></tr>
	
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<salelist.size();i++){
			SaleBean gb=(SaleBean)salelist.get(i);%>
		<%for(int j=0; j<1; j++){ %>
			
				<td align="center"><font size="3"><%=gb.getGALLERY_NUM() %></font></td>
				<td align="center"><font size="3"><a href="./GalleryDetailAction.ua?num=<%=gb.getGALLERY_CUSTOM_NUM()%>">
												<%=gb.getGALLERY_CUSTOM13() %></a></font></td> 
				<td align="center"><font size="3"><%=gb.getGALLERY_READCOUNT()%></font></td>
				<td align="center"><font size="3"><%=gb.getGALLERY_RE_LEV()%></font></td> 
				<td align="center"><font size="3"><a href="./GalleryDeleteAction.ua?num=<%=gb.getGALLERY_NUM()%>">
												<button>삭제</button></a></font></td> 
			<%}%>
				</tr>	
		<%}%> 

<tr><td colspan="5"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="5" style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./SaleListAction.sa?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./SaleListAction.sa?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./SaleListAction.sa?page=<%=nowpage+1 %>">[다음]</a>
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
		<td colspan="2">C U S T O M : Sale LIST</td></tr>
	<tr><td><hr style="border-style: ridge;"/></td></tr>
	<tr>	
		<td align="center">
			<font size=2>판매중인 상품이 없습니다.</font>
		</td>
	</tr>
	<tr><td><hr /></td></tr>
	<%
	}
	%>
	

</table>


</body>
</html>