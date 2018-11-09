<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.custom.db.*" %>
<%@ page import="net.admin.sale.db.*" %>

<%
	List saleoklist=(List)request.getAttribute("saleoklist");
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
<!-- 구매한 상품리스트(판매X) : 갤러리에 등록가능한 판매리스트-->


</head>
<body>

<table align="center" width="900">
<%
if(listcount > 0){
%>
<tr><td colspan="5" height="50"></td></tr>
<tr>
		<td colspan="3" align="right"><font size="3">총 상품(${ listcount })</font></td>
	</tr>
	<tr><td colspan="3"><hr /></td></tr>
	
	<tr>
		<th width = "300">상 품 번 호</th>
		<th width = "300">상 품 명</th>
		<th width = "300"> - </th>
	</tr>
	<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<saleoklist.size();i++){
			OrderCustomBean gb=(OrderCustomBean)saleoklist.get(i);%>
		<%for(int j=0; j<1; j++){ %>
			
				<td align="center"><font size="3"><%=gb.getORDER_CUSTOM_NUM() %></font></td>
				<td align="center"><font size="3"><a href="./GalleryDetailAction.ua?num=<%=gb.getORDER_CUSTOM_NUM()%>">
												<%=gb.getORDER_CUSTOM13() %></a></font></td> 
				<td align="center"><font size="3"><a href="./SaleAddAction.sa?num=<%=gb.getORDER_CUSTOM_NUM()%>">
												<button>판매 등록</button></a></font></td> 
			<%}%>
				</tr>	
		<%}%> 

<tr><td colspan="3"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="3" style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./SaleOkListAction.sa?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./SaleOkListAction.sa?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./SaleOkListAction.sa?page=<%=nowpage+1 %>">[다음]</a>
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
			<font size=2>판매가능한 상품이 없습니다.</font>
		</td>
	</tr>
	<tr><td><hr /></td></tr>
	<%
	}
	%>
	

</table>


</body>
</html>