package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.UserDao;
import type.Category;
import type.User;


@WebServlet("/ToMyServlet")
public class ToMyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		//RequestDispatcher rd = null;
		User user = new UserDao().findUser(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/mine.jsp").forward(request, response);
		
	}

}
