<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>CUSTOM:LOGIN</title>
<style type="text/css"> 
A:link {text-decoration:none; color:black;} 
A:visited {text-decoration:none; color:black;} 
A:hover {text-decoration:none; color:red;} 
</style>
<script>
function check(){
	var id=loginform.MEMBER_ID.value;
	var pass=loginform.MEMBER_PW.value;
	
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		loginform.MEMBER_ID.focus();
		return false;
	}
	if(pass.length == 0){
		alert("비밀번호를 입력하세요.");
		loginform.MEMBER_PW.focus();
		return false;
	} 
	
	return true;
}
function openConfirmId(loginform){	
	var url="./MemberFind.me";
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=450px,height=300");
} 
</script>
</head>
<body>
<!--회원 로그인 -->
<form action="./MemberLoginAction.me" method=post name=loginform
	onsubmit="return check()">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2"><input type="text" name="MEMBER_ID" value="아이디"></td>
		<!-- <td></td> -->
		<td rowspan="2"><input type="submit" value="로그인" height="30px" style="width:60px;height:50px;border-color:color:#F5F7F7;"></td>
	</tr>
	  
	<tr>
		<td colspan="2"><input type="password" name="MEMBER_PW" value="비밀번호"></td>
		<!-- <td></td> -->
		<!-- <td></td> -->
	</tr>
	
	<tr>
		<td colspan="3"><font size="2">
			<a href="index.jsp?page=/member/member_join">회원가입</a>&nbsp;&nbsp;
			<a href="openConfirmId(this.form)">아이디/비밀번호찾기</a>
			</font>
		</td>
	</tr>
</form>
</table>
</body>
</html>