package testDao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.BookDao;
import dao.OrderDao;
import type.Book;
import type.Order;

public class testOrder {

		//添加订单
		@Test
		public void testAddOrder() {
			int userId = 1;
			double total = 5.0;
			String orderTime="2019_8_24_11_04";
			String status = "未发货";
			OrderDao orderDao = new OrderDao();
			//Order order = new Order();
			int i = orderDao.addOrder(userId, total, orderTime, status);
			
			assertEquals(1,i);
		}
		
		
		//客户编号查找订单
		@Test
		public void testFindOrders() {
			int userId = 1;
			OrderDao orderDao = new OrderDao();
			List<Order> list = new ArrayList<Order>();
			list = orderDao.FindOrders(userId);
			
			assertEquals(2,list.get(0).getOrderId());
			assertEquals(3,list.get(1).getOrderId());
		}
		
		//订单号查找订单
		@Test
		public void testIFindOrder() {
			int orderId = 1;
			OrderDao orderDao = new OrderDao();
			Order or = new Order();
			or = orderDao.FindOrder(orderId);
			
			assertEquals("2019-8-16",or.getOrderTime());
			
		}
		
		//订单时间查找订单
		@Test
		public void testTFindOrder() {
			String orderTime = "2019_8_24_23_11_50";
			OrderDao orderDao = new OrderDao();
			Order or = new Order();
			or = orderDao.FindOrder(orderTime);
			
			assertEquals(4,or.getOrderId());
			
		}
		
		//删除订单
		@Test
		public void testDeleteOrder() {
			int orderId = 2;
			OrderDao orderDao = new OrderDao();
			int i = orderDao.deleteOrder(orderId);
			
			
			assertEquals(1,i);
			
		}
		
		//查询订单详情
		@Test
		public void testFindOrderss() {
		
			int orderId = 1;
			OrderDao orderDao = new OrderDao();
			Book list = new Book();
			list = orderDao.FindOrderss(orderId);
			
			assertEquals("魔仙小蓝",list.getBookName());
			
		}

}
