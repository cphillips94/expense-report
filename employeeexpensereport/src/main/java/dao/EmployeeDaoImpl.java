package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.NoEmployeeFoundException;
import exception.SystemException;

import pojo.EmployeePojo;

public class EmployeeDaoImpl implements EmployeeDao{



	@Override
	public List<EmployeePojo> listAllEmployees() throws SystemException, NoEmployeeFoundException {
		List<EmployeePojo> allEmployees = new ArrayList<EmployeePojo>();
		Connection conn = DBUtil.obtainConnection();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM employee_details;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				EmployeePojo employeePojo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				allEmployees.add(employeePojo);
			}
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		if(allEmployees.isEmpty()) {
			throw new NoEmployeeFoundException();
		}
		return allEmployees;
	}



	@Override
	public EmployeePojo fetchAnEmployee(int employeeId) throws SystemException {
		EmployeePojo employeePojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from employee_details where user_id="+employeeId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				employeePojo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		return employeePojo;
	}



	@Override
	public EmployeePojo updateEmployee(EmployeePojo employeePojo) throws SystemException {
Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "update employee_details set first_name="+employeePojo.getEmployeeFirst()+", last_name="+employeePojo.getEmployeeLast()+", password="+employeePojo.getEmployeePassword()+" where user_id="+employeePojo.getEmployeeId();
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		
		return employeePojo;
	}



	@Override
	public EmployeePojo createEmployee(EmployeePojo employeePojo) throws SystemException {
		
		  Connection conn = DBUtil.obtainConnection();
	        try {
	       Statement stmt = conn.createStatement();
		   String query2 = "INSERT INTO employee_details(employee_first_name, employee_last_name, employee_contact, employee_password) VALUES('"+employeePojo.getEmployeeFirst()+"','"+employeePojo.getEmployeeLast()+"','"+employeePojo.getEmployeeContact()+"',"+employeePojo.getEmployeePassword()+"') RETURNING employee_id";
           ResultSet rs = stmt.executeQuery(query2);
           if(rs.next()) {
               employeePojo.setEmployeeId(rs.getInt(1));
           }

       } catch (SQLException e) {
           throw new SystemException();
       }
     
       return employeePojo;
}
}

