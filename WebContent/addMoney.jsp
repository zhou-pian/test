<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加钱</title>
</head>
<body style="background-image: url(background/ww.jpg);background-position: 20px 0px;">

<h1 >账户余额：${user.userSave}￥</h1>
<h3 align="center">请选择要充值的金额</h3>

<table align="center">
<tr>
	<td><a href="AddMoneyServlet?userId=${user.userId}&money=5" >5￥</a></td>
	<td><a href="AddMoneyServlet?userId=${user.userId}&money=10" >10￥</a></td>
	<td><a href="AddMoneyServlet?userId=${user.userId}&money=20" >20￥</a></td>
</tr>
<tr>
	<td><a href="AddMoneyServlet?userId=${user.userId}&money=50" >50￥</a></td>
	<td><a href="AddMoneyServlet?userId=${user.userId}&money=100" >100￥</a></td>
	<td><a href="AddMoneyServlet?userId=${user.userId}&money=200" >200￥</a></td>
</tr>




</table>
<h3 align="center"><a href="AddMoneyServlet?userId=${user.userId}&money=0" >充值完成</a></h3>
</body>


</html>