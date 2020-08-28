package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import type.Order;
import type.Orderitem;

public class OrderitemDao {
		//添加 订单细则表
		public int addOrderitem(int orderId,int bookId, int quantity, double currPrice){
			int i = 0;
			
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			//PreparedStatement albumpreStmt = null;
			String sql = "insert into orderitem(orderId,bookId,quantity,currPrice) values(?,?,?,?)";
			try{		
					
				preStmt = (PreparedStatement) connection.prepareStatement(sql);			
				preStmt.setInt(1, orderId);
				preStmt.setInt(2, bookId);
				preStmt.setInt(3, quantity);
				preStmt.setDouble(4, currPrice);	
				i = preStmt.executeUpdate();				
			} catch (SQLException e){
				e.printStackTrace();
			}finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}		
			return i;
		}
		
			//依据客户编号查找其所有订单
			public List<Orderitem> FindOrderitems(int orderId) {
					
				List<Orderitem> list = new ArrayList<Orderitem>();			
				ResultSet rs = null;
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				String sql = "select * from orderitem where orderId = ?";
				try{
					preStmt = (PreparedStatement) connection.prepareStatement(sql);	
					preStmt.setInt(1, orderId);
					rs = preStmt.executeQuery();
						
					while(rs.next()){						
						Orderitem or = new Orderitem(rs.getInt("orderItemId"),rs.getInt("orderId"),rs.getInt("bookId"),rs.getInt("quantity"),rs.getDouble("currPrice"));
						list.add(or);
						
						
					}
				} catch (SQLException e){
					e.printStackTrace();
				}finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return list;
			}
			
			//依据订单号查找订单细则编号
			public Orderitem FindOrderitem(int orderId) {
				
				Orderitem orderitem = null;			
				ResultSet rs = null;
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				String sql = "select * from orderitem where orderId = ?";
				try{
					preStmt = (PreparedStatement) connection.prepareStatement(sql);	
					preStmt.setInt(1, orderId);
					rs = preStmt.executeQuery();
						
					if(rs.next()){						
						orderitem = new Orderitem(rs.getInt("orderItemId"),rs.getInt("orderId"),rs.getInt("bookId"),rs.getInt("quantity"),rs.getDouble("currPrice"));
					
					}
				} catch (SQLException e){
					e.printStackTrace();
				}finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return orderitem;
			}
			
			//建立虚拟表，显示订单（链接book和order）
			public Orderitem Detail(int orderId, int bookId) {
				
				Orderitem orderitem = null;			
				ResultSet rs = null;
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				String sql = "select * from orderitem where orderId = ?";
				try{
					preStmt = (PreparedStatement) connection.prepareStatement(sql);	
					preStmt.setInt(1, orderId);
					rs = preStmt.executeQuery();
						
					if(rs.next()){						
						orderitem = new Orderitem(rs.getInt("orderItemId"),rs.getInt("orderId"),rs.getInt("bookId"),rs.getInt("quantity"),rs.getDouble("currPrice"));
					
					}
				} catch (SQLException e){
					e.printStackTrace();
				}finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return orderitem;
			}
			
			public Orderitem queryOrderitem(int orderItemId){
				Orderitem orderitem = null;
				Connection connection = DatabaseBean.getConnection();;
				PreparedStatement preStmt = null;
				String sql = "select * from orderitem where orderItemId = ?";
				try{
					preStmt = (PreparedStatement)connection.prepareStatement(sql);
					preStmt.setInt(1,orderItemId);
					ResultSet rs = preStmt.executeQuery();  
		            
		            if(rs.next())  
		            {  
		            	orderitem = new Orderitem(rs.getInt("orderItemId"),rs.getInt("orderId"),rs.getInt("bookId"),rs.getInt("quantity"),rs.getFloat("currPrice"));
		            }  
				} catch(SQLException e){
					e.printStackTrace();
				} finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return orderitem;
			}
			//根据id查找对应细则
			public List<Orderitem> queryOrderitem1(int orderId){
				Orderitem orderitem = null;
				List<Orderitem> arrayList = new ArrayList<Orderitem>();
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				String sql = "select * from orderitem where orderId = ?";
				try{
					preStmt = (PreparedStatement)connection.prepareStatement(sql);
					preStmt.setInt(1,orderId);
					ResultSet rs = preStmt.executeQuery() ;  
		            
		            while(rs.next())  
		            {  
		            	orderitem = new Orderitem(rs.getInt("orderItemId"),rs.getInt("orderId"),rs.getInt("bookId"),rs.getInt("quantity"),rs.getFloat("currPrice"));
		            	arrayList.add(orderitem);
		            }  
				} catch(SQLException e){
					e.printStackTrace();
				} finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return arrayList;
			}

			
		}
