
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
import dao.UserDao;
import type.Book;
import type.User;


@WebServlet("/ChargeLoginServlet")
public class ChargeLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int status = 1;
		status = Integer.parseInt(request.getParameter("use"));  //默认为用户模式
		String message = null;   //提示字符
		RequestDispatcher rd = null;
		
		if(status == 1)  //用户
		{
			String userName = request.getParameter("name");
			String userPassword = request.getParameter("password");
			UserDao userDao = new UserDao();
			User user = userDao.findUser(userName);
			
			if(user != null)					
			{
				
				if(userPassword.equals(user.getUserPassword()))
				{
					//System.out.println();
					List<Book> allBooks = new BookDao().findBookName("");
					request.setAttribute("allBooks", allBooks);
					request.setAttribute("message", message);
					request.setAttribute("user", user);
					
					rd = request.getRequestDispatcher("/bookInformation.jsp");
					rd.forward(request, response);
				}
				else
				{
					
					message = "用户名与密码不匹配 ！";
					request.setAttribute("message", message);				
					rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}
				
			}
			else
			{
				message = "该用户名不存在 ！";
				request.setAttribute("message", message);				
				rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				
				
				
			}		
		}
		else  //管理员
		{
			String workerName = request.getParameter("name");
			String workerPassword = request.getParameter("password");
			if (workerName.equals("zhou") && workerPassword.equals("17130305")){
				request.getRequestDispatcher("showAllBooksServlet").forward(request, response);
			}
			else{
					request.setAttribute("message", "用户名或密码错误，请重新输入");
				    request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				
			}
		}

}
