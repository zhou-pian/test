package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderitemDao;
import type.Orderitem;

/**
 * Servlet implementation class ShowOrderitemServlet
 */
@WebServlet("/showOrderitemServlet")
public class ShowOrderitemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderitemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		List<Orderitem> arrayList = new OrderitemDao().queryOrderitem1(id);
		request.setAttribute("orderitemList", arrayList);
		RequestDispatcher rd = request.getRequestDispatcher("/showOrderitem.jsp");
		rd.forward(request, response);
	}

}
