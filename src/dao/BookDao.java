package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import type.Book;
import type.Orderitem;

public class BookDao {
	
	//添加书籍
	public int saveBook(Book book){
		int i = 0;
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		String sql = "insert into book(bookName,cover,author,press,pubDate,edition,numOfPage,inventory,soldNumber,price,discount,categoryId) value(?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			preStmt.setString(1, book.getBookName());
			preStmt.setString(2, book.getCover());
			preStmt.setString(3, book.getAuthor());
			preStmt.setString(4, book.getPress());
			preStmt.setString(5, book.getPubDate());
			preStmt.setInt(6, book.getEdition());
			preStmt.setInt(7, book.getNumOfPage());
			preStmt.setInt(8, book.getInventory());
			preStmt.setInt(9, book.getSoldNumber());
			preStmt.setFloat(10, book.getPrice());
			preStmt.setFloat(11, book.getDiscount());
			preStmt.setInt(12, book.getCategoryId());
			i = preStmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return i;
	}
	
	//删除书籍
	public int deleteBook(int bookId){
		int i = 0;
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		String sql = "delete from book where bookId=" + bookId;
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			i = preStmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return i;
	}
	
	public int modifyBook(int bookId,String bookName,String author,String press,String pubDate,int edition,int numOfPage,int inventory,float price,float discount,int categoryId){
		int i = 0;
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		String sql = "update book set bookName=?,author=?,press=?,pubDate=?,edition=?,numOfPage=?,inventory=?,price=?,discount=?,categoryId=? where bookId="+bookId;
		try{
			preStmt =(PreparedStatement) connection.prepareStatement(sql);
			preStmt.setString(1, bookName);
			preStmt.setString(2,author);
			preStmt.setString(3, press);
			preStmt.setString(4, pubDate);
			preStmt.setInt(5, edition);
			preStmt.setInt(6, numOfPage);
			preStmt.setInt(7, inventory);
			preStmt.setFloat(8, price);
			preStmt.setFloat(9, discount);
			preStmt.setInt(10, categoryId);
			i = preStmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return i;
	}
	
	//修改书籍
	public int modifyBook(Book book){
		int i = 0,bookId = book.getBookId();
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		String sql = "update book set bookName=?,author=?,press=?,pubDate=?,edition=?,numOfPage=?,inventory=?,price=?,discount=?,categoryId=? where bookId="+bookId;
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			preStmt.setString(1, book.getBookName());
			preStmt.setString(2,book.getAuthor());
			preStmt.setString(3, book.getPress());
			preStmt.setString(4, book.getPubDate());
			preStmt.setInt(5, book.getEdition());
			preStmt.setInt(6, book.getNumOfPage());
			preStmt.setInt(7, book.getInventory());
			preStmt.setFloat(8, book.getPrice());
			preStmt.setFloat(9, book.getDiscount());
			preStmt.setInt(10, book.getCategoryId());
			i = preStmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return i;
	}
	
	
	
	//依据书籍编号查找书
	public Book queryBook(int bookId){
		Connection connection = DatabaseBean.getConnection();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Book book = null;
		String sql = "select * from book where bookId=?";
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			preStmt.setInt(1,bookId);
			rs = preStmt.executeQuery();
			if(rs.next()){
				book = new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getString("cover"),rs.getString("author"),rs.getString("press"),
						rs.getString("pubDate"),rs.getInt("edition"),rs.getInt("numOfPage"),rs.getInt("inventory"),rs.getInt("soldNumber"),
						rs.getFloat("price"),rs.getFloat("discount"),rs.getInt("categoryId"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return book;
    }
	
	//所有书籍
	public List<Book> queryAllBooks(){
		Book book;
		List<Book> arrayList = new ArrayList<Book>();
		Connection connection = DatabaseBean.getConnection();;
		PreparedStatement preStmt = null;
		String sql = "select * from book";
		try{
			preStmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = preStmt.executeQuery() ;  
            
            while(rs.next())  
            {  
            	book = new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getString("cover"),rs.getString("author"),rs.getString("press"),
						rs.getString("pubDate"),rs.getInt("edition"),rs.getInt("numOfPage"),rs.getInt("inventory"),rs.getInt("soldNumber"),
						rs.getFloat("price"),rs.getFloat("discount"),rs.getInt("categoryId"));
                arrayList.add(book);  
            }  
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DatabaseBean.closeDB(null, preStmt, connection);
		}
		return arrayList;
	}


			//依据书名查询		
			public List<Book> findBookName(String bookName) {	
				
				List<Book> list = new ArrayList<Book>();
				
				ResultSet rs = null;
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				String sql = "select * from book where bookName like ? AND inventory > 0";
				//System.out.print("? ? ");
				
				try{
					preStmt = (PreparedStatement) connection.prepareStatement(sql);	
					preStmt.setString(1, "%" + bookName + "%");
					rs = preStmt.executeQuery();
					//System.out.print("w");
					while(rs.next()){	
						Book book = new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getString("cover"),rs.getString("author"),rs.getString("press"),
								rs.getString("pubDate"),rs.getInt("edition"),rs.getInt("numOfPage"),rs.getInt("inventory"),rs.getInt("soldNumber"),
								rs.getFloat("price"),rs.getFloat("discount"),rs.getInt("categoryId"));
						list.add(book);
					}
				} catch (SQLException e){
					e.printStackTrace();
				}finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				//System.out.print("z");
				return list;
		    }
			
			//依据作者关键字查询
			public List<Book> findBookAuthor(String author) {	
				
				List<Book> list = new ArrayList<Book>();
				Book book;
				ResultSet rs = null;
				Connection connection = DatabaseBean.getConnection();
				PreparedStatement preStmt = null;
				String sql = "select * from book where author like ? AND inventory > 0";
				
				try{
					preStmt = (PreparedStatement) connection.prepareStatement(sql);	
					preStmt.setString(1, "%" + author + "%");
					rs = preStmt.executeQuery();
					
					while(rs.next()){	
						
						book = new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getString("cover"),rs.getString("author"),rs.getString("press"),
								rs.getString("pubDate"),rs.getInt("edition"),rs.getInt("numOfPage"),rs.getInt("inventory"),rs.getInt("soldNumber"),
								rs.getFloat("price"),rs.getFloat("discount"),rs.getInt("categoryId"));		
						list.add(book);
					}
				} catch (SQLException e){
					e.printStackTrace();
				}finally{
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				
				return list;
		    }
		
				
		//依据图书编号查询
		public Book findBookId(int bookId) {					
			Book bk = null;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "select * from book where bookId = ?";
			ResultSet rs = null;
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);
				preStmt.setInt(1, bookId);
					
				rs = preStmt.executeQuery();
				//查询结果
				if(rs.next()){
					bk = new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getString("cover"),rs.getString("author"),rs.getString("press"),
							rs.getString("pubDate"),rs.getInt("edition"),rs.getInt("numOfPage"),rs.getInt("inventory"),rs.getInt("soldNumber"),
							rs.getFloat("price"),rs.getFloat("discount"),rs.getInt("categoryId"));
				}
				else{
					bk = null;
				}				} catch (SQLException e){
					e.printStackTrace();
				}finally{
					
					DatabaseBean.closeDB(null, preStmt, connection);
				}
				return bk;
			}
			
			//依据类别查询书籍
		public List<Book> findTypeBook(int categoryId) {
				
			List<Book> list = new ArrayList<Book>();
			Book bk;	
			ResultSet rs = null;
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "select * from book where categoryId = ? AND inventory > 0";
			try{
				preStmt = (PreparedStatement) connection.prepareStatement(sql);	
				preStmt.setInt(1, categoryId);
				rs = preStmt.executeQuery();
					
				while(rs.next()){						
					bk = new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getString("cover"),rs.getString("author"),rs.getString("press"),
							rs.getString("pubDate"),rs.getInt("edition"),rs.getInt("numOfPage"),rs.getInt("inventory"),rs.getInt("soldNumber"),
							rs.getFloat("price"),rs.getFloat("discount"),rs.getInt("categoryId"));	
					list.add(bk);
				}
			} catch (SQLException e){
				e.printStackTrace();
			}finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return list;
	    }
		//发货修改图书数量
		public int modifyBook1(int orderId){
			int i = 0;
			Orderitem orderitem = new OrderitemDao().FindOrderitem(orderId);
			int quantity = orderitem.getQuantity();
			int bookId = orderitem.getBookId();
			Connection connection = DatabaseBean.getConnection();
			PreparedStatement preStmt = null;
			String sql = "update book set inventory = inventory - ?,soldNumber = soldNumber + ? where bookId ="+bookId;
			try{
				preStmt = (PreparedStatement)connection.prepareStatement(sql);
				preStmt.setInt(1, quantity);
				preStmt.setInt(2, quantity);
				i = preStmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
			} finally{
				DatabaseBean.closeDB(null, preStmt, connection);
			}
			return i;
		}
		
			
}
