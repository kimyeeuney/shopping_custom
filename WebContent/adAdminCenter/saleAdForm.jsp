<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="net.gallery.db.*" %>
<%@ page import="net.admin.ad.db.*" %>
<%@ page import="net.gallery.action.*" %>
<%@ page import="java.sql.*" %>
<%
	int Glistcount=((Integer)request.getAttribute("Glistcount")).intValue();	
	List gallerylist=(List)request.getAttribute("gallerylist");
 	int listcount=((Integer)request.getAttribute("listcount")).intValue(); 
	List adlist=(List)request.getAttribute("adlist");
	int ADcount=((Integer)request.getAttribute("ADcount")).intValue(); 
	List adIdlist=(List)request.getAttribute("adIdlist");
	
 	
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<style>
#div1{
 	display: inline-block; 
 	border: 2px dotted black; 
 	/* padding: 5px 15px;  */
 	letter-spacing: 3px;
 	margin-top: 10px;
 	border-radius: 15px;
 	padding-top:5px;
 	padding-bottom:7px;
 	}
</style>
<title></title>
</head>
<body>



<table height="50" width="900">
	<tr><td colspan="2" height="50"></td></tr>  
	<tr><td colspan="2"><font size="3"><strong>Main  클릭 광고 신청</strong></font></td></tr>  
	
	<tr>
		<td width="500">




<div id="div1">
	<!-- 광고구좌 -->
	<table>
	
	<tr>
		<td width="100"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-</font></td>
		<td width="80"><font size="2">&nbsp;&nbsp;&nbsp;ID</font></td>
		<td width="130"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;상품명</font></td>
		<td width="100"><font size="2">클릭비용</font></td>
		<td width="100"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;-</font></td>
	</tr>
	<tr><td colspan="5"><font size="1">&nbsp;&nbsp;----------------------------------------------------------------------</font></td></tr>
<%
//광고리스트
if(listcount > 0){
%>	

	<table width="500" align="left">
	
	<%for(int i=0;i<adlist.size();i++){
		AdMyBean gb=(AdMyBean)adlist.get(i);%>
		<tr width="500" align="center">
			<td width="100"><font size="2">&nbsp;<strong><%=i+1 %>구좌</strong></font></td>
			<td width="80"><font size="2"><%=gb.getAD_ID()%>님</font></td>
			<td width="130"><font size="2"><%=gb.getAD_NAME() %></font></td>
			<td width="100"><font size="2"><%=gb.getAD_PRICE() %>￦</font><td>
			<td width="100">
			
			
			<% 
			String id=(String)session.getAttribute("id"); 
			System.out.print("세션id:"+id+"for문id:"+gb.getAD_ID());
			if(id.equals(gb.getAD_ID())){ %>
				<a href="./AdDeleteAction.ad?num=<%=gb.getAD_NUM()%>"><button><font size="2">광고 내리기</font></button></a>
			
			<%} %>
			</td>
			
		
		</tr>
	<%}%>
	</div>	
	</table>

<%}else{ %>
<tr align="left"><td>전시중인 광고가 없습니다.</td></tr>
<%} %>




<%
//내 광고가능리스트
if(Glistcount > 0){
%>
		<tr align="left"><td>
		
		
		
		<table>
			<tr>
			<td rowspan="2" align="right" width="90"><img alt="./images/check.png" src="./images/check.png" width="50" height="50"></td>
			
			<td align="left">
		<font size="1">
		광고하실 상품을 선택하세요.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;*구좌당 최소금액은 60원입니다.</font></td></tr>
		<tr align="left">
		
		
			<td align="left">
				<form action="./AdCheckAction.ad">
					<select name="add" style="width:200px;height:20px;" >
				<%for(int i=0;i<gallerylist.size();i++){
					GalleryBean gb=(GalleryBean)gallerylist.get(i);%>
					
					<option value="<%=gb.getGALLERY_NUM() %>"><%=gb.getGALLERY_CUSTOM13() %></option>
					
				<%}%>
					</select>
					<input type="text" name="price" size="5" /><font size="2">￦</font>
					<font size="2"><input type="submit" value="광고신청"></font></td></tr>
				</form>
				</td>
				</tr>
				
				
				<!-- 신청중인 광고리스트 -->
				<tr><td colspan="2">
				
				<!--1-->
				<div style="overflow:scroll; width:520px; height:200px;">
				<table width="480">
			
					<tr><td colspan="4" ><hr></tr>
					<tr><td colspan="4" height="40"><font size="3"><strong>*광고 신청 현황(ALL)</strong></font>
					<font size="1">: 이미 신청하신 광고를 새롭게 등록하시려면 삭제 후 이용하십시요.</font>
					</tr>
					
					
					<tr>
					
				<%for(int i=0;i<adIdlist.size();i++){
					AdMyBean af=(AdMyBean)adIdlist.get(i);%>
					
					<td align="left"><font size="2"><%=af.getAD_NAME() %></font></td>
					<td align="center"><font size="2"><%=af.getAD_PRICE() %>￦</font></td>
					<td align="right"><font size="2"><%=af.getAD_DATE() %></font></td>
					<td align="right"><a href="./AdDeleteAction.ad?num=<%=af.getAD_NUM()%>"><button><font size="2">신청 취소</font></button></a></td>
					</tr>
					<tr><td colspan="4"><hr height="1"></td></tr>
					<%}%>
			
					</table>
					</div>
				<!--1-->
				
				</td></tr>
				
				
				</table>
				
				
	</table>


	
<%}else{%>
	광고 신청 가능한 갤러리 상품이 없습니다.
<%} %>

</td>
<td></td>
</tr>

</table>




</body>
</html>