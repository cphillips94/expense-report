package pojo;

import java.util.Date;

public class ResolvedRequestPojo {
	
	private int resolvedRequestId;
	private int requestId;
	private boolean requestStatus;
	private Date resolvedDate;
	public ResolvedRequestPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResolvedRequestPojo(int resolvedRequestId, int requestId, boolean requestStatus, Date resolvedDate) {
		super();
		this.resolvedRequestId = resolvedRequestId;
		this.requestId = requestId;
		this.requestStatus = requestStatus;
		this.resolvedDate = resolvedDate;
	}
	@Override
	public String toString() {
		return "ResolvedRequestPojo [resolvedRequestId=" + resolvedRequestId + ", requestId=" + requestId
				+ ", requestStatus=" + requestStatus + ", resolvedDate=" + resolvedDate + "]";
	}
	public int getResolvedRequestId() {
		return resolvedRequestId;
	}
	public void setResolvedRequestId(int resolvedRequestId) {
		this.resolvedRequestId = resolvedRequestId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public boolean isRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}
	public Date getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	

}
