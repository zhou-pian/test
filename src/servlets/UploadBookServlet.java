package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

import type.Book;
import dao.BookDao;



/**
 * Servlet implementation class UploadBookServlet
 */
@WebServlet("/uploadBookServlet")
public class UploadBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadBookServlet() {
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
		SmartUpload sum=new SmartUpload();
		sum.initialize(getServletConfig(), request, response);
		try{
			
			sum.setAllowedFilesList("gif,jpg,doc,xls,txt,PNG");
			sum.setDeniedFilesList("exe,bat");
			sum.setMaxFileSize(1000000);
			sum.setTotalMaxFileSize(20000000);
			//sum.setCharset("UTF-8");
			sum.upload();
			
			com.jspsmart.upload.File file=null;
			file=sum.getFiles().getFile(0);
			String filepath = null;
			if(!file.isMissing()){
				filepath="upload\\";
				filepath += file.getFileName();
				file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);
			}
			com.jspsmart.upload.Request surequest = sum.getRequest();
			String bookName = surequest.getParameter("bookName");
			String author = surequest.getParameter("author");
			String press = surequest.getParameter("press");
			String pubDate = surequest.getParameter("pubDate");
		    int edition = Integer.parseInt(surequest.getParameter("edition"));
		    int numOfPage = Integer.parseInt(surequest.getParameter("numOfPage"));
		    int inventory = Integer.parseInt(surequest.getParameter("inventory"));
		    int soldNumber = Integer.parseInt(surequest.getParameter("soldNumber"));
		    float price = Float.parseFloat(surequest.getParameter("price"));
		    float discount = Float.parseFloat(surequest.getParameter("discount"));
		    int categoryId = Integer.parseInt(surequest.getParameter("categoryId"));
		    Book book = new Book(bookName,filepath,author,press,pubDate,edition,numOfPage,inventory,soldNumber,price,discount,categoryId);
			BookDao bookDao = new BookDao();
			int result = bookDao.saveBook(book);
			if(result == 1){
				request.setAttribute("c", "添加图书成功");
			}
			else{
				request.setAttribute("c", "添加图书失败");
			}
			request.getRequestDispatcher("showAllBooksServlet").forward(request, response);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
