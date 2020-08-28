package type;

import dao.CategoryDao;

public class Book {
	private int bookId;
	private String bookName;
	private String cover;//封面图片地址
	private String author;//作者名
	private String press;//出版社名称
	private String pubDate;//出版时间
	private int edition;//版次
	private int numOfPage;//页数
	private int inventory;//库存余量
	private int soldNumber;//已售数量
	private float price;//图书原价
	private float discount;//折扣
	private int categoryId;//分类编号
	
	private int orderId;
	private String status;
	private int buynum;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	public int getBookId()
	{
		return bookId;
	}
	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public String getCover()
	{
		return cover;
	}
	public void setCover(String cover)
	{
		this.cover = cover;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getPress()
	{
		return press;
	}
	public void setPress(String press)
	{
		this.press = press;
	}
	public String getPubDate()
	{
		return pubDate;
	}
	public void setPubDate(String pubDate)
	{
		this.pubDate = pubDate;
	}
	public int getEdition()
	{
		return edition;
	}
	public void setEdition(int edition)
	{
		this.edition = edition;
	}
	public int getNumOfPage()
	{
		return numOfPage;
	}
	public void setNumOfPage(int numOfPage)
	{
		this.numOfPage = numOfPage;
	}
	public int getInventory()
	{
		return inventory;
	}
	public void setInventory(int inventory)
	{
		this.inventory = inventory;
	}
	public int getSoldNumber()
	{
		return soldNumber;
	}
	public void setSoldNumber(int soldNumber)
	{
		this.soldNumber = soldNumber;
	}
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price)
	{
		this.price = price;
	}
	public float getDiscount()
	{
		return discount;
	}
	public void setDiscount(float discount)
	{
		this.discount = discount;
	}
	public int getCategoryId()
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	
	public String getCategoryName()
	{
		Category category = new CategoryDao().queryCategory(categoryId);
		String name = category.getCategoryName();
		return name;
	}
	
	public Book(String bookName,String cover,String author,String press,String pubDate,int edition,int numOfPage,int inventory,int soldNumber,float price,float discount,int categoryId)
	{
		this.bookName = bookName;
		this.cover = cover;
		this.author = author;
		this.press = press;
		this.pubDate = pubDate;
		this.edition = edition;
		this.numOfPage = numOfPage;
		this.inventory = inventory;
		this.soldNumber = soldNumber;
		this.price = price;
		this.discount = discount;
		this.categoryId = categoryId;
	}
	public Book(int bookId,String bookName,String cover,String author,String press,String pubDate,int edition,int numOfPage,int inventory,int soldNumber,float price,float discount,int categoryId)
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.cover = cover;
		this.author = author;
		this.press = press;
		this.pubDate = pubDate;
		this.edition = edition;
		this.numOfPage = numOfPage;
		this.inventory = inventory;
		this.soldNumber = soldNumber;
		this.price = price;
		this.discount = discount;
		this.categoryId = categoryId;
	}
	public Book()
	{}
}






