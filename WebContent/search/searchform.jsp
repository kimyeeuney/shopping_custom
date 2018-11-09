<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>  
</head>
<body>

<form name="searchformA" action="./SearchAction.sc" method="post">
<table> 
	<tr><!-- name으로 넘기는거임. 안그럼 null뜸 -->
		<td><input type="text" name="SEARCH_TEXT" size="30" /></td>
		<td align="center"><a href="indextest.jsp"><img src="images/seatchimg.png" width="20px" height="20px"></a></td>
	</tr>
</table>
</form>

</body>
</html>