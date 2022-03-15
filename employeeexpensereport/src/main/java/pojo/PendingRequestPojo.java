package pojo;



import java.util.Date;


public class PendingRequestPojo {
	private int reimbursementId;
	private int requestAmount;
	private boolean requestStatus;
	private Date dateOfRequest;
	private int requestingEmployeeId;
	public PendingRequestPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PendingRequestPojo(int reimbursementId, int requestAmount, boolean requestStatus, Date dateOfRequest,
			int requestingEmployeeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestAmount = requestAmount;
		this.requestStatus = requestStatus;
		this.dateOfRequest = dateOfRequest;
		this.requestingEmployeeId = requestingEmployeeId;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public int getRequestAmount() {
		return requestAmount;
	}
	public void setRequestAmount(int requestAmount) {
		this.requestAmount = requestAmount;
	}
	public boolean isRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}
	public Date getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public int getRequestingEmployeeId() {
		return requestingEmployeeId;
	}
	public void setRequestingEmployeeId(int requestingEmployeeId) {
		this.requestingEmployeeId = requestingEmployeeId;
	}
	@Override
	public String toString() {
		return "PendingRequestPojo [reimbursementId=" + reimbursementId + ", requestAmount=" + requestAmount
				+ ", requestStatus=" + requestStatus + ", dateOfRequest=" + dateOfRequest + ", requestingEmployeeId="
				+ requestingEmployeeId + "]";
	}

	
}