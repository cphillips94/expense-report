package dao;

import java.util.List;

import exception.NoEmployeeFoundException;
import exception.SystemException;
import pojo.ManagerPojo;



public interface ManagerDao {
	
	List<ManagerPojo> listAllManagers() throws SystemException, NoEmployeeFoundException;
	
	ManagerPojo fetchAnEmployee(int managerId) throws SystemException;
	


	ManagerPojo createEmployee(ManagerPojo managerPojo) throws SystemException;

}
