package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.CategoryDao;
import dao.OrderDao;
import dao.OrderitemDao;
import dao.UserDao;
import type.Book;
import type.Category;
import type.Order;
import type.Orderitem;
import type.User;

@WebServlet("/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = new UserDao().findUser(userId);
		List<Order> allOrders = new OrderDao().FindOrders(userId);
		List<Book> mineBooks = new ArrayList<Book>();
		for(int i = 0; i < allOrders.size(); i++)
		{
			Book book = new OrderDao().FindOrderss(allOrders.get(i).getOrderId());
			
			mineBooks.add(book);
			
		}		
		request.setAttribute("mineBooks", mineBooks);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/order.jsp").forward(request, response);
		
	}

}
