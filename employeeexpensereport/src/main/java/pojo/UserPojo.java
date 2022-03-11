package pojo;

public class UserPojo {
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String role;
	public UserPojo(int userId, String firstName, String lastName, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", role=" + role + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}



}
