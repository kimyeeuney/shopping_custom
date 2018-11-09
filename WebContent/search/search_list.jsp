<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.gallery.db.*" %>

<%
	List galleryList=(List)request.getAttribute("searchList");
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
<%
if(listcount > 0){
%>

	<tr>
		<th colspan="3" align="left" height="50"><font size="3">상세검색 결과 총(${ listcount }개) </font></th>
	</tr>
	<!-- 상세검색 -->
	<tr><td colspan="3"><jsp:include page="../search/detailed_search.jsp"></jsp:include></tr>
	<tr><td colspan="3" height="40"></td></tr>




	<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>

	<tr>
	<%for(int i=0;i<galleryList.size();i++){
		GalleryBean gb=(GalleryBean)galleryList.get(i);%>
	<%for(int j=0; j<1; j++){ %>
		
		
	<!-- 갤러리 -->
	<td style="font-family:Tahoma;font-size:10pt;" width="300" height="100" bgcolor="#FCD4DB">
		<div align="center"><a href="./GalleryDetailAction.ua?num=<%=gb.getGALLERY_NUM()%>">
		
			▶키 <font size="3"><%=gb.getGALLERY_CUSTOM1() %>cm</font>◀ 를 위한, Design<br>   
		 <%=gb.getGALLERY_CUSTOM13()%><br>갤러리번호:<%=gb.getGALLERY_NUM()%>
		 
		 </a>
		</div>   
	</td>
		<%}%>
			</tr>	
	<%}%> 

<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./GalleryListAction.ua?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./GalleryListAction.ua?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./GalleryListAction.ua?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<%
    }
	else
	{
	%>
	<tr align="center" valign="middle">
		<td colspan="3">GALLERY</td>
		<td align="center">
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
	<%
	}
	%>
	

</table>




</body>
</html>