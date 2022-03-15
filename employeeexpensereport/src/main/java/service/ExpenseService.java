package service;

import java.util.List;

import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.PendingRequestPojo;
import pojo.EmployeePojo;

public interface ExpenseService {
	
List<PendingRequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException;
	
	PendingRequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException;
	
	PendingRequestPojo updateRequest(PendingRequestPojo requestPojo) throws SystemException;
	
	PendingRequestPojo addRequest(PendingRequestPojo requestPojo) throws SystemException;
	
	PendingRequestPojo deleteRequest(int requestId) throws SystemException;
	
	List<EmployeePojo> listAllUser() throws SystemException, NoEmployeeFoundException;
	
	EmployeePojo fetchAUser(int userId) throws SystemException;
	
	EmployeePojo updateUser(EmployeePojo userPojo) throws SystemException;
	
	

}
