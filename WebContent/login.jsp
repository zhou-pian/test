<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

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

		<%
			String ctrl = (String)request.getAttribute("message");
			if(ctrl == "注册成功，可立即登录~")
			{
				
		%>
			
		   <div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			注册成功，可立即登录~
		   </div>

			<script>operate()</script>
		<%
			}else if(ctrl == "该用户名不存在 ！")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			该用户名不存在 ！
		   </div>

			<script>operate()</script>
		<%
			}else if(ctrl == "用户名与密码不匹配 ！")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			用户名与密码不匹配 ！
		   </div>

			<script>operate()</script>
			
		<%
			}else if(ctrl == "用户名或密码错误，请重新输入") 
			{
		%>
		<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			用户名或密码错误
		   </div>

			<script>operate()</script>
		<%
			}
		%>

	<form action="ChargeLoginServlet?" method="post">
		<table align="center"  >
			<tr height="80px">
				<td colspan="2" align="center" ><h1 style="font-family:楷体; color:white">上网书店</h1>
				</td>
			</tr>
		
			<tr align="center"  height="40px" >
				<td style="font-family:楷体; color:white;"  >名称:</td>
				<td ><input type="text" name="name" title="名称"></td>
			</tr>

			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >密码:</td>
				<td ><input type="text" name="password" title="密码"></td>
			</tr>
			
			


		</table>
		
		<h4 style="font-family:楷体; color:white" align="center">
			<input type="radio" value="1" name="use" checked>用户
			<input type="radio" value="2" name="use">管理员
		</h4>
		
		<h4 style="font-family:楷体; color:white" align="center">
			<input type="submit" value="登录" /> 
			<input type="reset" value="重置" />
		</h4>
		
		
		
		<h3 style="font-family:楷体; color:white;text-align:right"><a href="register.jsp">还未注册？点击立即拥有帐号</a> </h3>
	</form>

</body>
</html>