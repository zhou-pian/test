package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.jdbc.Connection;

public class DatabaseBean {
	
	public static Connection getConnection(){			
			Connection connection = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3308/bookstore?"
						+ "user=root&password=200079&"
						+ "useUnicode=true&characterEncoding=utf8";
				connection = (Connection) DriverManager.getConnection(url);
				
			}catch (ClassNotFoundException e){
				System.out.println("Driver not found");
			}catch (SQLException e){
				System.out.println("JDBC connection error");
			}
			return connection;
	}
		
	
	public static void closeDB(ResultSet rs, Statement st, Connection conn){
			if(rs!=null){
				try{
					rs.close();
					
				}catch (SQLException e){
					
				}
			}
			
			if(st!=null){
				try{
					st.close();
					
				}catch (SQLException e){
					
				}
			}
			
			if(conn!=null){
				try{
					conn.close();
					
				}catch (SQLException e){
					
				}
			}
	}

}
