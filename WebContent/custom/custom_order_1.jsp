<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%request.setCharacterEncoding("UTF-8");%>
<html>
<head> 
 <meta charset="UTF-8">  
<title></title>    
  
</head>   
<body> 
  
<form name="formname1" id="formname1" action="./CustomOrderAction_1.co" method="post">
<table align="center" width="900">
  

<tr height="120"><th colspan="3" align="left"><font size="7">CUSTOM : DESIGN</font></th></tr>
<tr><td colspan="3" ><hr /></td></tr>
<tr><th colspan="3" align="center">step1. 디자인</th></tr>
<tr><td colspan="3" ><hr style="border-style: ridge;" /></td></tr>

<tr bgcolor="#E3DEDF"><td colspan="3" ><font size="1">*금액 안내 : 저희 CUSTOM 사이트의 기본 사이즈의 티셔츠는 전액 9900원으로 제작가능합니다.<br>
*추가금액 안내 : 팔(양길이) 합쳐 40cm이상이면 추가 2000원, 가슴둘레 45cm이상 2000원 추가, 총기장 50cm이상 2000원 추가입니다..<br>
>총길이(최대 80cm)를 제외한 모든 사이즈는 최대 60cm까지만 제작가능합니다.</font></td></tr>
<tr><td colspan="3"><hr style="border-style: ridge;" /></td></tr>
</table>

<table align="center" width="900">
 
<tr>
	<th align="center" width="200px"><font size="2">내 디자인상품 NAME : </font></th>
	<td width="250px"><input type="left" name="ORDER_CUSTOM13" maxlength="10" /></td>
	<td rowspan="11" width="450px" align="center"><img alt="logo" src="./images/tsize.jpg" width="450" height="300" align="center"></td>	
</tr>
<tr><td colspan="3" ><hr style="border-style: ridge;" /></td></tr>
<tr>
	<td align="center"><font size="2">키(cm) </font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM1"><td>
</tr>
   
<tr>
	<td align="center"><font size="2">A.목둘레(cm) </font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM2"></td>
</tr>
 
<tr>
	<td align="center"><font size="2">네크라인(택1)</font></td>
	<td align="left">
		<input type="radio" name="ORDER_CUSTOM3" value="V_line"><font size="2">V_line</font></input>
		<input type="radio" name="ORDER_CUSTOM3" value="U_line"><font size="2">U_line</font></input>
	</td>
</tr>
   
<tr>
	<td align="center"><font size="2">B.어깨(cm)</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM4">
	</td>
</tr>

<tr>
	<td align="center"><font size="2">C.왼  팔</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM5"></td>
</tr>

 <tr>
	<td align="center"><font size="2">E.왼팔 소매</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM6"></td>
</tr>

<tr>
	<td align="center"><font size="2">D.오른팔</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM7"></td>
</tr>

<tr>
	<td align="center"><font size="2">F.오른팔 소매</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM8"></td>
</tr>


<tr>
	<td align="center"><font size="2">G.가슴둘레(cm)</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM9"></td>
</tr> 

<tr>
	<td align="center"><font size="2">H.밑단둘레(cm)</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM10"></td>
</tr> 
  
<tr>
	<td align="center"><font size="2">I.총기장(cm)</font></td>
	<td align="left"><input type="text" name="ORDER_CUSTOM11"></td>
</tr>

<tr>
	<td align="center"><font size="2">color</font></td> 
	<td align="left" >  <font size="2">
		<input type="radio" name="ORDER_CUSTOM12" value="red">Red</input>
		<input type="radio" name="ORDER_CUSTOM12" value="yellow">Yellow</input>
		<input type="radio" name="ORDER_CUSTOM12" value="white">white</input>
		</font>
	</td>
</tr>
   <tr><td colspan="3"><hr style="border-style: ridge;" /></td></tr>
<tr>
	<td colspan="3" align="center">
	<input type="submit" value="주문하기" />&nbsp;&nbsp;&nbsp;
	<input type="submit" value="디자인 보관하기" formaction="./BasketAddAction.ba" /></td>
</tr> 

  
</table>
</form>

</body>
</html>