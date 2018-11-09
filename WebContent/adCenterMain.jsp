<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "./CenterGaide";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css"> 
  a:link { text-decoration: none; color: white;} 
  a:visited { text-decoration: none; color: white;} 
  a:active { text-decoration: none; color: white;}
  a:hover {text-decoration:underline; color: white;}
 
   body{  
	background-image:url("./images/bck2.jpg");
	background-size: 100%;
	background-repeat: no-repeat;
	} 
	 
	*{
  	margin: 0;
  	padding: 0;
  }
  
  #header {
	height: 5px;
	width:100%;
	position: fixed;
}
 
 	#sub{
 	display: inline-block; 
 	border: 2px dotted black;
 	margin-left:15px;
 	margin-top:110px;
 	width: 30%;
 	height: 24px;
 	position: fixed;
 	background-color: #8A0624;
 	}
 	
 	#contents{
 	margin-top:80px;
 	margin-left: 200px;
 	width: 80%;  
 	height: 610px;
 	position: fixed;
 	background-image:url("./images/sale.png");
 	background-size: 1000px 600px;
 	background-repeat: no-repeat;
 	}
 	
 	#NA{
 	margin-top:40px;
 	margin-left: 200px;
 	position: fixed;
 	}
 	
 	
 	
</style> 
<title>광고 관리 센터</title>
</head>
<body>
<!-- 

	center main :
		1. 상품 관리
		2. 광고 관리
			
			1-1. 판매 가능한 상품 목록
			1-2. 판매 중인 상품 목록
			1-3. 판매 상품 판매현황
			1-4. 판매 포인트
			1-5. 할인쿠폰 구매하기
			1-6. 내 상품 구매회원에게 쿠폰 나눔
  
			2-1. 광고구좌 구매하기
			
 --> 
 
 
 
 <div id="header"><!-- <img src="../images/bac2.png" width="10"> --><a href=# onclick="javascript:history.back(0);return false;" onfocus=blur()>뒤로가기</a>
 <table>
				<tr><td height="100"></td></tr>
			</table>
 </div>

<div id="sub">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="./AdMyListAction.ad"><font size="3"><strong></strong>광고 구좌 현황/구매</font></a><br>
</div>
<div id="NA"><h1>USER-ADMIN AD CENTER</h1></div>
<div id="contents"  align="center">
		<jsp:include page='<%=pagefile + ".jsp"%>' />
</div>

 
</body>
</html>