<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>


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
<h3 style="font-family:楷体; color:white;text-align:left"><a href="login.jsp">返回</a> </h3>

		<%
			String ctrl = (String)request.getAttribute("message");
			if(ctrl == "注册失败，请检查信息是否填写完整!")
			{
				
		%>
			
		   <div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			注册失败，请检查信息是否填写完整!
		   </div>

			<script>operate()</script>
		<%
			}
			else if(ctrl == "此名称已被占用，另起一个吧~")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			此名称已被占用，另起一个吧~
		   </div>

			<script>operate()</script>
		<%} %>
			
			
	<form action="AddUserServlet" method="post" enctype="multipart/form-data">
		<table align="center"  >
			<tr height="80px">
				<td colspan="2" align="center" ><h1 style="font-family:楷体; color:white">用户注册</h1>
				</td>
			</tr>
		
			<tr align="center"  height="40px" >
				<td style="font-family:楷体; color:white;"  >用户名:</td>
				<td ><input type="text" name="userName"></td>
			</tr>

			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >密码:</td>
				<td ><input type="text" name="userPassword" ></td>
			</tr>
			
			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >联系方式:</td>
				<td ><input type="text" name="userContact"></td>
			</tr>

			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >收货地址:</td>
				<td ><input type="text" name="userAdd"></td>
			</tr>
			
			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >支付密码:</td>
				<td ><input type="text" name="payPassword"></td>
			</tr>
			
			<tr align="center" height="40px">
				<td style="font-family:楷体; color:white" >头像:</td>
				<td ><input style="width:350px ;" type="file" name="avatar"/></td>
			</tr>
	
		</table>
		
		<h4 style="font-family:楷体; color:white" align="center">
			<input type="submit" value="提交" /> 
			<input type="reset" value="重置" />
		</h4>
	</form>

</body>
</html>