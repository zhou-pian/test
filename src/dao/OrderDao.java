package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import type.Book;
import type.Order;
import type.Orderitem;
import type.User;

public class OrderDao {
	//添加订单(order表有问题,改为orders不报错)
	public int addOrder(int userId, double total, String orderTime, String status){
		int i = 0;
		
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		PreparedStatement albumpreStmt = null;
		String sql = "insert into orders(userId, total, orderTime, status) values(?,?,?,?)";
		//String albumSql = "update album set PNum = ? where AId = ?";
		//insert into orders(userId, total, orderTime, status) values(2,6,"2019-8-16","已发货")
		try{		
				
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			//albumpreStmt = (PreparedStatement) connection.prepareStatement(albumSql);
			preStmt.setInt(1, userId);
			preStmt.setDouble(2, total);
			preStmt.setString(3, orderTime);
			preStmt.setString(4, status);	
			i = preStmt.executeUpdate();
			//j = albumpreStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}		
		return i;
	}
	
		//依据客户编号查找其所有订单
		public List<Order> FindOrders(int userId) {
				
			List<Order> list = new ArrayList<Order>();			
			ResultSet rs = null;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "select * from orders where userId = ?";
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);	
				preStmt.setInt(1, userId);
				rs = preStmt.executeQuery();
					
				while(rs.next()){						
					Order or = new Order();
					or.setOrderId(rs.getInt("orderId"));
					or.setOrderTime(rs.getString("orderTime"));
					or.setStatus(rs.getString("status"));
					or.setTotal(rs.getDouble("total"));
					or.setUserId(rs.getInt("userId"));	
					list.add(or);
				}
			} catch (SQLException e){
				e.printStackTrace();
			}finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return list;
		}
		
		//依据订单编号查找订单
		public Order FindOrder(int orderId) {
			
			Order or = new Order();	
			ResultSet rs = null;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "select * from orders where orderId = ?";
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);	
				preStmt.setInt(1, orderId);
				rs = preStmt.executeQuery();
					
				if(rs.next()){						
					
					or.setOrderId(rs.getInt("orderId"));
					or.setOrderTime(rs.getString("orderTime"));
					or.setStatus(rs.getString("status"));
					or.setTotal(rs.getDouble("total"));
					or.setUserId(rs.getInt("userId"));	
					
				}
			} catch (SQLException e){
				e.printStackTrace();
			}finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return or;
		}
		
		//订单时间查找订单
		public Order FindOrder(String orderTime) {
			
			Order or = new Order();	
			ResultSet rs = null;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "select * from orders where orderTime = ?";
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);	
				preStmt.setString(1, orderTime);
				rs = preStmt.executeQuery();
					
				if(rs.next()){						
					
					or.setOrderId(rs.getInt("orderId"));
					or.setOrderTime(rs.getString("orderTime"));
					or.setStatus(rs.getString("status"));
					or.setTotal(rs.getDouble("total"));
					or.setUserId(rs.getInt("userId"));	
					
				}
			} catch (SQLException e){
				e.printStackTrace();
			}finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return or;
		}
		
		
		
		//删除订单
		public int deleteOrder(int orderId) {
			
			int i = 0;
			
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			PreparedStatement albumpreStmt = null;
			String sql = "delete from orders where  orderId = ?";
			//String albumSql = "update album set PNum = ? where AId = ?";
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);	
				//albumpreStmt = (PreparedStatement) connection.prepareStatement(albumSql);
				preStmt.setInt(1, orderId);				
				i = preStmt.executeUpdate();
				//j = albumpreStmt.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return i;
		}
		
		//修改订单（确认收货更改状态）
		public int checkGoods(int orderId, String status){
			int i = 0;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "update orders set status=? where orderId ="+orderId;
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);				
				preStmt.setString(1, status);			
				i = preStmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return i;
		}
		
		public int modifyOrder(int orderId){
			int i = 0;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "update orders set status='已发货' where orderId ="+orderId;
			try{
				preStmt = (PreparedStatement)connection.prepareStatement(sql);
				i = preStmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return i;
		}
		
		
		//查找订单详情页，依据订单
		public Book FindOrderss(int orderId){   //没有购物车，一个订单就一本书
			
			Book or = new Book();			
			ResultSet rs = null;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "select cover, bookName,author, price, discount, status,total from orders , book, orderitem where orderitem.bookId = book.bookId and orders.orderId = orderitem.orderId and orders.orderId = ?";
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);	
				preStmt.setInt(1, orderId);
				rs = preStmt.executeQuery();
					
				if(rs.next()){						
					//Book or = new Book();
					or.setCover(rs.getString("cover"));
					or.setBookName(rs.getString("bookName")); 
					or.setAuthor(rs.getString("author"));
					or.setPrice(rs.getFloat("price"));
					or.setDiscount(rs.getFloat("discount"));
					or.setStatus(rs.getString("status"));
					or.setBuynum(rs.getInt("total"));
					or.setOrderId(orderId);
					//list.add(or);
				}
			} catch (SQLException e){
				e.printStackTrace();
			}finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return or;
		}
		
		public List<Order> queryAllOrders(){
			Order order;
			List<Order> arrayList = new ArrayList<Order>();
			Connection connection = DatabaseBean.getConnection();;
			PreparedStatement preStmt = null;
			String sql = "select * from orders, user where orders.userId = user.userId";
			try{
				preStmt = (PreparedStatement)connection.prepareStatement(sql);
				ResultSet rs = preStmt.executeQuery() ;  
	            
	            while(rs.next())  
	            {  
	            	order = new Order(rs.getInt("orderId"),rs.getInt("userId"),rs.getFloat("total"),rs.getString("status"));
	            	order.setUserName(rs.getString("userName"));
	            	order.setUserContact(rs.getString("userContact"));
	            	order.setUserAdd(rs.getString("userAdd"));
	                arrayList.add(order);  
	            }  
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return arrayList;
		}
		

}



