<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C U S T O M</title>
<!-- 할인쿠폰 구매 폼 --> 
</head>
<body>
	
<form action="./SaleCouponAction.sa" method="post" name="sc_form" > 
	<table align="center" width="900">
	<tr><td height="50"></td></tr>
	<tr><td height="20" align="left"><font size="5">User-Admin Coupon Center</font></td></tr>
	<tr height="10"><td><hr style="border-style: ridge;"/></td></tr> 
		<tr> 
			<td> Gallery 판매자 전용 < User 10% 할인쿠폰 >
			
				<select id="coupon" name="coupon">
					<option value="1">1장</option>
					<option value="10">10장</option>
					<option value="20">20장</option>
				</select>
				<input type="submit" value="구매하기">
			</td>
		</tr>
	</table>
</form>



<!-- 쿠폰 구매내역 -->





</body>
</html>