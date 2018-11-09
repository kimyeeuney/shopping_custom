<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="net.gallery.db.*" %>
<%@ page import="net.gallery.action.*" %>
<%@ page import="net.admin.ad.db.*" %>
<%
	List gallerylist=(List)request.getAttribute("gallerylist");
	List adlist=(List)request.getAttribute("adlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue(); 
 	int j;
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<table align="center" width="900px">
	
	<tr><td colspan="2" align="center" width="900" ><jsp:include page="main_roll.jsp"/></td></tr>
	
	
  	<tr><td><font size="7" align="left"><strong>BEST HOT ITEM</strong></font></td></tr>
	<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>

	<!-- 왼쪽영역 -->
	<tr><td align="center" width="450px" height="100px">
	<!-- 영역구분 -->
		
		<table>
		<%for(int i=0;i<gallerylist.size();i++){
				GalleryBean gb=(GalleryBean)gallerylist.get(i);%>
				<%for(j=1;j<=i;j++){%><%}%>
			<tr>
				<td bgcolor="#E3D8D9" align="center" width="450px" height="120">
				<strong>BEST<%=j %></strong><br>
				<%=gb.getGALLERY_CUSTOM_ID() %>
				<a href="./GalleryDetailAction.ua?num=<%=gb.getGALLERY_NUM()%>">
				님의 <%=gb.getGALLERY_CUSTOM13() %></a><br>
				찜♥(<%=gb.getGALLERY_RE_LEV() %>)
				</td>
			</tr>
				
		<%}%>	  
	</table>
	<!-- 왼/영역구분 -->
	</td>
	<!-- 왼/영역구분 -->
	
	<!-- ------------------------------------------------------------ -->

<%
//광고리스트
if(listcount > 0){
%>	
	<!-- 오른쪽영역 -->
	<td align="center" width="450px" height="120">
		<!-- 영역구분 -->
		<table>
		<%for(int i=0;i<adlist.size();i++){
			AdMyBean gb=(AdMyBean)adlist.get(i);%>
			<tr>
				<td bgcolor="#E6CFD1" align="center" width="450px" height="120">
				<%=gb.getAD_ID() %>님, <%=gb.getAD_NAME() %>
				</td>
			</tr>
		<%}%>	
		</table>
		
<%}else{ %>

	<td align="center" width="450px" height="120">
		<!-- 영역구분 -->
		<table>
	<%for(int i=0;i<gallerylist.size();i++){
		GalleryBean gb=(GalleryBean)gallerylist.get(i);%>
		<%for(j=1;j<=i;j++){%><%}%>
	<tr>
		<td bgcolor="#E6CFD1" align="center" width="450px" height="120">
		<strong>BEST<%=j %></strong><br>
		<%=gb.getGALLERY_CUSTOM_ID() %>
		<a href="./GalleryDetailAction.ua?num=<%=gb.getGALLERY_NUM()%>">
		님의 <%=gb.getGALLERY_CUSTOM13() %></a><br>
		찜♥(<%=gb.getGALLERY_RE_LEV() %>)
		</td>
	</tr>
		
	<%}%>	  
</table>

<%} %>
	<!-- 오/영역구분 -->
	</td>  
	</tr>
	<!-- 오/영역구분 -->
	
	
	
	</table>
	
</body>
</html>