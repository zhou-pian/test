<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
<style type="text/css">
a:link{
	color:blue;
}
a:hover{
	color:black;
}

</style>
</head>
<body>
<center>
<br><br>
<h2>新增图书</h2>
<a href="showAllBooksServlet">查看所有图书</a>
<a href="showOrdersServlet">查看所有订单</a>
<hr>
<form action="uploadBookServlet" method="post" enctype="multipart/form-data">
<table>
    <tr>
    <td>图书名称：</td>
  	<td><input type="text" name="bookName" title="图书名称"></td>
  	</tr>
  	
  	<tr>
  	<td>图书封面：</td>
  	<td><input type="file" name="photofile"></td>
  	</tr>
  	
  	<tr>
    <td>作者 ：</td>
  	<td><input type="text" name="author" title="作者"></td>
  	</tr>
  	
  	<tr>
    <td>出版社 ：</td>
  	<td><input type="text" name="press" title="出版社"></td>
  	</tr>
  	
  	<tr>
    <td>出版日期 ：</td>
  	<td><input type="text" name="pubDate" title="出版日期"></td>
  	</tr>
  	
  	<tr>
    <td>版次 ：</td>
  	<td><input type="text" name="edition" title="版次"></td>
  	</tr>
  	
  	<tr>
    <td>页数 ：</td>
  	<td><input type="text" name="numOfPage" title="页数"></td>
  	</tr>
  	
  	<tr>
    <td>库存余量 ：</td>
  	<td><input type="text" name="inventory" title="库存余量"></td>
  	</tr>
  	
  	<tr>
    <td>已售数量 ：</td>
  	<td><input type="text" name="soldNumber" value="0" title="已售数量"></td>
  	</tr>
  	
  	<tr>
    <td>图书价格：</td>
  	<td><input type="text" name="price" title="图书价格"></td>
  	</tr>
  	
  	<tr>
    <td>图书折扣 ：</td>
  	<td><input type="text" name="discount" value="10" title="折扣">折</td>
  	</tr>
  	
  	<tr>
  	<td>所属类别：</td>
  	<td><select name="categoryId">
  	<c:forEach var="category" items="${categoryList}">
  	 <option value="${category.categoryId}">${category.categoryName}</option>
  	 </c:forEach>
  	</select></td>
  	</tr>
  	
  	<tr>
		<td colspan="2"><input type="submit" value="新书上架" />
		<input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</center>
</body>
</html>