<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页面</title>

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
			if(ctrl == "订单已加入")
			{
				
		%>
			
		   <div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			订单已加入
		   </div>

			<script>operate()</script>
		<%
			}else if(ctrl == "收货成功")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			收货成功
		   </div>

			<script>operate()</script>
		<%
			}else if(ctrl == "亲~，您的宝贝已经收货了呢~")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			亲~，您的宝贝已经收货了呢~
		   </div>

			<script>operate()</script>
			
		<%
			}else if(ctrl == "订单删除成功")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			订单删除成功
		   </div>

			<script>operate()</script>
			
		<%
			}else if(ctrl == "亲~，您的宝贝还未发货，不可以收货哦~")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			您的宝贝还未发货
		   </div>

			<script>operate()</script>
			
		<%
			}else if(ctrl == "亲~，请先查收 ！")
			{
		%>
			<div id="div_test" style="display:none;color:white;line-height:25px;position:absolute;z-index:100;left:50%;top:2%;margin-left:-75px;text-align:center;width:150px;height:25px;background-color:green;font-size:12px;">
    			亲~，请先查收 ！
		   </div>

			<script>operate()</script>	
		
		<%} %>
		
		

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
	
	<table align="center" width="600" border="0"  cellspacing="0" style="position:absolute;top:200px;left:500px;">
		<tr height="200px" align="center"></tr>
		
		<c:forEach items="${mineBooks }" var="order">
		
			<table align="center" width="600"  cellspacing="10" height="100">
				<tr>
					<td>
						<ul>
							<li class="pic">
								<span>
									<img src="${order.cover}" width="80px" height="120px">
								</span>
							</li>
						</ul>
					</td>
					
					<td  style="font-family:楷体; color:white;" >书名：${order.bookName }<br>
					   作者：${order.author}<br>折扣：${order.discount }折<br>物流状态：${order.status }<br>
					</td>		
						
					<td  style="font-family:楷体; color:white;" id="${order.status }">
					  <br>总金额：${order.buynum }<br><br><br>
					</td>
					
					<td>
					
					<c:choose>
						<c:when test="${order.status =='未发货'}">
							<input type="button" value="确认收货" onclick="location='CheckGoodsServlet?orderId=${order.orderId}&userId=${user.getUserId()}'" style="background-color:cornflowerblue;color:white;font-size:12px;						
																		width:90px;
																		height:20px;
																		border-radius:3px;
																		border-width:0;
																		outline:none;
																		cursor:pointer;
																		button:hover{antiquewhite;}">
						</c:when>
						
						<c:when test="${order.status =='已发货'}">
							<input type="button" value="确认收货" onclick="location='CheckGoodsServlet?orderId=${order.orderId}&userId=${user.getUserId()}'" style="background-color:cornflowerblue;color:white;font-size:12px;						
																		width:90px;
																		height:20px;
																		border-radius:3px;
																		border-width:0;
																		outline:none;
																		cursor:pointer;
																		button:hover{antiquewhite;}">
						</c:when>
						
						
						<c:when test="${order.status =='已收货'}">
							<input type="button" value="删除订单" onclick="location='DeleteOrderServlet?orderId=${order.orderId}&userId=${user.getUserId()}'" style="background-color:cornflowerblue;color:white;font-size:12px;						
																		width:90px;
																		height:20px;
																		border-radius:3px;
																		border-width:0;
																		outline:none;
																		cursor:pointer;
																		button:hover{antiquewhite;}">
						</c:when>
						
						
						<c:otherwise> 
							<input type="button" value="啊哦  ！ 状态值没得"  style="background-color:cornflowerblue;color:white;font-size:12px;						
																		width:90px;
																		height:20px;
																		border-radius:3px;
																		border-width:0;
																		outline:none;
																		cursor:pointer;
																		button:hover{antiquewhite;}">
					    </c:otherwise>
					</c:choose>
					
					
					</td>
						
				</tr>						
			</table>				
		</c:forEach>
			
		<tr height="150px" align="center"><h1 align="center">你看到我的底线了>0<</h1></tr>		
	</table>

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