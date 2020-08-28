package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.UserDao;
import type.Book;
import type.Order;
import type.User;


@WebServlet("/CheckGoodsServlet")
public class CheckGoodsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		User user = new UserDao().findUser(userId);
		String status = new OrderDao().FindOrder(orderId).getStatus();
		String message = null;
		if(status.equals("未发货"))
		{
			message = "亲~，您的宝贝还未发货，不可以收货哦~";
		}
		else if(status.equals("已发货"))
		{
			message = "收货成功";
			status = "已收货";
			int i = new OrderDao().checkGoods(orderId, status);
			
		}
		else  //已收货状态
		{
			message = "您的宝贝已经收货";
		}
		
		List<Order> allOrders = new OrderDao().FindOrders(userId);
		List<Book> mineBooks = new ArrayList<Book>();
		for(int i = 0; i < allOrders.size(); i++)
		{
			Book book = new OrderDao().FindOrderss(allOrders.get(i).getOrderId());
			
			mineBooks.add(book);
			
		}		
		request.setAttribute("mineBooks", mineBooks);
		request.setAttribute("message", message);


		request.setAttribute("user", user);
		request.getRequestDispatcher("/order.jsp").forward(request, response);
	}

}
