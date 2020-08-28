package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import type.Book;
import type.User;



public class UserDao {
	
	//添加用户
	public int addUser(User user){
		int i = 0;
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		String sql = "insert into user(userName,userPassword,userContact,userSave,userAdd,payPassword,avatar) value(?,?,?,?,?,?,?)";
		
		
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			preStmt.setString(1, user.getUserName());
			preStmt.setString(2, user.getUserPassword());
			preStmt.setString(3, user.getUserContact());
			preStmt.setFloat(4, user.getUserSave());;
			preStmt.setString(5, user.getUserAdd());
			preStmt.setString(6, user.getPayPassword());
			preStmt.setString(7, user.getAvatar());		
			i = preStmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return i;
	}
	
	
	
	//修改用户信息
	public int modifyUser(User user){
		int i = 0;
		int userId = user.getUserId();
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		String sql = "update user set userName=?,userPassword=?,userContact=?,userAdd=?,payPassword=?,avatar=? where userId =?";
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			preStmt.setString(1, user.getUserName());
			preStmt.setString(2, user.getUserPassword());
			preStmt.setString(3, user.getUserContact());
			preStmt.setString(4, user.getUserAdd());
			preStmt.setString(5, user.getPayPassword());
			preStmt.setString(6, user.getAvatar());
			preStmt.setInt(7, user.getUserId());
			i = preStmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return i;
	}
	
	//更新账户余额
		public int addMoney(User user, double addmoney){
			int i = 0;
			int userId = user.getUserId();
			double userSave = user.getUserSave() + addmoney;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "update user set userSave=?where userId ="+userId;
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);				
				preStmt.setDouble(1, userSave);			
				i = preStmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return i;
		}
	
	//依据用户名查询
	public User findUser(String userName) {					
		User user = null;
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		String sql = "select * from user where userName = ?";
		ResultSet rs = null;
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			preStmt.setString(1, userName);
				
			rs = preStmt.executeQuery();
			//查询结果
			if(rs.next())
			{
				user = new User(rs.getInt("userId"),rs.getString("userName"),rs.getString("userPassword"),rs.getString("userContact"),rs.getFloat("userSave"),rs.getString("userAdd"),
						rs.getString("payPassword"),
						rs.getString("avatar"));
				
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
				
				DatabaseBean.closeDB(null, preStmt, connection);
		}
		return user;
	}
	
	//依据用户ID查询
		public User findUser(int userId) {					
			User user = null;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "select * from user where userId = ?";
			ResultSet rs = null;
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);
				preStmt.setInt(1, userId);
					
				rs = preStmt.executeQuery();
				//查询结果
				if(rs.next())
				{
					user = new User(rs.getInt("userId"),rs.getString("userName"),rs.getString("userPassword"),rs.getString("userContact"),rs.getFloat("userSave"),rs.getString("userAdd"),
							rs.getString("payPassword"),
							rs.getString("avatar"));
					
					
				}
			}catch (SQLException e){
				e.printStackTrace();
			}finally{
					
					DatabaseBean.closeDB(null, preStmt, connection);
			}
				return user;
		}
		
		//查询用户（管理）
		public User queryUser(int userId){
			User user = null;
			Connection connection = DatabaseBean.getConnection();;
			PreparedStatement preStmt = null;
			String sql = "select * from user where userId = ?";
			try{
				preStmt = (PreparedStatement)connection.prepareStatement(sql);
				preStmt.setInt(1,userId);
				ResultSet rs = preStmt.executeQuery() ;  
	            
	            if(rs.next())  
	            {  
	            	user = new User(rs.getInt("userId"),rs.getString("userName"),rs.getString("userPassword"),rs.getString("userContact"),rs.getFloat("userSave"),rs.getString("userAdd"),rs.getString("payPassword"));
	            }  
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return user;
		}
	
	

}
