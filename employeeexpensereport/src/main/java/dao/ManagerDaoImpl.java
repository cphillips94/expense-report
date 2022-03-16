package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.NoEmployeeFoundException;

import exception.SystemException;
import pojo.ManagerPojo;



public class ManagerDaoImpl implements ManagerDao{

	@Override
	public List<ManagerPojo> listAllManagers() throws SystemException, NoEmployeeFoundException {
		List<ManagerPojo> allManagers = new ArrayList<ManagerPojo>();
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from manager_details";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				ManagerPojo managerPojo = new ManagerPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				allManagers.add(managerPojo);
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		if(allManagers.isEmpty()) {
			throw new NoEmployeeFoundException();
		}
		
		return allManagers;
	}

	@Override
	public ManagerPojo fetchAManager(int managerId) throws SystemException {
		ManagerPojo managerPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from manager_details where manager_id="+managerId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				managerPojo = new ManagerPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		return managerPojo;
	}


	@Override
	public ManagerPojo createEmployee(ManagerPojo managerPojo) throws SystemException {
		 Connection conn = DBUtil.obtainConnection();
	        try {
	       Statement stmt = conn.createStatement();
		   String query2 = "INSERT INTO manager_details(manager_first_name, manager_last_name, manager_password) VALUES('"+managerPojo.getManagerFirst()+"','"+managerPojo.getManagerLast()+"','"+managerPojo.getManagerPassword()+"') RETURNING manager_id";
      ResultSet rs = stmt.executeQuery(query2);
      if(rs.next()) {
    	  managerPojo.setManagerId(rs.getInt(1));
      }

  } catch (SQLException e) {
      throw new SystemException();
  }

  return managerPojo;
	}

}
