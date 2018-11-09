<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="net.custom.db.*" %>
    <%request.setCharacterEncoding("UTF-8");%>
    <%  
	OrderCustomBean ocb = (OrderCustomBean)session.getAttribute("orderdata");
   	int num=ocb.getORDER_CUSTOM_NUM();
	%>
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
	<tr><td><input type="hidden" name="ORDER_CUSTOM_NUM" value=<%=ocb.getORDER_CUSTOM_NUM() %> /></td></tr>
	<tr><td align="center" ><a href="./GalleryAddAction.ua?num=<%=ocb.getORDER_CUSTOM_NUM() %>">디자인 등록하기</a></td></tr>
	</table>
</body>
</html> 






