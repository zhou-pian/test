package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.UserDao;
import type.Book;
import type.User;


@WebServlet("/ToBookMoreServlet")
public class ToBookMoreServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		User user = new UserDao().findUser(userId);
		Book book = new BookDao().findBookId(bookId);
		request.setAttribute("user", user);
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("/more.jsp").forward(request, response);
		
	}

}
