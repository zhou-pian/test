package type;

import dao.UserDao;

public class Order {
	private int orderId;
	private int userId;
	private String userName;
	private String userContact;
	private String userAdd;
	private double total;
	private String orderTime;
	private String status;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getUserName()
	{
		User user = new UserDao().queryUser(userId);
		String name = user.getUserName();
		return name;
	}
	public String getUserContact()
	{
		User user = new UserDao().queryUser(userId);
		String contact = user.getUserContact();
		return contact;
	}
	public String getUserAdd()
	{
		User user = new UserDao().queryUser(userId);
		String address = user.getUserAdd();
		return address;
	}
	public Order(int orderId,int userId,float total,String status)
	{
		this.orderId = orderId;
		this.userId = userId;
		this.total = total;
		this.status = status;
	}
	public Order(int userId,float total,String status)
	{
		this.userId = userId;
		this.total = total;
		this.status = status;
	}
	
	public Order(){
	}
	
}
