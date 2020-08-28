package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import type.User;

@WebServlet("/ToKnownMoreServlet")
public class ToKnownMoreServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = new UserDao().findUser(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/knownMore.jsp").forward(request, response);
	}

}
