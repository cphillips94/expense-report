package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.ResolvedRequestPojo;

public class ResolvedRequestDaoImpl implements ResolvedRequestDao{

	@Override
		public List<ResolvedRequestPojo> fetchAllRequest() throws SystemException, RequestNotFoundException {
			List<ResolvedRequestPojo> allRequests = new ArrayList<ResolvedRequestPojo>();
			Connection conn = DBUtil.obtainConnection();
			
			try {
				Statement stmt = conn.createStatement();
				String query = "select * from resolved_reimbursement";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					ResolvedRequestPojo resolvedRequestPojo = new ResolvedRequestPojo(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getDate(4));
					allRequests.add(resolvedRequestPojo);
				}
				
			} catch (SQLException e) {
				
				throw new SystemException();
			}
			if(allRequests.isEmpty()) {
				throw new RequestNotFoundException();
			}
			
			return allRequests;
	}

	@Override
	public ResolvedRequestPojo fetchAResolvedRequest(int resolvedRequestId) throws SystemException {
		ResolvedRequestPojo resolvedRequestPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from resolved_reimbursement where reimbursement_id="+resolvedRequestId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				resolvedRequestPojo = new ResolvedRequestPojo(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getDate(4));
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		return resolvedRequestPojo;
	}

	
//ask for sql query for addd request 
	
	//@Override
//	public ResolvedRequestPojo addResolvedRequest(ResolvedRequestPojo resolvedRequestPojo) {
//		 Connection conn = DBUtil.obtainConnection();
	//        try {
	//       Statement stmt = conn.createStatement();
	//	   String query2 = "INSERT INTO resolved_reimbursement(resolved_request_id) VALUES('"+pendingRequestPojo.getRequestAmount()+"') RETURNING reimbursement_id";
    //  ResultSet rs = stmt.executeQuery(query2);
   //   if(rs.next()) {
   // 	  resolvedRequestPojo.getResolvedRequestId(rs.getInt(1));
   //   }

 // } catch (SQLException e) {
  //    throw new SystemException();
 // }

 // return pendingRequestPojo;
//	}

	@Override
	public ResolvedRequestPojo deleteResolvedRequest(int resolvedRequestId) throws SystemException {
		ResolvedRequestPojo resolvedRequestPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			try {
				resolvedRequestPojo = fetchAResolvedRequest(resolvedRequestId);
				Statement stmt = conn.createStatement();
				String query = "delete from resolved_reimbursement where resolved_reimbursement_id="+resolvedRequestId+";";
				int rows = stmt.executeUpdate(query);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			
			throw new SystemException();
			
			
		}
		
		return resolvedRequestPojo;
	}

}
