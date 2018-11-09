<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.admin.sale.db.*" %>
<%
	List CouponList=(List)request.getAttribute("couponlist");
	int listcount=((Integer)request.getAttribute("listcount_COUPON")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	//
	List CouponList2=(List)request.getAttribute("couponlist2");
	int listcount2=((Integer)request.getAttribute("listcount_COUPON_USER")).intValue();
	int nowpage2=((Integer)request.getAttribute("page2")).intValue();
	int maxpage2=((Integer)request.getAttribute("maxpage2")).intValue();
	int startpage2=((Integer)request.getAttribute("startpage2")).intValue();
	int endpage2=((Integer)request.getAttribute("endpage2")).intValue();
%>  
<html>
<head>
	<title>C U S T O M</title> 
</head>
<body>

	<table>
		<tr><td height="50" width="900px"></td></tr>
	</table>
<%
if(listcount > 0){
%>

<div style="overflow:scroll; width:900px; height:200px;">
	<table align="center" width="900">
	<tr><th colspan="4"><font size ="2">쿠폰 구매내역</font></th></tr>
	<tr><td colspan="4"><hr style="border-style: ridge;" width="900px"/></td></tr>
	
	<tr height="10">  
		<th width = "300" height="10"><font size ="2">구매 날짜</font></th>
		<th width = "300" height="10"><font size ="2">갯수</font></th>
	</tr>
	<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	 
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<CouponList.size();i++){
			SaleCouponBean gb=(SaleCouponBean)CouponList.get(i);%>
		<%for(int j=0; j<1; j++){ %>
			
				<td align="center"><font size="3"><%=gb.getCOUPON_DATE() %></font></td>
				<td align="center"><font size="3"><%=gb.getCOUPON_SUM()%></font></td>
			<%}%>
				</tr>	
		<%}%> 

<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="4" style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./SaleCouponListAction.sa?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./SaleCouponListAction.sa?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %> 
			<a href="./SaleCouponListAction.sa?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	</div>
	<%
    }
	else
	{
	%>
	<div style="overflow:scroll; width:900px; height:200px;">
	<tr><td colspan="4" height="50"></td></tr>
	<tr><td colspan="4"><hr /></td></tr>
	<tr align="center" valign="middle">
		<td colspan="4">COUPON 구매 내역</td></tr>
	<tr><td><hr style="border-style: ridge;"/></td></tr>
	<tr>	
		<td align="center">
			<font size=2>구매내역이 없습니다.</font>
		</td>
	</tr>
	<tr><td><hr /></td></tr>
	<%
	}
	%>
	
</td>
	</tr>
	</table>
	</div>
	
	
	
<table>
		<tr><td height="50"></td></tr>
	</table>
	
	<%
if(listcount2 > 0){
%>
<div style="overflow:scroll; width:900px; height:200px;">
	
	<table align="center" width="900">
	
	<tr><th colspan="4"><font size ="2">쿠폰 GIFT 내역</font></th></tr>
	<tr><td colspan="4"><hr style="border-style: ridge;" width="900px"/></td></tr>
	
	<tr height="10">  
		<th width = "300" height="10"><font size ="2">선물 날짜</font></th>
		<th width = "300" height="10"><font size ="2">받는이</font></th>
		<th width = "300" height="10"><font size ="2">쿠폰갯수</font></th>
	</tr>
	<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	  
	
	
	<tr style="font-family:Tahoma;font-size:10pt;" width="900" height="30">
		<%for(int i=0;i<CouponList2.size();i++){
			SaleCouponBean gb=(SaleCouponBean)CouponList2.get(i);%>
		<%for(int j=0; j<1; j++){ %>
			
				<td align="center"><font size="3"><%=gb.getCOUPON_DATE() %></font></td>
				<td align="center"><font size="3"><%=gb.getCOUPON_USER_ID()%></font></td>
				<td align="center"><font size="3"><%=gb.getCOUPON_USER_SUM()%></font></td>
			<%}%>
				</tr>	
		<%}%> 
  
<tr><td colspan="4"><hr style="border-style: ridge;"/></td></tr>
	<tr align=center height="10">
		<td  colspan="4" style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage2<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./SaleCouponListAction.sa.me?page2=<%=nowpage2-1 %>">[이전]</a>&nbsp;
			<%} %>  
			
			<%for(int a=startpage2;a<=endpage2;a++){
				if(a==nowpage2){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./SaleCouponListAction.sa?page2=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage2>=maxpage2){ %>
			[다음]
			<%}else{ %> 
			<a href="./SaleCouponListAction.sa?page2=<%=nowpage2+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	</div>
	<%
    }
	else
	{
	%>
	<div style="overflow:scroll; width:900px; height:200px;">
	<tr><td colspan="4" height="50" width="900px" ></td></tr>
	<tr><td colspan="4" width="900px" ><hr width="900px" /></td></tr>
	<tr align="center" valign="middle" width="900px">
		<td colspan="4">GIFT</td></tr>
	<tr><td><hr style="border-style: ridge;" width="900px"/></td></tr>
	<tr>	
		<td align="center" width="900px">
			<font size=2>GIFT 내역이 없습니다.</font>
		</td>
	</tr>
	<tr><td><hr width="900px" /></td></tr>
	<%
	}
	%>
	
</td>
	</tr>
	</table>
	</div>
</body>
</html>