package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import type.Book;
import type.Category;

public class CategoryDao {
	
	public List<Category> queryAllCategories(){
		Category category;
		List<Category> arrayList = new ArrayList<Category>();
		Connection connection = DatabaseBean.getConnection();;
		PreparedStatement preStmt = null;
		String sql = "select * from category";
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = preStmt.executeQuery() ;  
            
            while(rs.next())  
            {  
            	category = new Category(rs.getInt("categoryId"),rs.getString("categoryName"));
                arrayList.add(category);  
            }  
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return arrayList;
	}


			//依据类别查询类别编号
			public int findCategoryId(String categoryName) {					
				int id = 0;
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				String sql = "select * from category where categoryName =  ?";
				ResultSet rs = null;
				try{
					preStmt = (PreparedStatement) connection.prepareStatement(sql);
					preStmt.setString(1, categoryName);
						
					rs = preStmt.executeQuery();
					//查询结果
					if(rs.next()){
						id = rs.getInt("categoryId");
						//System.out.print(id);
					}
				} catch (SQLException e){
						e.printStackTrace();
				}finally{
						
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return id;
			}
			
			public Category queryCategory(int categoryId)
			{
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				ResultSet rs = null;
				Category category = null;
				String sql = "select * from category where categoryId=?";
				try{
					preStmt =(PreparedStatement) connection.prepareStatement(sql);
					preStmt.setInt(1,categoryId);
					rs = preStmt.executeQuery();
					if(rs.next()){
						category = new Category(rs.getInt(1),rs.getString(2));
					}
				} catch(SQLException e){
					e.printStackTrace();
				} finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return category;	
			}
}
