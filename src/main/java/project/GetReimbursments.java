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

import org.hibernate.Query;
import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import project.dao.ERS_REIMBURSEMENTDao;
import project.dao.ERS_USERSDao;
import project.model.ERS_REIMBURSEMENT;
import project.model.ERS_USERS;
import project.model.REIMBURSEMENT_STATUS;
import project.service.LoginService;
import project.util.HibernateUtil;

/**
 * Servlet implementation class GetApproved
 */
public class GetReimbursments extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReimbursments() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START GET Pending");
		doPost(request, response);
		System.out.println("RETURN GET Pending");
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer userID=null; String name=null; Integer version=null; Integer choice=null;
		Session ses = HibernateUtil.getSession();
		try { 
			userID = (Integer) request.getSession().getAttribute("userID");
		} catch(Exception e) {
			System.out.println("NO USER ID!");
			System.out.println(e);
		}
		System.out.println("START POST REIMBURSMENT");
		ObjectMapper mapper = new ObjectMapper();
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
		List<List<ERS_REIMBURSEMENT>> theLists = new ArrayList<>();
		PrintWriter out = response.getWriter();
		if(name.equals("Approve") && choice != null && userID != null) {
			ERS_USERS use = (ERS_USERS) request.getSession().getAttribute("user");
			ERS_REIMBURSEMENT toUpdate = eDao.selectERS_REIMBURSEMENT(choice);
			toUpdate.setREIMB_RESLOVER(use);
			toUpdate.setREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);
			eDao.update(toUpdate);
			System.out.println("IN POST APPROVE");
			out.append("{\"NUMBER\":5,\"MESSAGE\":\"APPROVED\", \"TARGET\":\""+choice+"\"}");
		} else if(name.equals("Deny") && choice != null && userID != null){
			ERS_REIMBURSEMENT toUpdate = eDao.selectERS_REIMBURSEMENT(choice);
			ERS_USERSDao uDao = new ERS_USERSDao();
			ERS_USERS use = (ERS_USERS) uDao.selectERS_USERS(userID);
			System.out.println("USERID"+userID);
			System.out.println("USER"+use.getERS_USERS_ID());
			toUpdate.setREIMB_RESLOVER(use);
			toUpdate.setREIMB_STATUS(REIMBURSEMENT_STATUS.DENIED);
			eDao.update(toUpdate);
			System.out.println("IN POST DENY");
			out.append("{\"NUMBER\":5,\"MESSAGE\":\"DENIED\", \"TARGET\":\""+choice+"\"}");
		} else if(name.equals("Pending") && version != null) {
			Query<ERS_REIMBURSEMENT> query = ses.getNamedQuery("findReimbursmentsByStatusID")
					.setParameter("REIMB_STATUS", REIMBURSEMENT_STATUS.PENDING);
			List<ERS_REIMBURSEMENT> reimList = query.list();
			//List<ERS_REIMBURSEMENT> reimList = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.PENDING);
			theLists.add(reimList);
			System.out.println("IN POST GET-PENDING");
		} else if(name.equals("Resolved") && version != null) {
			Query<ERS_REIMBURSEMENT> query = ses.getNamedQuery("findReimbursmentsByStatusID")
					.setParameter("REIMB_STATUS", REIMBURSEMENT_STATUS.APPROVED);
			List<ERS_REIMBURSEMENT> reimLista = query.list();
			//List<ERS_REIMBURSEMENT> reimLista = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);
			Query<ERS_REIMBURSEMENT> query1 = ses.getNamedQuery("findReimbursmentsByStatusID")
					.setParameter("REIMB_STATUS", REIMBURSEMENT_STATUS.DENIED);
			List<ERS_REIMBURSEMENT> reimListd = query1.list();
			//List<ERS_REIMBURSEMENT> reimListd = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.DENIED);
			theLists.add(reimLista);
			theLists.add(reimListd);
			System.out.println("IN POST GET-RESOLVED");
		}
		List<Map<String,String>> easySend = new ArrayList<>();
		
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
			} else { System.out.println("RETURN POST REIMBURSMENT OUTSIDE"); }
		}catch (Exception e){
			System.out.println(e);
			System.out.println("###########################################");
			System.out.println("########### REIMBURSMENT BROKE! ###########");
			System.out.println("########### REIMBURSMENT BROKE! ###########");
			System.out.println("########### REIMBURSMENT BROKE! ###########");
			System.out.println("###########################################");
			out.append(e.toString());
		}
	}
}
