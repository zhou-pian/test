package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.CategoryDao;
import dao.UserDao;
import type.Book;
import type.User;


@WebServlet("/FindBookServlet")
public class FindBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = new UserDao().findUser(userId);
		//String message = null;   //提示字符
		RequestDispatcher rd = null;
		List<Book> list = new ArrayList<Book>();
		
		//System.out.println(categoryId);
		if(categoryId == 0)
		{	
			String select = request.getParameter("select");
			String text = request.getParameter("text");
			
			
			if(select.equals("book"))
			{
				
				BookDao bookDao = new BookDao();				
				list = bookDao.findBookName(text);
		
			}
			else
			{
				
				BookDao bookDao = new BookDao();				
				list = bookDao.findBookAuthor(text);
			}
			
		}
		else if(categoryId == 100)   //所有书籍
		{
			BookDao bookDao = new BookDao();
			//CategoryDao categoryDao = new CategoryDao();			
			list = bookDao.findBookName("");
		}
		else
		{
			BookDao bookDao = new BookDao();
			//CategoryDao categoryDao = new CategoryDao();			
			list = bookDao.findTypeBook(categoryId);
		}
		request.setAttribute("user", user);		
		request.setAttribute("allBooks", list);			
		request.getRequestDispatcher("bookInformation.jsp").forward(request,response);
		
		
		
	}

}
