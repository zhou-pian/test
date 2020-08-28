package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.OrderDao;
import dao.OrderitemDao;
import dao.UserDao;
import type.Book;
import type.Order;
import type.User;


@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int num = Integer.parseInt(request.getParameter("num"));
		double money = Double.parseDouble(request.getParameter("money"));
		String pw = request.getParameter("payPassword");
		User user = new UserDao().findUser(userId);
		Book book = new BookDao().findBookId(bookId);
		
		
		if(pw.equals(user.getPayPassword()))
		{
			//时间
			Date date = new Date(); 
			int year = date.getYear()+1900;       
			//获取当前年份(2位)		                                    
			int month = date.getMonth()+1;      
			//获取当前月份(0-11,0代表1月)	                                    
			int date1 = date.getDate();       
			//获取当前日(1-31)	                                    
			int hour = date.getHours();      
			//获取当前小时数(0-23)		                                    
			int minutes = date.getMinutes();    
			//获取当前分钟数(0-59)	                                    
			int seconds = date.getSeconds();    
			//获取当前秒数(0-59)     	                                    
			String orderTime = year+"_"+month+"_"+date1+"_"+hour+"_"+minutes+"_"+seconds;
	
			Float money2= (float) (book.getPrice() * book.getDiscount() * 0.1);  //折后单价
			int i = 0;
			if(money > user.getUserSave())  //判断余额是否充足
			{
				i = 0;     //余额不足
			}
			else
			{
				i = new UserDao().addMoney(user, -money);
				i = new OrderDao().addOrder(user.getUserId(), money, orderTime, "未发货");  //money订单总金额
				Order order = new OrderDao().FindOrder(orderTime);
				i = new OrderitemDao().addOrderitem(order.getOrderId(), book.getBookId(), num, money2);
				
			}
			
			if(i == 1)    //判断回到的页面
			{
				List<Order> allOrders = new OrderDao().FindOrders(user.getUserId());
				List<Book> mineBooks = new ArrayList<Book>();
				
				for(int j = 0; j < allOrders.size(); j++)
				{
					Book b = new OrderDao().FindOrderss(allOrders.get(j).getOrderId());
					mineBooks.add(b);
					
				}		
				request.setAttribute("mineBooks", mineBooks);
				request.setAttribute("user", user);	
				request.setAttribute("message", "订单已加入");
				request.getRequestDispatcher("/order.jsp").forward(request, response);
			}
			else
			{
				List<Book> allBooks = new BookDao().queryAllBooks();  //暂时回到全部书籍
				request.setAttribute("allBooks", allBooks);			
				request.setAttribute("user", user);
				request.setAttribute("message", "购买失败,账户余额不足");
				request.getRequestDispatcher("/bookInformation.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("message", "支付密码错误 ！");
			request.setAttribute("money", money);
			request.setAttribute("user", user);
			request.setAttribute("book", book);
			request.setAttribute("num", num);
			request.getRequestDispatcher("/pay.jsp").forward(request, response);
		}
		
		
				
		
	}

}
