<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a:link{
	color:blue;
}
a:hover{
	color:black;
}
</style>
</head>
<body style="background-image: url(background/ww.jpg);background-position: 20px 0px;">
<center>
<h2>显示所有订单信息</h2>
<a href="addBookServlet">添加图书</a>
<a href="showAllBooksServlet">查看所有图书</a>
    <hr>
	<table border = "1" width = "80%" align="center">
		<tr>
		   <th>订单编号</th>
		   <th>顾客名称</th>
		   <th>联系方式</th>
		   <th>收货地址</th>
		   <th>总金额</th>
		   <th>发货状态</th>
		   <th>查看</th>
		</tr>
	<c:forEach var="order" items="${orderList}">
	    <tr>
	      <td style="text-align:center">${order.orderId}</td>
	      <td style="text-align:center">${order.getUserName() }</td>
	      <td style="text-align:center">${order.getUserContact() }</td>
	      <td style="text-align:center">${order.getUserAdd() }</td>
	      <td style="text-align:center">${order.total}
	      <c:if test="${order.status=='已发货'}">
	          <td style="text-align:center">${order.status}</td>
	       </c:if>
	       <c:if test="${order.status=='未发货'}">
	           <td style="text-align:center"><a href="modifyStatusServlet?id=${order.orderId}">${order.status}</a></td>
	       </c:if>
	       <c:if test="${order.status=='已收货'}">
	          <td style="text-align:center">${order.status}</td>
	       </c:if>
	       <td style="text-align:center"><a href="showOrderitemServlet?id=${order.orderId}">查看</a></td>
	       </tr>
	</c:forEach>
  </table>
	
</center>
</body>
</html>