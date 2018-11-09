<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	div{
		border: 1px;
		padding: 0px;
	}
</style>
</head>
<body>

<table style="word-break:break-all">


<tr>
	<%for(int j=0; j<9; j++){ %>
		<%for(int i=0; i<3; i++){ %>
			<td><%=j %></td>
	<%} %> 
	</tr>
	<%} %>



</table>

</body>
</html>



 

