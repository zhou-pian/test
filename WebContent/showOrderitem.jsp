<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url(background/ww.jpg);background-position: 20px 0px;">
<center>
<h2>显示所有订单信息</h2>
<a href="showOrdersServlet">返回</a>
    <hr>
	<table border = "1" width = "50%" align="center">
		<tr>
		   <th>细则号</th>
		   <th>图书编号</th>
		   <th>订购数量</th>
		   <th>单价</th>
		</tr>
	<c:forEach var="orderitem" items="${orderitemList}">
	    <tr>
	      <td style="text-align:center">${orderitem.orderItemId}</td>
	      <td style="text-align:center"> ${orderitem.bookId }</td>
	      <td style="text-align:center">${orderitem.quantity }</td>
	      <td style="text-align:center">${orderitem.currPrice}
	     </td></tr>
	</c:forEach>
  </table>
	
</center>
</body>
</html>
