package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

/**
 * Servlet implementation class UpdateBookSrevlet
 */
@WebServlet("/updateBookSrevlet")
public class UpdateBookSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookSrevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int bookId = Integer.parseInt(request.getParameter("id"));
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String pubDate = request.getParameter("pubDate");
	    int edition = Integer.parseInt(request.getParameter("edition"));
	    int numOfPage = Integer.parseInt(request.getParameter("numOfPage"));
	    int inventory = Integer.parseInt(request.getParameter("inventory"));
	    float price = Float.parseFloat(request.getParameter("price"));
	    float discount = Float.parseFloat(request.getParameter("discount"));
	    int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	    BookDao bookDao = new BookDao();
		int result = bookDao.modifyBook(bookId,bookName,author,press,pubDate,edition,numOfPage,inventory,price,discount,categoryId);
		
		if(result == 1){
			request.setAttribute("c", "修改图书成功");
		}
		else{
			request.setAttribute("c", "修改图书失败");
		}
		request.getRequestDispatcher("showAllBooksServlet").forward(request, response);
	}

}
