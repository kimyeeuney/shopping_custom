<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> New Document </title>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">  


<script language="javascript" src="./js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script language="javascript" src="./js/jquery-ui.min.js" type="text/javascript"></script>
<script language="javascript" src="./js/jq.rolling.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="./css/jq.rolling.css"/>

</head>
<body>

<div>  
	<div id="rolling">
		<ul>
			<li class="sp01"><a href="index.jsp"><img src="./images/main1.jpg" width="1200px" height="320"></a></li>
			<li class="sp02"><a href="index.jsp"><img src="./images/main1.jpg" width="1200px" height="320"></a></li>
			<li class="sp03"><a href="index.jsp"><img src="./images/main1.jpg" width="1200px" height="320"></a></li>
		</ul>
	</div>
<ul class="pages"></ul>
</div>

 
<script>
	$("#rolling").rolling(900,290,{autoscroll:1, delay:2500});
</script> 
</body>
</html>