<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有图书信息</title>
<style type="text/css">
a:link{
	color:blue;
}
a:hover{
	color:black;
}
</style>

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
<center>
<h2>显示所有图书信息</h2>
    <script>operate()</script>
        <%
			String c = (String)request.getAttribute("c");
			if(c == "添加图书成功")
			{
				
		%>
			
		   <div id="div_test" style="display:none;color:white;line-height:18px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:180px;height:35px;background-color:green;font-size:12px;">
    			图书添加成功
		   </div>

			<script>operate()</script>
		<%
			}else if(c == "添加图书失败"){
		%>
			
			<div id="div_test" style="display:none;color:white;line-height:18px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:180px;height:35px;background-color:green;font-size:12px;">
    			图书添加失败！
		   </div>

			<script>operate()</script>
		<%
			}else if(c == "修改图书成功"){
		%>
			
			<div id="div_test" style="display:none;color:white;line-height:18px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:180px;height:35px;background-color:green;font-size:12px;">
    			图书修改成功！
		   </div>

			<script>operate()</script>
		<%
			}else if(c == "修改图书失败"){
		%>
			
			<div id="div_test" style="display:none;color:white;line-height:18px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:180px;height:35px;background-color:green;font-size:12px;">
    			图书修改失败！
		   </div>

			<script>operate()</script>
		<%
			}else if(c == "删除图书成功"){
		%>
					
				<div id="div_test" style="display:none;color:white;line-height:18px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:180px;height:35px;background-color:green;font-size:12px;">
	    			图书删除成功！
			   </div>
				<script>operate()</script>			
	    <%
			}else if(c == "删除图书失败"){
		%>
			
			<div id="div_test" style="display:none;color:white;line-height:18px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:180px;height:35px;background-color:green;font-size:12px;">
    			图书删除失败！
		   </div>

			<script>operate()</script>
		<%	
			}	
		%>
<c:if test="${bookList.size()==0}">
   <a href="addBookServlet">没有图书，请点击添加图书</a>
</c:if>
<c:if test="${bookList.size()!=0}">
    <a href="addBookServlet">添加图书</a>
    <a href="showOrdersServlet">查看所有订单</a>
    <hr>
	<table border = "1" width = "80%" align="center">
		<tr>
		    <th>图书编号</th>
			<th>图书名称</th>
			<th>图书封面</th>
			<th>作者</th>
			<th>出版社</th>
			<th>出版时间</th>
			<th>版次</th>
			<th>页数</th>
			<th>库存余量</th>
			<th>已售数量</th>
			<th>图书价格</th>
			<th>折扣</th>
			<th>所属类别</th>
			<th>修改图书</th>
			<th>删除图书</th>
		</tr>
<c:forEach var="book" items="${bookList}">
	<tr>
	    <td style="text-align:center">${book.bookId}</td>
		<td style="text-align:center">${book.bookName}</td>
		<td style="text-align:center"><img src=${book.cover } width="100" height="150" border="1"/></td>
		<td style="text-align:center">${book.author}</td>
		<td style="text-align:center">${book.press}</td>
		<td style="text-align:center">${book.pubDate}</td>
		<td style="text-align:center">${book.edition}</td>
		<td style="text-align:center">${book.numOfPage}</td>
		<td style="text-align:center">${book.inventory}</td>
		<td style="text-align:center">${book.soldNumber}</td>
		<td style="text-align:center">${book.price}</td>
		<td style="text-align:center">${book.discount}</td>
		<td style="text-align:center">${book.getCategoryName() }
	    <td style="text-align:center"><a href="modifyBookServlet?id=${book.bookId}">修改图书</a></td>
		<td style="text-align:center"><a href="deleteBookServlet?id=${book.bookId}" onClick="return confirm('确认要删除？')">删除图书</a></td>
	</tr>
</c:forEach>
</table>
</c:if>
</center>
</body>
</html>