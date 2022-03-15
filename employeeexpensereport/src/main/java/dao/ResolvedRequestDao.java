package dao;
import java.util.List;

import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.ResolvedRequestPojo;
public interface ResolvedRequestDao {
	List<ResolvedRequestPojo> fetchAllRequest() throws SystemException, RequestNotFoundException;
	ResolvedRequestPojo fetchAResolvedRequest(int resolvedRequestId) throws SystemException;
	//ResolvedRequestPojo addResolvedRequest(ResolvedRequestPojo resolvedRequestPojo);
	ResolvedRequestPojo deleteResolvedRequest(int resolvedRequestId) throws SystemException;
	
	
}