package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.RequestNotFoundException;
import exception.SystemException;

import pojo.PendingRequestPojo;
import pojo.EmployeePojo;

public class RequestDaoImpl implements RequestDao{

	public List<PendingRequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException {
		List<PendingRequestPojo> allRequests = new ArrayList<PendingRequestPojo>();
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from pending_reimbursement";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				PendingRequestPojo pendingRequestPojo = new PendingRequestPojo(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getDate(4), rs.getInt(5));
				allRequests.add(pendingRequestPojo);
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		if(allRequests.isEmpty()) {
			throw new RequestNotFoundException();
		}
		
		return allRequests;
	}

	public PendingRequestPojo fetchARequest(int reimbursementId) throws RequestNotFoundException, SystemException {
		
		PendingRequestPojo pendingRequestPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from request_details where reimbursement_id="+reimbursementId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				pendingRequestPojo = new PendingRequestPojo(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getDate(5), rs.getInt(6));
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		return pendingRequestPojo;
	}

	public PendingRequestPojo updateRequest(PendingRequestPojo pendingRequestPojo) throws SystemException {
		
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "update pending_reimbursement set request_status="+pendingRequestPojo.isRequestStatus()+" where reimbursement_id="+pendingRequestPojo.getReimbursementId();
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		
		return pendingRequestPojo;
	}

	public PendingRequestPojo addRequest(PendingRequestPojo pendingRequestPojo) throws SystemException {
		
		  Connection conn = DBUtil.obtainConnection();
	        try {
	       Statement stmt = conn.createStatement();
		   String query2 = "INSERT INTO pending_reimbursement(request_amount) VALUES('"+pendingRequestPojo.getRequestAmount()+"') RETURNING reimbursement_id";
         ResultSet rs = stmt.executeQuery(query2);
         if(rs.next()) {
        	 pendingRequestPojo.setReimbursementId(rs.getInt(1));
         }

     } catch (SQLException e) {
         throw new SystemException();
     }
   
     return pendingRequestPojo;
	}

	public PendingRequestPojo deleteRequest(int pendingRequestId) throws SystemException {
		
		PendingRequestPojo pendingRequestPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			try {
				pendingRequestPojo = fetchARequest(pendingRequestId);
				Statement stmt = conn.createStatement();
				String query = "delete from pending_reimbursement where reimbursement_id="+pendingRequestId+";";
				int rows = stmt.executeUpdate(query);
			} catch (RequestNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			
			throw new SystemException();
			
			
		}
		
		return pendingRequestPojo;
	}

}
