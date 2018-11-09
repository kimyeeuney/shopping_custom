<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "./CenterGaide";
	}
%>
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
 
 	#sub1{
 	display: inline-block; 
 	border: 2px dotted black;
 	margin-left:15px;
 	margin-top:110px;
 	width: 30%;
 	height: 24px;
 	position: fixed;
 	background-color: #8A0624;
 	}
 	
 	#sub2{
 	display: inline-block; 
 	border: 2px dotted black;
 	margin-left:15px;
 	margin-top:140px;
 	width: 30%;
 	height: 24px;
 	position: fixed;
 	background-color: #8A0624;
 	}
 	
 	#sub3{
 	display: inline-block; 
 	border: 2px dotted black;
 	margin-left:15px;
 	margin-top:170px;
 	width: 30%;
 	height: 24px;
 	position: fixed;
 	background-color: #8A0624;
 	}
 	
 	#sub4{
 	display: inline-block; 
 	border: 2px dotted black;
 	margin-left:15px;
 	margin-top:200px;
 	width: 30%;
 	height: 24px;
 	position: fixed;
 	background-color: #8A0624;
 	}
 	
 	#sub5{
 	display: inline-block; 
 	border: 2px dotted black;
 	margin-left:15px;
 	margin-top:230px;
 	width: 30%;
 	height: 24px;
 	position: fixed;
 	background-color: #8A0624;
 	}
 	#sub6{
 	display: inline-block; 
 	border: 2px dotted black;
 	margin-left:15px;
 	margin-top:260px;
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
<title>판매 관리 센터</title>
</head>
<body>
<!-- 

	center main :
		1. 상품 관리
		2. 광고 관리
			
			
			1-1. 판매 중인 상품 목록 - list까지 구현. 삭제-구현해야함
			1-2. 상품판매하기 - 결제는 돼 있으나, 갤러리넘버는 0인상품 불러오기
			1-3. 판매 포인트
			1-4. 할인쿠폰 구매하기  
			1-5. 내 상품 구매회원에게 쿠폰 나눔
			1-6. 판매관련 문의게시판
  
			2-1. 광고구좌 구매하기
			2-2. 광고 리포트(광고 전과 광고 후 판매실적 비교)
			2-3. 광고 관련 문의게시판
			
 --> 
 
<div id="header"><!-- <img src="../images/bac2.png" width="10"> --><a href=# onclick="javascript:history.back(0);return false;" onfocus=blur()>뒤로가기</a></div>


<div id="sub1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./SaleListAction.sa">판매 상품 관리</a><br></div>
<div id="sub2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./SaleOkListAction.sa">상품 등록하기</a><br></div>
<div id="sub3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./SalePointListAction.sa">판매 포인트</a><br></div>
<div id="sub4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./saleCenterMain.jsp?page=userAdminCenter/saleCouponForm">할인쿠폰 구매</a><br></div>
<div id="sub5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./SalePointListAction_2.sa">쿠폰보내기</a><br></div>
<div id="sub6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./SaleCouponListAction.sa">쿠폰사용내역</a><br></div>

<div id="NA"><h1>USER-ADMIN CENTER</h1></div>
<div id="contents"  align="center">
		
		<jsp:include page='<%=pagefile + ".jsp"%>' />
</div>
 
 
</body>
</html>