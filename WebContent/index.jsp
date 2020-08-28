<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

	<style type="text/css">
		#menu{
	
			position:fixed;		
			top:100px;
			left:0px;
			width:15%;
			height:600px;
			
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
			border-top:2px solid #141414;
			position:absolute;
			top:100px;
			left:15%;
			width:85%;
			height:600px;
			background:url(background/1.jpeg);
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


<body>

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
		}
	%>

<div  id="menu">

		<h3 style="font-family:楷体; color:black;text-align:center"><a href="bookInformation.jsp">全部书籍</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="bookInformation.jsp">文学</a> </h3>
		<h3 style="font-family:楷体; color:white;text-align:center"><a href="bookInformation.jsp">艺术</a> </h3>		
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="bookInformation.jsp">法学</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="bookInformation.jsp">医学</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="bookInformation.jsp">生活</a> </h3>
		<h3 style="font-family:楷体; color:black;text-align:center"><a href="bookInformation.jsp">小说</a> </h3>
	
</div>


		
<div id="mid">

	<table align="center" width="520"  border="0px"  cellspacing="0px">
		<tr height="150px">
			<td colspan="1" align="center"><select name="select" style="width:80px ;height:30px;border:2px;background:none;" >
		   		 			<option value="author">作者 </option>
		   		 			<option value="book"> 书名 </option>   		 				
		   					</select>
		   	</td>	   	
			<td colspan="4" align="center"><input type="text" name="text" style="width:400px ;height:30px;border-radius:5px;background:none;"></td>		
			<td colspan="1" align="center"><a href="FindBookServlet?categoryId=0"><img src="css/search.png" style="height:40px;width:40px;border-radius:5px;background:none;"></a>
			</td>
		</tr>	
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
						<td colspan="1" ><a href="ChargeLoginServlet?use=1&userName=${user.userName }"><img src="css/shouye.png" width="30px" height="30px"></a></td>
						<td colspan="1" ><a href="ToOrderServlet?userId=${user.userId}"><img src="css/dingdan.png" width="30px" height="30px"></a></td>
						<td colspan="1" ><a href="ToMyServlet?userId=${user.userId}"><img src="css/wode.png" width="30px" height="30px"></a></td>
				  </tr>		
				</table>
			</td>	
		</tr>
	</table>
	
</div>

</body>
</html>