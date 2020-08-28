package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

import dao.UserDao;
import type.User;


@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
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
			int userId = Integer.parseInt(request.getParameter("userId"));
			String userName = surequest.getParameter("userName");
			String userPassword = surequest.getParameter("userPassword");
			String userContact = surequest.getParameter("userContact");
			Float userSave = (float) 0;
			String userAdd = surequest.getParameter("userAdd");
			String payPassword = surequest.getParameter("payPassword");
			User user1 = new User(userId,userName,userPassword,userContact,userSave,userAdd,payPassword,filepath);
			
			
			int i = new UserDao().modifyUser(user1);
			
			
			String message = null;
			if(i == 1)
			{
				message = "修改成功";
				User user = new UserDao().findUser(userId);
				request.setAttribute("user", user);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/mine.jsp").forward(request, response);
				
			}
			else
			{
				message = "修改失败，请检查是否填写完整信息!";
				User user = new UserDao().findUser(userId);
				request.setAttribute("user", user);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/modifyUser.jsp").forward(request, response);
			}
		
		}catch (Exception e){
			System.out.println("这里报错");
			System.out.println(e.getMessage());
		}
	}

}
