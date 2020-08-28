package testDao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.BookDao;
import dao.CategoryDao;
import type.Book;

public class testCategory {

	//类型名称查找类型编号
		@Test
		public void testFindBook() {
			String categoryName = "法学";
			int categoryId = 0;
			BookDao bookDao = new BookDao();
			List<Book> list = new ArrayList<Book>();
			CategoryDao categoryDao = new CategoryDao();
			categoryId = categoryDao.findCategoryId(categoryName);
			list = bookDao.findTypeBook(categoryId);
			
			//System.out.println("+++" + list.get(0).getBookId() + "****");	
			assertEquals(1,list.get(0).getBookId());
		}

}
