package dao;

import java.util.List;

import exception.NoEmployeeFoundException;
import exception.SystemException;
import pojo.ManagerPojo;



public interface ManagerDao {
	
	List<ManagerPojo> listAllManagers() throws SystemException, NoEmployeeFoundException;
	
	
	


	ManagerPojo createManager(ManagerPojo managerPojo) throws SystemException;

	ManagerPojo fetchAManager(int managerId) throws SystemException;

}
