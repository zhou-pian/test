package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

import dao.CategoryDao;
import dao.UserDao;
import type.Category;
import type.User;


@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		
		//时间
				Date date = new Date(); 
				int year = date.getYear()+1900;       
				//获取当前年份(2位)		                                    
				int month = date.getMonth()+1;      
				//获取当前月份(0-11,0代表1月)	                                    
				int date1 = date.getDate();       
				//获取当前日(1-31)	                                    
				int hour = date.getHours();      
				//获取当前小时数(0-23)		                                    
				int minutes = date.getMinutes();    
				//获取当前分钟数(0-59)	                                    
				int seconds = date.getSeconds();    
				//获取当前秒数(0-59)     	                                    
				String hehe = year+"_"+month+"_"+date1+"_"+hour+"_"+minutes+"_"+seconds;//给上传的文件命名		
				String filepath = null;
				String filename = hehe;
				SmartUpload smu = new SmartUpload();
				//初始化SmartUpload对象
				smu.initialize(getServletConfig(), request, response);
				try{
					smu.upload();   //执行上传
					com.jspsmart.upload.File file = null;
					file = smu.getFiles().getFile(0);
					
					if(!file.isMissing()){
						filepath = "upload\\"; //将上传的文件放入Web文件夹
						filename += file.getFileName();
						filepath += filename;
						file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);
					}
					com.jspsmart.upload.Request surequest = smu.getRequest();
					
					String userName = surequest.getParameter("userName");
					String userPassword = surequest.getParameter("userPassword");
					String userContact = surequest.getParameter("userContact");
					Float userSave = (float) 0;
					String userAdd = surequest.getParameter("userAdd");
					String payPassword = surequest.getParameter("payPassword");
					String message = null;
					User common = new UserDao().findUser(userName);
					if(!userName.equals("")&&!userPassword.equals("")&&!userContact.equals("")&&!payPassword.equals("")&&!userAdd.equals("")&&!filepath.equals(""))
					{//检查漏填
						
						if(common == null)//检查重名
						{
							User user = new User(userName,userPassword,userContact,userSave,userAdd,payPassword,filepath);
							int i = new UserDao().addUser(user);
							if(i == 1)
							{
								message = "注册成功，可立即登录~";
								request.setAttribute("message", message);
								request.getRequestDispatcher("/login.jsp").forward(request, response);
							}
							else
							{
								message = "注册失败，可能是数据太长导致的BUG";
								request.setAttribute("message", message);
								request.getRequestDispatcher("/register.jsp").forward(request, response);
							}
							
							
						}
						else
						{
							
							message = "此名称已被占用，另起一个吧~";
							request.setAttribute("message", message);
							request.getRequestDispatcher("/register.jsp").forward(request, response);
							
						}
					}
					else
					{
						message = "注册失败，请检查信息是否填写完整!";
						request.setAttribute("message", message);
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}
					
					
					
					
				}catch (Exception e){
					System.out.println("这里报错");
					System.out.println(e.getMessage());
				}
		
	}

}
