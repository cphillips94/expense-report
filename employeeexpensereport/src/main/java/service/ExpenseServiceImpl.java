package service;

import java.util.List;


import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.ResolvedRequestDao;
import dao.ResolvedRequestDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.ManagerDao;
import dao.ManagerDaoImpl;
import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.PendingRequestPojo;
import pojo.ResolvedRequestPojo;
import pojo.EmployeePojo;
import pojo.ManagerPojo;

public class ExpenseServiceImpl implements ExpenseService{
	RequestDao pendingRequestDao;
	EmployeeDao employeeDao;
	ManagerDao managerDao;
	ResolvedRequestDao resolvedRequestDao;
	
	public ExpenseServiceImpl() {
		//bookDao = new BookDaoImpl();
		employeeDao = new EmployeeDaoImpl();
		pendingRequestDao = new RequestDaoImpl();
		resolvedRequestDao =new ResolvedRequestDaoImpl();
		managerDao =new ManagerDaoImpl();
		
	}
	public List<PendingRequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException {
		// TODO Auto-generated method stub
		return pendingRequestDao.fetchAllRequests();
	}

	public PendingRequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException {
		// TODO Auto-generated method stub
		return pendingRequestDao.fetchARequest(requestId);
	}

	public PendingRequestPojo updateRequest(PendingRequestPojo requestPojo) throws SystemException {
		// TODO Auto-generated method stub
		return pendingRequestDao.updateRequest(requestPojo);
	}

	public PendingRequestPojo addRequest(PendingRequestPojo requestPojo) throws SystemException {
		// TODO Auto-generated method stub
		return pendingRequestDao.addRequest(requestPojo);
	}

	public PendingRequestPojo deleteRequest(int requestId) throws SystemException {
		// TODO Auto-generated method stub
		return pendingRequestDao.deleteRequest(requestId);
	}
	
	public List<ResolvedRequestPojo> fetchAllRequest() throws SystemException, RequestNotFoundException {
		// TODO Auto-generated method stub
		return resolvedRequestDao.fetchAllRequest();
	}
	public ResolvedRequestPojo fetchAResolvedRequest(int resolvedRequestId) throws SystemException {
		// TODO Auto-generated method stub
		return resolvedRequestDao.fetchAResolvedRequest(resolvedRequestId);
	}
	public ResolvedRequestPojo deleteResolvedRequest(int resolvedRequestId) throws SystemException {
		// TODO Auto-generated method stub
		return resolvedRequestDao.deleteResolvedRequest(resolvedRequestId);
	}
	public EmployeePojo createEmployee(EmployeePojo employeePojo) throws SystemException {
		// TODO Auto-generated method stub
		return employeeDao.createEmployee(employeePojo);
	}
	public List<ManagerPojo> listAllManagers() throws SystemException, NoEmployeeFoundException {
		// TODO Auto-generated method stub
		return managerDao.listAllManagers();
	}
	public ManagerPojo fetchAManager(int managerId) throws SystemException {
		// TODO Auto-generated method stub
		return managerDao.fetchAManager(managerId);
	}
	public ManagerPojo createManager(ManagerPojo managerPojo) throws SystemException {
		// TODO Auto-generated method stub
		return managerDao.createManager(managerPojo);
	}
	public List<EmployeePojo> listAllUser() throws SystemException, NoEmployeeFoundException {
		// TODO Auto-generated method stub
		return employeeDao.listAllEmployees();
	}
	public List<EmployeePojo> listAllEmloyees() throws SystemException, NoEmployeeFoundException {
		// TODO Auto-generated method stub
		return employeeDao.listAllEmployees();
	}
	public EmployeePojo fetchAnEmployee(int employeeId) throws SystemException {
		// TODO Auto-generated method stub
		return employeeDao.fetchAnEmployee(employeeId);
	}
	public EmployeePojo updateEmployee(EmployeePojo employeePojo) throws SystemException {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employeePojo);
	}




		
	}


