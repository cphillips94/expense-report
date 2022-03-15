package dao;

import java.util.List;

import exception.NoEmployeeFoundException;
import exception.SystemException;
import pojo.EmployeePojo;

public interface EmployeeDao {
	
	List<EmployeePojo> listAllEmployees() throws SystemException, NoEmployeeFoundException;
	
	EmployeePojo fetchAnEmployee(int employeeId) throws SystemException;
	
	EmployeePojo updateEmployee(EmployeePojo employeePojo) throws SystemException;

	EmployeePojo createEmployee(EmployeePojo employeePojo) throws SystemException;
	
	//default void exitApplication();
		
}

