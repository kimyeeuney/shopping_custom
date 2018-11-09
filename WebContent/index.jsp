<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<%   
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "main";    
	}
%>     
<html>
<head>    
<meta charset="UTF-8"  name="viewport">
<style type="text/css">
	#ingo_1{  
		background-image:url("images/ingo2.png");
		background-size: 100%;
		background-repeat: no-repeat;
		border-radius: 15px;
		
	}  
	  
	#ingo_2{    
		background-image:url("images/ingo1.png");
		background-size: 100%;
		background-repeat: no-repeat;
		border-radius: 15px;
	}   
	
	
	/* #round{
	border-radius: 20px;
	border: 2px solid;
	color: black;
	width: 450px;
	height: 150px;
	margin: 0px;
	padding: 0px;
	} */
	  
</style> 
<title>C U S T O M</title>  
</head>
<body> 
 
<table align="center" width="900px" style="word-break:break-all">


	

	<tr>
		<td name="1_logo" width="450px" align="center"><a href="index.jsp"><img src="images/logo.png" width="350px"></a></td>
		<td name="1_search" width="450px" align="center" ><a href="./GalleryListAction.ua"><img src="images/search_img.png" width="260px"></a></td>
	</tr>
	
	  <tr>  
	  <td colspan="2">  
	<hr/>
	</td>
	</tr>
	
	  
<!-- ------------------------------------------------------------------------------------- -->
		<!-- login1창 : 로그인전에는 "" - 로그인 후 일반회원 관리창으로 바뀜. -->
		
		
	<tr height="140px">

		<td id="ingo_1" align="center" width="450px">
		<div id="round">
		<%  
			String id=(String)session.getAttribute("id");  
			System.out.println(id);  
			if(id==null){   
		%> 
		<jsp:include page="./member/test1.jsp"></jsp:include>
		<%
			}
			else{      
		%>  
			<jsp:include page="./member/member_UserPage.jsp"></jsp:include> 
		<%	
			}       
		%> 
		</td>  
		      
		      
		      
		      
		      
<!-- ------------------------------------------------------------------------------------- -->
		<!-- login2창 : 로그인전에는 로그인창 - 로그인 후 판매회원 관리창으로 바뀜. -->
		
		<td id="ingo_2" align="center" width="450px">  
  		
		<%
			System.out.println(id);   
			if(id==null){
		%>
			<jsp:include page="./member/member_login.jsp"/>  
		<% 
			}   
			else{    
		%> 
		<jsp:include page="./member/member_loginok.jsp"/>
		<%
			}  
		%>    
		</div>
		</td>
	</tr> 
	
	
		
	<tr>
	  <td colspan="2">
	</td>
	
	</tr>  

<!-- ------------------------------------------------------------------------------------- -->
	<!-- sub menu -->
	  
	<tr align="center" width="900px"><td colspan="2"><jsp:include page="sub.jsp"/></td></tr>
	
	
	<tr>  
	  <td colspan="2">
	<hr/>
	</td>
	</tr> 
	    

<!-- ------------------------------------------------------------------------------------- -->	
	<!-- main contents : 기본 메인 <베스트상품5 / 광고구좌5> --> 
	  
 
		<tr> 
			<td colspan="2" style="word-break:break-all" align="center">
			
			   
			
			<jsp:include page='<%=pagefile + ".jsp"%>' />
			  
			
			
			
			</td>
		</tr> 



<!-- ------------------------------------------------------------------------------------- -->		
	<!-- bottom -->

	<tr>
	  <td colspan="2">  
	<hr/>  
	</td>
	</tr>
	
	<tr id="bottom">
			<td width=100% colspan=2 height="200px">
			<jsp:include page="bottom.jsp" />
			</td>
		</tr> 
	
	
	
	</table>
	
</body>
</html>