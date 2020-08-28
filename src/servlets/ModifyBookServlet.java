package servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import type.Book;
import type.Category;
import dao.BookDao;
import dao.CategoryDao;

/**
 * Servlet implementation class ModifyBookServlet
 */
@WebServlet("/modifyBookServlet")
public class ModifyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		Book book = new BookDao().queryBook(id);
		request.setAttribute("book", book);
		List<Category> arrayList = new CategoryDao().queryAllCategories();
		request.setAttribute("categoryList", arrayList);
		request.getRequestDispatcher("/modifyBook.jsp").forward(request, response);
	}

}
