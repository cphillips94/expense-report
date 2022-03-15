package pojo;

public class ManagerPojo {
	private int managerId;
	private String managerFirst;
	private String managerLast;
	private String managerPassword;
	public ManagerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerPojo(int managerId, String managerFirst, String managerLast, String managerPassword) {
		super();
		this.managerId = managerId;
		this.managerFirst = managerFirst;
		this.managerLast = managerLast;
		this.managerPassword = managerPassword;
	}
	@Override
	public String toString() {
		return "ManagerPojo [managerId=" + managerId + ", managerFirst=" + managerFirst + ", managerLast=" + managerLast
				+ ", managerPassword=" + managerPassword + "]";
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerFirst() {
		return managerFirst;
	}
	public void setManagerFirst(String managerFirst) {
		this.managerFirst = managerFirst;
	}
	public String getManagerLast() {
		return managerLast;
	}
	public void setManagerLast(String managerLast) {
		this.managerLast = managerLast;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	
}
