package service;

import java.util.List;


import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.PendingRequestPojo;
import pojo.EmployeePojo;

public class ExpenseServiceImpl implements ExpenseService{
	RequestDao requestDao;
	
	public ExpenseServiceImpl() {
		//bookDao = new BookDaoImpl();
		userDao = new EmployeeDaoImpl();
		requestDao = new RequestDaoImpl();
	}
	public List<PendingRequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException {
		// TODO Auto-generated method stub
		return requestDao.fetchAllRequests();
	}

	public PendingRequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException {
		// TODO Auto-generated method stub
		return requestDao.fetchARequest(requestId);
	}

	public PendingRequestPojo updateRequest(PendingRequestPojo requestPojo) throws SystemException {
		// TODO Auto-generated method stub
		return requestDao.updateRequest(requestPojo);
	}

	public PendingRequestPojo addRequest(PendingRequestPojo requestPojo) throws SystemException {
		// TODO Auto-generated method stub
		return requestDao.addRequest(requestPojo);
	}

	public PendingRequestPojo deleteRequest(int requestId) throws SystemException {
		// TODO Auto-generated method stub
		return requestDao.deleteRequest(requestId);
	}
	
	EmployeeDaoImpl userDao; 
	public List<EmployeePojo> listAllUser() throws SystemException, NoEmployeeFoundException {
		// TODO Auto-generated method stub
		return userDao.listAllUser();
	}

	public EmployeePojo fetchAUser(int userId) throws SystemException {
		// TODO Auto-generated method stub
		return userDao.fetchAUser(userId);
	}

	public EmployeePojo updateUser(EmployeePojo userPojo) throws SystemException {
		// TODO Auto-generated method stub
		return userDao.updateUser(userPojo);
	}
		
	}


