<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<script>
function operate()
{
    document.getElementById('div_test').style.display="";
    setTimeout("disappeare()",4000);
}
function disappeare(){
    document.getElementById('div_test').style.display="none";
}
</script>






</head>
<body style="background-image: url(background/ww.jpg);background-position: 20px 0px;">
<h3 style="font-family:楷体; color:white;text-align:left"><a href="ToMyServlet?userId=${user.userId }">返回</a> </h3>

		<%
			String ctrl = (String)request.getAttribute("message");
			if(ctrl == "修改失败，请检查是否填写完整信息!")
			{
				
		%>
			
		   <div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			修改失败，请检查是否填写完整信息!
		   </div>

			<script>operate()</script>
		<%
			}
		%>
			
			
	<form action="ModifyUserServlet?userId=${user.userId }" method="post" enctype="multipart/form-data">
		<table align="center"  >
			<tr height="80px">
				<td colspan="2" align="center" ><h1 style="font-family:楷体; color:white">编辑个人信息</h1>
				</td>
			</tr>
		
			<tr align="center"  height="40px" >
				<td style="font-family:楷体; color:white;"  >用户名:</td>
				<td ><input type="text" name="userName" value="${user.userName }"></td>
			</tr>

			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >密码:</td>
				<td ><input type="text" name="userPassword" value="${user.userPassword }"></td>
			</tr>
			
			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >联系方式:</td>
				<td ><input type="text" name="userContact" value="${user.userContact }"></td>
			</tr>

			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >收货地址:</td>
				<td ><input type="text" name="userAdd" value="${user.userAdd }"></td>
			</tr>
			
			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >支付密码:</td>
				<td ><input type="text" name="payPassword" value="${user.payPassword }"></td>
			</tr>
			
			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >头像:</td>
				<td ><input style="width:350px ;" type="file" name="avatar" value="${user.avatar }"/></td>
			</tr>
	
		</table>
		
		<h4 style="font-family:楷体; color:white" align="center">
			<input type="submit" value="提交" /> 
			<input type="reset" value="重置" />
		</h4>
	</form>

</body>
</html>