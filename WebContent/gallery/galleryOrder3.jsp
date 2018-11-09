<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="net.custom.db.*" %>
    <%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
<head>  
<meta charset="UTF-8">
<style type="text/css"> 
  a:link { text-decoration: none;} 
  a:visited { text-decoration: none;} 
  a:active { text-decoration: none;}
  a:hover {text-decoration:underline;}
</style> 
</head>
<body>
	<table>
		<tr  bgcolor="#F7D5D5" >
		<td align="center" width="800" height="100"><font size="4" >결제 완료</font></td>
	</tr>
	<form action="index.jsp?page=./member/member_mypage" name="memberform" method="post"> 
		<tr><td><input type="submit" value="MyPage 바로가기"></td></tr>
		</form>
	
	</table>
</body>
</html> 


  



