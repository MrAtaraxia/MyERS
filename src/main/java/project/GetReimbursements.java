package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.Exceptions.ReimbursementException;
import project.model.ERS_REIMBURSEMENT;
import project.model.ERS_USERS;
import project.model.REIMBURSEMENT_STATUS;
import project.model.USER_ROLES;
import project.service.ReimbursementService;
import project.service.ReimbursementServices;
import project.service.UserService;
import project.service.UserServices;

/**
 * Servlet implementation class GetApproved
 */
public class GetReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uService = new UserServices();
	private ReimbursementService rService = new ReimbursementServices();
    //private ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReimbursements() {
        super();
    }

    void Approve(HttpServletRequest request, HttpServletResponse response, Integer choice, Integer userID) throws IOException, ReimbursementException {
    	System.out.println("APPROVE START role:" + (USER_ROLES) request.getSession().getAttribute("role"));
    	System.out.println("APPROVE START choice:" + choice);
    	PrintWriter out = response.getWriter();
		ERS_USERS use = (ERS_USERS) request.getSession().getAttribute("user");
		ERS_REIMBURSEMENT toUpdate = rService.retrieveReimbursement(choice); //eDao.selectERS_REIMBURSEMENT(choice);
		if(toUpdate!=null) {
			toUpdate.setREIMB_RESLOVER(use);
			toUpdate.setREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);
			rService.updateReimbursement(toUpdate);
			System.out.println("IN POST APPROVE");
			out.append("{\"NUMBER\":5,\"MESSAGE\":\"APPROVED\", \"TARGET\":\""+choice+"\"}");
		}else {
			throw new ReimbursementException("Invalid reimbursement number");
		}
		System.out.println("APPROVE END");
    }
    
    void Deny(HttpServletRequest request, HttpServletResponse response, Integer choice, Integer userID) throws IOException, ReimbursementException {
    	System.out.println("DENY START role:" + (USER_ROLES) request.getSession().getAttribute("role"));
    	System.out.println("DENY START choice:" + choice);
    	
    	PrintWriter out = response.getWriter();
		ERS_USERS use = (ERS_USERS) request.getSession().getAttribute("user");
		ERS_REIMBURSEMENT toUpdate = rService.retrieveReimbursement(choice); //eDao.selectERS_REIMBURSEMENT(choice);
		if(toUpdate!=null) {
			toUpdate.setREIMB_RESLOVER(use);
			toUpdate.setREIMB_STATUS(REIMBURSEMENT_STATUS.DENIED);
			rService.updateReimbursement(toUpdate);
			System.out.println("IN POST DENY");
			out.append("{\"NUMBER\":5,\"MESSAGE\":\"DENIED\", \"TARGET\":\""+choice+"\"}");
		}else {
			throw new ReimbursementException("Invalid reimbursement number");
		}
		System.out.println("DENY END");
    }
    
    void Pending(HttpServletRequest request, HttpServletResponse response, Integer choice, Integer userID) throws IOException {
		System.out.println("PENDING START role:" + (USER_ROLES) request.getSession().getAttribute("role"));;
		List<List<ERS_REIMBURSEMENT>> theLists = new ArrayList<>();
    	PrintWriter out = response.getWriter();
    	List<ERS_REIMBURSEMENT> reimList = null;
    	if(((USER_ROLES)request.getSession().getAttribute("role")).toString().equals(USER_ROLES.EMPLOYEE.toString())) {
    		choice = (Integer) request.getSession().getAttribute("userID");
    		System.out.println("CURRENT EMPLOYEE assessing:" + choice);
    	}else {
    		System.out.println("CURRENT MANAGER accessing:" + choice);
    	}
    	if(choice.equals(0)) {
    		reimList = rService.retrieveAllReimbursementsByStatus(REIMBURSEMENT_STATUS.PENDING);
    	} else {
    		reimList = rService.retrieveAllReimbursementsByStatusAndUserID(REIMBURSEMENT_STATUS.PENDING, choice);
    	}
		//List<ERS_REIMBURSEMENT> reimList = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.PENDING);
		theLists.add(reimList);
		SendThings(theLists, out);
		System.out.println("PENDING END");
    }
    
	private void Resolved(HttpServletRequest request, HttpServletResponse response, Integer choice, Integer userID) throws IOException {
		System.out.println("RESOLVED START role:" + (USER_ROLES) request.getSession().getAttribute("role"));
		List<List<ERS_REIMBURSEMENT>> theLists = new ArrayList<>();
		PrintWriter out = response.getWriter();
		List<ERS_REIMBURSEMENT> reimLista = null;
		List<ERS_REIMBURSEMENT> reimListd = null;
    	if(((USER_ROLES)request.getSession().getAttribute("role")).toString().equals(USER_ROLES.EMPLOYEE.toString())) {
    		choice = (Integer) request.getSession().getAttribute("userID");
    		System.out.println("CURRENT EMPLOYEE assessing:" + choice);
    	}else {
    		System.out.println("CURRENT MANAGER accessing:" + choice);
    	}
		if(choice.equals(0)) {
			reimLista = rService.retrieveAllReimbursementsByStatus(REIMBURSEMENT_STATUS.APPROVED);
			reimListd = rService.retrieveAllReimbursementsByStatus(REIMBURSEMENT_STATUS.DENIED);
		} else {
			reimLista = rService.retrieveAllReimbursementsByStatusAndUserID(REIMBURSEMENT_STATUS.APPROVED, choice);
			reimListd = rService.retrieveAllReimbursementsByStatusAndUserID(REIMBURSEMENT_STATUS.DENIED, choice);
		}
		if(reimLista!=null) {
			theLists.add(reimLista);
		}
		if(reimListd!=null) {
			theLists.add(reimListd);
		}
		SendThings(theLists, out);
		System.out.println("RESOLVED END");
	}
	
	private void SendThings(List<List<ERS_REIMBURSEMENT>> theLists, PrintWriter out) {
		System.out.println("SENDING THINGS START");
		List<Map<String,String>> easySend = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			for(List<ERS_REIMBURSEMENT> reimList: theLists) {
				for(ERS_REIMBURSEMENT rei:reimList) {
					Map<String,String> toAdd = new HashMap<>();
														   toAdd.put("ID"			,rei.getREIMB_ID()+"");
														   toAdd.put("AMOUNT"		,rei.getREIMB_AMOUNT()+"");
														   toAdd.put("RECEIPT"		,rei.getREIMB_RECEIPT()+"");
					if(rei.getREIMB_DESCRIPTION()!=null) { toAdd.put("DESCRIPTION"	,rei.getREIMB_DESCRIPTION()+" "); }
					else { 								   toAdd.put("DESCRIPTION"	,"null"); }
														   toAdd.put("AUTHOR"		,rei.getREIMB_AUTHOR().getERS_USERS_ID()+"");
					if(rei.getREIMB_RESLOVER()!=null) {    toAdd.put("RESLOVER"		,rei.getREIMB_RESLOVER().getERS_USERS_ID()+""); }
					else { 								   toAdd.put("RESLOVER"		,"null");}
					if(rei.getREIMB_RESOLVED()!=null) {    toAdd.put("RESOLVED"		,rei.getREIMB_RESOLVED()+"");
					}else { 							   toAdd.put("RESOLVED"		,"null"); }
														   toAdd.put("STATUS"		,rei.getREIMB_STATUS()+"");
														   toAdd.put("SUBMITTED"	,rei.getREIMB_SUBMITTED()+"");
														   toAdd.put("TYPE"			,rei.getREIMB_TYPE()+"");
					easySend.add(toAdd);
				}
			}
			String theData = "";
			if(easySend.size()>0) 
			{ 
				theData = mapper.writeValueAsString(easySend); 
				List<String> storage = new ArrayList<>();
				storage.add(12345+"");
				storage.add(theData);
				String toSend = mapper.writeValueAsString(storage);
				System.out.println("RETURN POST REIMBURSMENT INSIDE");
				System.out.println(toSend);
				out.append(toSend);
			} else { 
				System.out.println("RETURN POST REIMBURSMENT OUTSIDE"); 
				List<String> storage = new ArrayList<>();
				storage.add(12345+"");
				storage.add(theData);
				String toSend = mapper.writeValueAsString(storage);
				System.out.println(toSend);
				out.append(toSend);
				}
		}catch (Exception e){
			System.out.println(e);
			System.out.println("###########################################");
			System.out.println("########### REIMBURSMENT BROKE! ###########");
			System.out.println("########### REIMBURSMENT BROKE! ###########");
			System.out.println("########### REIMBURSMENT BROKE! ###########");
			System.out.println("###########################################");
			out.append(e.toString());
		}
		System.out.println("SENDING THINGS END");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START GET Pending");
		doPost(request, response);
		System.out.println("RETURN GET Pending");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userID=null; String name=null; Integer version=null; Integer choice=null;
		System.out.println("START POST REIMBURSMENT role:" + (USER_ROLES) request.getSession().getAttribute("role"));
		try { 
			userID = (Integer) request.getSession().getAttribute("userID");
		} catch(Exception e) {
			System.out.println("NO USER ID!");
			System.out.println(e);
		}
		name = request.getParameter("name");
		try {
			version = Integer.parseInt(request.getParameter("version"));
		} catch(Exception e) {
			System.out.println("NO VERSION!");
			System.out.println(e);
		}
		try {
			choice = Integer.parseInt(request.getParameter("choice"));
		} catch(Exception e) {
			System.out.println("NO CHOICE!");
			System.out.println(e);
		}
		
		if(name.equals("Approve") && choice != null && userID != null) {
			try {
				Approve(request, response, choice, userID);
			} catch (IOException | ReimbursementException e) {
				e.printStackTrace();
			}
		} else if(name.equals("Deny") && choice != null && userID != null){
			try {
				Deny(request, response, choice, userID);
			} catch (IOException | ReimbursementException e) {
				e.printStackTrace();
			}
		} else if(name.equals("Pending") && version != null) {
			Pending(request, response, choice, userID);
		} else if(name.equals("Resolved") && version != null) {
			Resolved(request, response, choice, userID);
		}
		System.out.println("ENDING POST REIMBURSMENT");
	}



	public UserService getuService() {
		return uService;
	}

	public void setuService(UserService uService) {
		this.uService = uService;
	}
}
