
package testDao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.BookDao;
import type.Book;

public class testBook {

	//关键字查找书籍
	@Test
	public void testFindBook() {
		String bookName="蓝";
		BookDao bookDao = new BookDao();
		List<Book> list = new ArrayList<Book>();
		list = bookDao.findBookName(bookName);
		
		assertEquals(13,list.get(2).getBookId());
	}
	
//	//编号查找书籍
//	@Test
//	public void testFindBookId() {
//		int bookId=2;
//		BookDao bookDao = new BookDao();
//		Book book = new Book();
//		book = bookDao.findBookId(bookId);
//		System.out.print(book.getAuthor());	
//		assertEquals("0",book.getAuthor());
//	}
	
	//类型编号查找书籍
	@Test
	public void testFpindTyeBook() {
		int categoryId = 2;
		BookDao bookDao = new BookDao();
		List<Book> list = new ArrayList<Book>();
		list = bookDao.findTypeBook(categoryId);
			
		assertEquals("x",list.get(0).getAuthor());
	}

}
