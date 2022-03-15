package dao;

import java.util.List;

import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.PendingRequestPojo;

public interface RequestDao {
	
	List<PendingRequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException;
	
	PendingRequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException;
	
	PendingRequestPojo updateRequest(PendingRequestPojo requestPojo) throws SystemException;
	
	PendingRequestPojo addRequest(PendingRequestPojo requestPojo) throws SystemException;
	
	PendingRequestPojo deleteRequest(int requestId) throws SystemException;
	
	

}
