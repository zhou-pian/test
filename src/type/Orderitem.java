package type;

public class Orderitem {
	private int orderItemId;
	private int orderId;
	private int bookId;
	private int quantity;
	private double currPrice;
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getCurrPrice() {
		return currPrice;
	}
	public void setCurrPrice(double currPrice) {
		this.currPrice = currPrice;
	}

	public Orderitem(int orderItemId,int orderId,int bookId,int quantity,double currPrice)
	{
		this.orderItemId = bookId;
		this.orderId = orderId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.currPrice = currPrice;
		
	}
	
	public Orderitem(int orderId,int bookId,int quantity,float currPrice)
	{
		this.orderId = orderId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.currPrice = currPrice;
	}
	
}
