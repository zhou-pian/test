package testDao;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.BookDao;
import dao.UserDao;
import type.Book;
import type.User;

public class testUser {

	//编号查找书籍
		@Test
		public void testFindUser() {
			String userName = "zzz";
			UserDao userDao = new UserDao();
			
			User user = userDao.findUser(userName);
			//System.out.print(user.getUserPassword());	
			assertEquals(null,user);
		}
		
		
		//添加用户
		@Test
		public void testAddUser() {
			Float userSave = (float) 0;
			User user = new User("pigKing", "123456", "111111" ,userSave,"猪村","123456","upload/123456.jpg");
			UserDao userDao = new UserDao();		
			int i = userDao.addUser(user);

			assertEquals(1,i);
		}
		
		//修改用户
		@Test
		public void testModifyUser() {
			int userId = 1;
			Float userSave = (float) 0;
			User user = new User(userId,"pigKing", "123456", "111111" ,userSave,"猪村","123456","upload/people.jpg");
			UserDao userDao = new UserDao();		
			int i = userDao.modifyUser(user);

			assertEquals(1,i);
		}
		
		@Test
		public void testQUser() {
			int userId = 1;
			User user = new UserDao().queryUser(userId);
			String name = user.getUserName();
			System.out.print(name);	
			assertEquals("pigKing",user.getUserName());
		}

}
