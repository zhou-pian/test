<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书信息</title>
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
<h2>修改图书信息</h2>
<a href = "showAllBooksServlet">显示所有图书</a>
<a href = "addBookServlet">添加图书</a>
<hr>
<form action="updateBookSrevlet" method="post">
<input type="hidden" name="id" value=${book.bookId }>
<table>
  	<tr>
	<td>相册名称：</td>
	<td><input type="text" name="bookName" value="${book.bookName}" style="width:180px;height:30px"></td>
	</tr>
	
	<tr>
    <td>作者 ：</td>
  	<td><input type="text" name="author" value="${book.author}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>出版社 ：</td>
  	<td><input type="text" name="press" value="${book.press}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>出版日期 ：</td>
  	<td><input type="text" name="pubDate" value="${book.pubDate}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>版次 ：</td>
  	<td><input type="text" name="edition" value="${book.edition}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>页数 ：</td>
  	<td><input type="text" name="numOfPage" value="${book.numOfPage}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>库存余量 ：</td>
  	<td><input type="text" name="inventory" value="${book.inventory}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>已售数量 ：</td>
  	<td><input type="text" name="soldNumber" value="${book.soldNumber}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>图书价格：</td>
  	<td><input type="text" name="price" value="${book.price}" style="width:180px;height:30px"></td>
  	</tr>
  	
  	<tr>
    <td>图书折扣 ：</td>
  	<td><input type="text" name="discount" value="${book.discount}" style="width:180px;height:30px">折</td>
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
		<td colspan="2"><input type="submit" value="修改" style="left:850px;position:absolute"/>
		<input type="reset" value="重置" style="left:1000px;position:absolute"/></td>
	</tr>
  </table>
</form>
</center>
</body>
</html>