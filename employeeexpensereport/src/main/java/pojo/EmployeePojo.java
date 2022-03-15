package pojo;

public class EmployeePojo {
	private int employeeId;
	private String employeeFirst;
	private String employeeLast;
	private String employeeContact;
	private String employeePassword;
	public EmployeePojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeePojo(int employeeId, String employeeFirst, String employeeLast, String employeeContact,
			String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeeFirst = employeeFirst;
		this.employeeLast = employeeLast;
		this.employeeContact = employeeContact;
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "UserPojo [employeeId=" + employeeId + ", employeeFirst=" + employeeFirst + ", employeeLast="
				+ employeeLast + ", employeeContact=" + employeeContact + ", employeePassword=" + employeePassword
				+ "]";
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeFirst() {
		return employeeFirst;
	}
	public void setEmployeeFirst(String employeeFirst) {
		this.employeeFirst = employeeFirst;
	}
	public String getEmployeeLast() {
		return employeeLast;
	}
	public void setEmployeeLast(String employeeLast) {
		this.employeeLast = employeeLast;
	}
	public String getEmployeeContact() {
		return employeeContact;
	}
	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
}
