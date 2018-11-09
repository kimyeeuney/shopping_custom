<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C U S T O M : D E T A I L E</title>
</head>
<body> 
	
	<form name="Searchform" action="./SearchAction.sc" method="post">
	<table width="100%">
		<tr><td colspan="2"><hr /></td></tr>
		<tr><th colspan="2">상 세 검 색</td></th>
		<tr><td colspan="2"><hr style="border-style: ridge;" /></td></tr>
		<tr>
			<th><font size="2">키&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<td>
				<input type="radio" name="search_height" value="140"><font size="2">149미만&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_height" value="150"><font size="2">150대&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_height" value="160"><font size="2">160대&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_height" value="170"><font size="2">170대&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_height" value="180"><font size="2">180대&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_height" value="190"><font size="2">190이상&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
			</td>
		</tr>
		
		 
		<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>
		<tr>
			<th><font size="2">넥 라인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<td>
				<input type="radio" name="search_nek" value="V"><font size="2">V 라인&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_nek" value="U"><font size="2">U 라인&nbsp;&nbsp;&nbsp;&nbsp;</font></input>
			</td>
		</tr>
		
		
		<tr><td colspan="2"><hr style="border-style: ridge;" /></td></tr>
		<tr>
			<th><font size="2">총기장&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<td>
				<input type="radio" name="search_Upper" value="39"><font size="2">40cm 미만&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_Upper" value="40"><font size="2">40cm 이상&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_Upper" value="50"><font size="2">50cm 이상&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_Upper" value="60"><font size="2">60cm 이상&nbsp;&nbsp;&nbsp;</font></input>
			</td>
		</tr>
		
		
		<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>
		<tr>
			<th><font size="2">팔&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<td>
				<input type="radio" name="search_arm" value="19"><font size="2">20cm 미만&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_arm" value="20"><font size="2">20cm 이상&nbsp;&nbsp;&nbsp;</font></input>
			</td>
		</tr>
		
		
		<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>
		<tr>
			<th><font size="2">가슴둘레(단면)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<td>
				<input type="radio" name="search_B" value="44"><font size="2">45cm 미만&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_B" value="45"><font size="2">45cm 이상&nbsp;&nbsp;&nbsp;</font></input>
			</td>
		</tr>
		
		
		
		<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>
		<tr>
			<th><font size="2">허리둘레(단면)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<td>
				<input type="radio" name="search_H" value="39"><font size="2">40cm 미만&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_H" value="40"><font size="2">40cm 이상&nbsp;&nbsp;&nbsp;</font></input>
			</td>
		</tr>
		
		
		<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>
		<tr>
			<th><font size="2">Color&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
			<td>
				<input type="radio" name="search_C" value="red"><font size="2">Red&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_C" value="yellow"><font size="2">Yellow&nbsp;&nbsp;&nbsp;</font></input>
				<input type="radio" name="search_C" value="white"><font size="2">white&nbsp;&nbsp;&nbsp;</font></input>
			</td>
		</tr>
		<tr><td colspan="2"><hr style="border-style: ridge;"/></td></tr>
		
		<!-- 버튼 --> 
		<tr><td colspan="2" align="center" height="10px">
		<input type="image" src="./images/seatchimg.png" width="15">검색</input></td></tr>
		<tr><td colspan="2"><hr /></td></tr>
	</table>
  </form> 
</body>
</html>