<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"> 
  a:link { text-decoration: none;} 
  a:visited { text-decoration: none;}  
  a:active { text-decoration: none;}
  a:hover {text-decoration:underline;}
</style>

<script type="text/javascript">
function opencenter(joinform){			
	var url="./useradmincenter.sa"
	open(url, "confirm", "toolbar=no,location=no,"
						+"status=no,menubar=no,"
						+"scrollbars=yes,resizable=no,"  
						+"width=1300,height=700");
}	


function openD(joinform){			
	var url="./centerG.sa"
	open(url, "confirm", "toolbar=yes,location=no,"
						+"status=no,menubar=yes,"
						+"scrollbars=yes,resizable=no,"
						+"width=500,height=300");
}	
</script>
</head>
<body> 


<!-- 1을 넘겨받아서, 1이면 판매자센터 바로가기, 아니면 판매자센터 오픈하기-Design -->
<% String id = (String)session.getAttribute("id"); %>

<%
	int centerCheck = (int)session.getAttribute("centerCheck");
	if(centerCheck == 1){

%>
<%= id %> 님의 판매자센터입니다.<br>
<!-- <input type="button" value="로그아웃" onclick="location.href='../member/member_logout.jsp'"> -->
<input type="button" value="로그아웃" onclick="javascript:window.location='./MemberLogOut.me'">
<input type="button" name="zipcode" value="판매센터 바로가기" onclick="opencenter(this.form)" />
<%
}else{
%>
<br>
<input type="button" value="로그아웃" onclick="javascript:window.location='./MemberLogOut.me'">
<input type="button" name="zipcode" value="판매센터 오픈하기" onclick="openD(this.form)" />

<%} %>
</body>
</html>
 














