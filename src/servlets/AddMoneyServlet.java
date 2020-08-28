package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import type.User;


@WebServlet("/AddMoneyServlet")
public class AddMoneyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		Float addMoney = Float.parseFloat(request.getParameter("money"));
		User user1 = new UserDao().findUser(userId);
		if(addMoney==0)
		{
			
			request.setAttribute("user", user1);
			request.getRequestDispatcher("/mine.jsp").forward(request, response);
			
		}
		else
		{
			
			int i = new UserDao().addMoney(user1, addMoney);
			User user = new UserDao().findUser(userId);  //充值后显示账户余额刷新
			request.setAttribute("user", user);
			request.getRequestDispatcher("/addMoney.jsp").forward(request, response);
		}
		
		
		
	}

}
