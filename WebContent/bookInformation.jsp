<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买页面</title>

<style type="text/css">
		#menu{
	
			position:fixed;		
			top:100px;
			left:0px;
			width:15%;
			height:600px;
			background-color: #525252;
			border-top:2px solid #141414;
			padding: 10px 0px;
			text-align: center;		
	
		}
	
		#menu a{
	
			margin: 0 8px;
			color: #fff;
			text-decoration: none;
			font-weight: bold;
			font-size: 15px;
	
		}
	
		#menu a:hover{
			color: #999;
	
		}
	
		#menu .all{
			color: yellow
	
		}
		
		#mid{
			font-family:Kaiti;
			border-top:2px solid #141414;
			position:absolute;
			top:100px;
			left:15%;
			width:85%;
			height:600px;
						
			background-size:cover;
			
		}
		
		#top{
		
			position:fixed;
			top:0px;
			left:0px;
			width:100%;
			height:100px;
			background-color:#525252;
		}
		
		.book{
			float:left;
			width:500px;
			height:200px;
		}
		
		ul li{
			list-style:none;
			width:85px ;
		}
		.pic{
			background:black;
		}
		.pic span{
			display:block;
			boder:1px solid #333;
			padding:3px;
			background:black;
			position:relative;
			top:-4px;
			left:-4px;
		}
			
	</style>

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




<body style="background:#2F4F4F;background-attachment:fixed;background-repeat:no-repeat;background-size:100%;">

		<%
			String ctrl = (String)request.getAttribute("message");
			if(ctrl == "购买失败,账户余额不足")
			{
				
		%>
			
		   <div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:50%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			购买失败,账户余额不足
		   </div>

			<script>operate()</script>
		<%
			}else if(ctrl == "购买数量不能为0")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:50%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			购买数量不能为0
		   </div>

			<script>operate()</script>
		<%
			}else if(ctrl == "库存余量不足")
			{
		%>
				<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:50%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
					库存余量不足
			   </div>
		
				<script>operate()</script>
		<%
			}
		%>

<div  id="menu">
		
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="FindBookServlet?categoryId=100&userId=${user.userId }">全部书籍</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="FindBookServlet?categoryId=1&userId=${user.userId }">文学</a> </h3>
		<h3 style="font-family:楷体; color:white;text-align:center"><a href="FindBookServlet?categoryId=2&userId=${user.userId }">艺术</a> </h3>		
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="FindBookServlet?categoryId=3&userId=${user.userId }">法学</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="FindBookServlet?categoryId=4&userId=${user.userId }">医学</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="FindBookServlet?categoryId=5&userId=${user.userId }">计算机</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="FindBookServlet?categoryId=6&userId=${user.userId }">小说</a> </h3>
	
</div>




<div id="mid">
	<form action="FindBookServlet?categoryId=0&userId=${user.userId}" method="post">
		<table align="center" width="520"  border="0px"  cellspacing="0px">
			<tr height="150px">
				<td colspan="1" align="center"><select name="select" style="width:80px ;height:30px;border:2px;background:none;" >
			   		 			<option value="book"> 书名 </option>   		 
			   		 			<option value="author">作者 </option>
			   		 							
			   					</select>
			   	</td>	   	
				<td colspan="4" align="center"><input type="text" name="text" style="width:400px ;height:30px;border-radius:5px;background:none;"></td>		
				<td colspan="2" align="center"><input type="submit" value="搜索" style="height:30px;background:none;																		
																			border-width:0;
																			outline:none;
																			cursor:pointer;
																			"/>
				</td>
			</tr>	
		</table>
	</form>
	
			<c:forEach items="${allBooks }" var="book">				
			<form action="ToPayPasswordServlet?userId=${user.userId }&bookId=${book.bookId}" method="post">
			<table align="center" style="float:left" width="200px" height="200px">
				<tr>
					<td>
						<ul>
							<li class="pic">
								<span>
									<a href="ToBookMoreServlet?userId=${user.userId }&bookId=${book.bookId}">
										<img src="${book.cover}" width="80px" height="100px">
									</a>
								</span>
							</li>
						</ul>
					</td>
				</tr>
				
				<tr>
					<td  style="font-family:楷体; color:white;font-size:10px;" >
						<ul>	
							<li>
								书名：${book.bookName }
							</li>
						</ul>					   
					</td>		
				</tr>
					
				<tr>
					<td  style="font-family:楷体; color:white;font-size:10px;" >
						<ul>	
							<li>
						   		作者：${book.author}
						   </li>
					   </ul>
					</td>		
				</tr>
				<tr>					
					<td  style="font-family:楷体; color:white;font-size:10px;" >		
						<ul>	
							<li>				
								购买数量：<input type="text" name="num" style="width:25px ;height:12px;" value="0">	
							</li>
						</ul>													
					</td>	
				</tr>
				<tr>					
					<td  style="font-family:楷体; color:white;" >
						<ul>	
							<li>								
								<input type="submit" value="买买买" style="background-color:cornflowerblue;color:white;font-size:12px;						
																		width:90px;
																		height:20px;
																		border-radius:3px;
																		border-width:0;
																		outline:none;
																		cursor:pointer;
																		button:hover{antiquewhite;}"/> 																																																					
							</li>
						</ul>																															
					</td>	
				</tr>
							
			</table>
			</form>			
			</c:forEach>	
			
		<ul>	
			<li style="width:600px ;">								
				<h1>没有更多了</h1>																																																		
			</li>
		</ul>			
</div>



<div id="top">

	<table align="center" width="1100px"  border="0px"  cellspacing="0px">
		<tr height="80px" align="center">
			<td>
				<table align="left">
				  <tr>
						<td colspan="1" ><h1 style="font-family:Kaiti">欢迎浏览网上书店</h1></td>
				  </tr>
				</table>
			</td>
			<td>
				<table align="right" width="200px">
				  <tr>
						<td colspan="1" ><a href="ChargeLoginServlet?use=1&name=${user.userName }&password=${user.userPassword }"><img src="css/shouye.png" width="30px" height="30px"></a></td>
						<td colspan="1" ><a href="ShowOrderServlet?userId=${user.userId}"><img src="css/dingdan.png" width="30px" height="30px"></a></td>
						<td colspan="1" ><a href="ToMyServlet?userId=${user.userId}"><img src="css/wode.png" width="30px" height="30px"></a></td>
				  </tr>		
				</table>
			</td>	
		</tr>
	</table>
	
</div>


</body>
</html>	
																							
