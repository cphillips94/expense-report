package service;

import java.util.List;

import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.PendingRequestPojo;
import pojo.ResolvedRequestPojo;
import pojo.EmployeePojo;
import pojo.ManagerPojo;

public interface ExpenseService {
	
	List<PendingRequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException;
	
	PendingRequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException;
	
	PendingRequestPojo updateRequest(PendingRequestPojo requestPojo) throws SystemException;
	
	PendingRequestPojo addRequest(PendingRequestPojo requestPojo) throws SystemException;
	
	PendingRequestPojo deleteRequest(int requestId) throws SystemException;
	
	List<ResolvedRequestPojo> fetchAllRequest() throws SystemException, RequestNotFoundException;
	
	ResolvedRequestPojo fetchAResolvedRequest(int resolvedRequestId) throws SystemException;
	
	ResolvedRequestPojo deleteResolvedRequest(int resolvedRequestId) throws SystemException;
	
	
	List<EmployeePojo> listAllEmloyees() throws SystemException, NoEmployeeFoundException;
	
	EmployeePojo fetchAnEmployee(int employeeId) throws SystemException;
	
	EmployeePojo updateEmployee(EmployeePojo employeePojo) throws SystemException;

	EmployeePojo createEmployee(EmployeePojo employeePojo) throws SystemException;
	
	List<ManagerPojo> listAllManagers() throws SystemException, NoEmployeeFoundException;
	
	ManagerPojo fetchAManager(int managerId) throws SystemException;
	
	ManagerPojo createManager(ManagerPojo managerPojo) throws SystemException;

}
