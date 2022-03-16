package presentation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import io.javalin.Javalin;

import pojo.PendingRequestPojo;
import pojo.ResolvedRequestPojo;
import pojo.EmployeePojo;
import pojo.ManagerPojo;
import service.ExpenseService;
import service.ExpenseServiceImpl;

public class ExpenseMain {

	public static void main(String[] args) {
		ExpenseService expenseService =new ExpenseServiceImpl();
		Javalin myServer = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);
		System.out.println("server listening at port 4040...");
		//list all employee
		myServer.get("/api/employee", (ctx)-> {
			List<EmployeePojo> allEmployee = expenseService.listAllEmloyees();
			ctx.json(allEmployee);
			
		});
		//list all pending requests
		myServer.get("/api/requests", (ctx)-> {
			List<PendingRequestPojo> allPendingRequests = expenseService.fetchAllRequests();
			ctx.json(allPendingRequests);
			
		});
		//list all manager
		myServer.get("/api/manager", (ctx)-> {
			List<ManagerPojo> allManagers = expenseService.listAllManagers();
			ctx.json(allManagers);
		});
		//list all resolved request
		myServer.get("/api/resolved-request", (ctx)-> {
			List<ResolvedRequestPojo> allResolvedRequest = expenseService.fetchAllRequest();
			ctx.json(allResolvedRequest);
		});
		//add a request
		myServer.post("/api/pending-request", (ctx)-> {
			
			PendingRequestPojo newRequest = ctx.bodyAsClass(PendingRequestPojo.class);
			PendingRequestPojo returnedRequest = expenseService.addRequest(newRequest);
			ctx.json(returnedRequest);
		
		});
		//add a employee
		myServer.post("/api/employee", (ctx)-> {
			
			EmployeePojo newEmployee = ctx.bodyAsClass(EmployeePojo.class);
			EmployeePojo  returnedEmployee = expenseService.createEmployee(newEmployee);
			ctx.json(returnedEmployee);
		
		});
	
		//add a resolved request
		//myServer.post("/api/resolved-request", (ctx)-> {
			
			//ResolvedRequestPojo newResolvedRequest = ctx.bodyAsClass(ResolvedRequestPojo.class);
			//ResolvedRequestPojo  returnedResolvedRequest = expenseService.createEmployee(newResolvedRequest);
			//ctx.json(returnedResolvedRequest);
		
		//});
		//update request
		myServer.put("/api/requests", (ctx)-> {
		PendingRequestPojo updateRequest = ctx.bodyAsClass(PendingRequestPojo.class);
		PendingRequestPojo returnUpdatedRequest = expenseService.updateRequest(updateRequest);
		ctx.json(returnUpdatedRequest);
	
		});
		
		//fetch A employee
		myServer.get("/api/employee/{bid}", (ctx)-> {
			
			String employeeId = ctx.pathParam("bid");
			EmployeePojo fetchedUser = expenseService.fetchAnEmployee(Integer.parseInt(employeeId));
			ctx.json(fetchedUser);
			
		
		});
		//fetch A manager
		myServer.get("/api/manager/{bid}", (ctx)-> {
			
			String managerId = ctx.pathParam("bid");
			ManagerPojo fetchedManager = expenseService.fetchAManager(Integer.parseInt(managerId));
			ctx.json(fetchedManager);
			
		
		});
		//fetch A Resolved Request
		myServer.get("/api/resolved-request/{bid}", (ctx)-> {
			
			String userId = ctx.pathParam("bid");
			ResolvedRequestPojo fetchedResolvedRequest = expenseService.fetchAResolvedRequest(Integer.parseInt(userId));
			ctx.json(fetchedResolvedRequest);
			
		
		});
		//fetch A pending request
		myServer.get("/api/requests/{bid}", (ctx)-> {
			
			String requestId = ctx.pathParam("bid");
			PendingRequestPojo fetchedRequest = expenseService.fetchARequest(Integer.parseInt(requestId));
			ctx.json(fetchedRequest);
			
		});
		//update a user
		myServer.put("/api/employee", (ctx)-> {
			EmployeePojo updateUser = ctx.bodyAsClass(EmployeePojo.class);
			EmployeePojo returnUpdatedUser = expenseService.updateEmployee(updateUser);
			ctx.json(returnUpdatedUser);
	});
		//update a Request
		myServer.put("/api/pending-request", (ctx)-> {
			PendingRequestPojo updateRequest = ctx.bodyAsClass(PendingRequestPojo.class);
			PendingRequestPojo returnUpdatedRequest = expenseService.updateRequest(updateRequest);
			ctx.json(returnUpdatedRequest);
	});
		
		
		myServer.exception(SystemException.class, (se, ctx)-> {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", se.getMessage());
			error.put("datetime", LocalDateTime.now()+"");
			ctx.json(error);
		});
		
		myServer.exception(RequestNotFoundException.class, (be, ctx)-> {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", be.getMessage());
			error.put("datetime", LocalDateTime.now()+"");
			ctx.json(error);
		});
		
		myServer.exception(NoEmployeeFoundException.class, (be, ctx)-> {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", be.getMessage());
			error.put("datetime", LocalDateTime.now()+"");
			ctx.json(error);
		});
		
	}
}
