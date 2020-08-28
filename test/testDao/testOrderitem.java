package testDao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.OrderDao;
import dao.OrderitemDao;
import type.Order;
import type.Orderitem;

public class testOrderitem {

	//添加订单细则
			@Test
			public void testAddOrderitem() {
				int orderId = 1;
				int bookId = 1;
				int quantity = 10;
				double currPrice = 8.5;
				OrderitemDao orderitemDao = new OrderitemDao();
				//Order order = new Order();
				int i = orderitemDao.addOrderitem(orderId, bookId, quantity, currPrice);
				
				assertEquals(1,i);
			}
			
			
			//订单编号查找订单细则号
			@Test
			public void testFindOrderitem() {
				int orderId = 1;
				OrderitemDao orderitemDao = new OrderitemDao();
				List<Orderitem> list = new ArrayList<Orderitem>();
				//list = orderitemDao.FindOrderitem(orderId);
				
				assertEquals("8.5",list.get(0).getCurrPrice());
			}

}
