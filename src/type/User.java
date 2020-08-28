package type;

public class User {
	private int userId;
	private String userName;
	private String userPassword;
	private String userContact;
	private Float userSave;	//储蓄
	private String userAdd;
	private String payPassword;
	private String avatar;
	
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public Float getUserSave() {
		return userSave;
	}
	public void setUserSave(Float userSave) {
		this.userSave = userSave;
	}
	public String getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
		
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public User(String userName, String userPassword, String userContact, Float userSave,String userAdd, String payPassword,String avatar){
		this.userName = userName;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userSave = userSave;
		this.userAdd = userAdd;
		this.payPassword = payPassword;
		this.avatar = avatar;
	}
	
	public User(int userId,String userName, String userPassword, String userContact, Float userSave,String userAdd, String payPassword,String avatar){
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userSave = userSave;
		this.userAdd = userAdd;
		this.payPassword = payPassword;
		this.avatar = avatar;
	}
	
	public User(int userId,String userName,String userPassword,String userContact,float userSave,String userAdd,String payPassword)
	{
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userSave = userSave;
		this.userAdd = userAdd;
		this.payPassword = payPassword;
	}
	public User(String userName,String userPassword,String userContact,float userSave,String userAdd,String payPassword)
	{
		this.userName = userName;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userSave = userSave;
		this.userAdd = userAdd;
		this.payPassword = payPassword;
	}
	
}
