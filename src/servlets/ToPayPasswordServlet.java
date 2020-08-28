package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.UserDao;
import type.Book;
import type.User;

/**
 * Servlet implementation class ToPayPasswordServlet
 */
@WebServlet("/ToPayPasswordServlet")
public class ToPayPasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		User user = new UserDao().findUser(userId);
		Book book = new BookDao().findBookId(bookId);
		
		if(num <= 0)
		{
			request.setAttribute("user", user);
			List<Book> allBooks = new BookDao().findBookName("");
			request.setAttribute("message", "购买数量不能为0");
			request.setAttribute("allBooks", allBooks);
			request.getRequestDispatcher("/bookInformation.jsp").forward(request, response);
		}
		else if(num > book.getInventory())
		{
			request.setAttribute("user", user);
			List<Book> allBooks = new BookDao().findBookName("");
			request.setAttribute("message", "库存余量不足");
			request.setAttribute("allBooks", allBooks);
			request.getRequestDispatcher("/bookInformation.jsp").forward(request, response);
		}
		else
		{
			double money= (double) (book.getPrice() * book.getDiscount() * 0.1 * num);
			request.setAttribute("money", money);
			request.setAttribute("user", user);
			request.setAttribute("book", book);
			request.setAttribute("num", num);
			request.getRequestDispatcher("/pay.jsp").forward(request, response);
		}
		
		
		
		
	}

}
