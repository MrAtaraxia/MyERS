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
import project.util.HibernateUtil;

/**
 * Servlet implementation class GetUnapproved
 */
public class GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();
    private static boolean myLock = false;
    private int nextCheck = 1;
//    private CheckReimbursments check = new CheckReimbursments();

    
    public void init() {
    	 // Scan them
    	//CompletableFuture.;
    	//Concurrency <- look into!
    	//Thread <- Look into!
//        List<CompletableFuture<Integer>> tasks = new ArrayList<>();
//        for (int port : portsToScan) {
//            tasks.add(CompletableFuture.supplyAsync(() -> {
//                return scan(port) ? port : null;
//            }));
//        }
//
//        // Wait until all done and collect
//        List<Integer> openPorts = new ArrayList<>();
//        for (CompletableFuture<Integer> task : tasks) {
//            Integer result = task.get();
//            if (result != null) {
//                openPorts.add(result);
//            }
//        }
    }
//    /**
//     * Inner Functions.
//     */
//    // I SHOULD MAKE THIS A SINGLETON. EVENTUALLY!
//    private static class CheckReimbursments extends Thread {
//    	public static List<List<ERS_REIMBURSEMENT>> reimbursmentsByStatus = null;
//    	public static List<ERS_REIMBURSEMENT_STATUS> listOfStatus = null;
//    	private ERS_REIMBURSEMENT_STATUSDao sDao = new ERS_REIMBURSEMENT_STATUSDao();
//    	private ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();
//    	private static boolean ERS_REIMBURSEMENTLock = false;
//    	private static Map<String, Boolean> locks = new HashMap<>();
//    	private static Map<String, Integer> versions = new HashMap<>();
//    	
//        private int nextCheck = 0;
//        private Random rand = new Random();
//    	
//    	public CheckReimbursments() {
//    		locks.put("ERS_REIMBURSEMENT", false);
//    		locks.put("ERS_REIMBURSEMENT_STATUS", false);
//    		versions.put("ERS_REIMBURSEMENT", -1);
//    		versions.put("ERS_REIMBURSEMENT_STATUS", -1);
//    		listOfStatus=checkStatus();
//    		if(listOfStatus!= null) {
//    			for(int i = 0; i < listOfStatus.size();i++) {
//    				List<ERS_REIMBURSEMENT> newBursment = new ArrayList<>();
//    			}
//    		}
//    	}
//    	
//    	public List<ERS_REIMBURSEMENT_STATUS> checkStatus() {
//    		int waitingFor = 0;
//    		List<ERS_REIMBURSEMENT_STATUS> currentListOfStatus = null;
//    		while(ERS_REIMBURSEMENT_STATUSDao.version > versions.get("ERS_REIMBURSEMENT_STATUS")) {
//    			if(locks.get("ERS_REIMBURSEMENT_STATUS")) {
//    				try {
//    					int currWait = 10*rand.nextInt(100);
//						Thread.sleep(currWait);
//						waitingFor += currWait;
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						System.out.println(e);
//						Thread.currentThread().interrupt();
//						e.printStackTrace();
//					}
//    			} else {
//    				int currentVersion = -1;
//    				locks.put("ERS_REIMBURSEMENT_STATUS", true);
//    				try {
//    					currentVersion = ERS_REIMBURSEMENT_STATUSDao.version;
//    					currentListOfStatus = sDao.selectAll();
//    					if(currentListOfStatus!=null) {
//    						versions.put("ERS_REIMBURSEMENT_STATUS",currentVersion);
//        					return currentListOfStatus;
//        				}
//    				} catch(Exception e) {
//    					System.out.println(e);
//    					e.printStackTrace();
//    				}
//    				
//    			}
//    			if(waitingFor>=30000) {
//    				if(locks.get("ERS_REIMBURSEMENT_STATUS")) { locks.put("ERS_REIMBURSEMENT_STATUS", false); }
//    			}
//    		}
//    		return null;
//    	}
//    	
//        public void run() {
//            try {
//            }
//            catch(Exception e) {
//            	e.getStackTrace();
//            }
//        }
//    }
//    
//    public GetResolved() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

    private void logOut() {
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START GET Resolved");
//		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		System.out.println("RETURN GET Resolved");
//		out.append("GetUnapproved");
		doPost(request, response);
		//out.append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO CHECK TO SEE IF HAVING ACCESS:
		// What do I want to be the parameters?
		// choice - chosen user
		// name - function to be done.
		// version again? why not...
		
		Integer userID=null; String name=null; Integer version=null; Integer choice=null;
		try { 
			userID = (Integer) request.getSession().getAttribute("userID");
		} catch(Exception e) {
			System.out.println("NO USER ID!");
			System.out.println(e);
		}
		System.out.println("START POST USERS");
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
		List<ERS_USERS> theLists = new ArrayList<>();
		PrintWriter out = response.getWriter();
		
		/*
		 * I DO WANT TO API THIS... Hmm... I just don't know how to do taht.
		 *
		 * ALSO LOOK INTO MAKING A GOOD MVC...
		 * 
		 * HMM...
		 */

		ERS_USERSDao uDao = new ERS_USERSDao();
		/*
		 * GETTING ONE USER. get
		 */
		if(name.equals("Get") && choice != null && userID != null) {
			System.out.println("USER GET ONE");
			if(request.getSession().getAttribute("role").toString().equals("EMPLOYEE")) {
				/*
				 * Employee requesting personal profile data.
				 */
				System.out.println("EMPLOYEEE?");
				if(choice.equals(0)) {
					ERS_USERS user = uDao.selectERS_USERS(userID);
					Map<String, String> myMap = new HashMap<>();
					myMap.put("USERNAME", user.getERS_USERNAME());
					myMap.put("PASSWORD", user.getERS_PASSWORD());
					myMap.put("EMAIL", user.getUSER_EMAIL());
					myMap.put("FNAME", user.getUSER_FIRST_NAME());
					myMap.put("LNAME", user.getUSER_LAST_NAME());
					
					String theData = mapper.writeValueAsString(myMap); 
					System.out.println(theData);
					out.append(theData);
				}/*
				 * Employee requesting someone else's profile data.
				 */
				else {
					
					logOut();
				}
			/*
			 * MANAGER Requesting an employees profile data. 
			 */
			}else if(request.getSession().getAttribute("role").equals("MANAGER")) {
				System.out.println("MANAGER");
			
			}
			/*
			 * Others requesting users profile data.
			 */
			else {
				System.out.println("NEITHER EMPLOYEE OR MANAGER");
				System.out.println(request.getSession().getAttribute("role"));
				logOut();
			}
		}
		
		/*
		 * GETTING ALL OF THE USERS. To list. get
		 */
		else if(name.equals("GetAll") && choice != null && userID != null) {
			System.out.println("USER GET ALL");

		}
		
		/*
		 * UPDATING THE CURRENT USER. //put post?
		 */
		else if(name.equals("Update") && choice != null && userID != null) {
			System.out.println("USER UPDATE");
			System.out.println("YEP!");
			ERS_USERS user = uDao.selectERS_USERS(userID);
			user.setERS_USERNAME(request.getParameter("Username"));	
			user.setERS_PASSWORD(request.getParameter("Password"));
			user.setUSER_EMAIL(request.getParameter("Email"));
			user.setUSER_FIRST_NAME(request.getParameter("FirstName"));
			user.setUSER_LAST_NAME(request.getParameter("LastName"));
			uDao.update(user);
			out.append("{\"message\":\"User Updated\"}");
		}
		
		/*
		 * CREATING A NEW USER! //put?
		 */
		else if(name.equals("Insert") && choice != null && userID != null) {
			System.out.println("USER INSERT");
		}
		
		
//		if(name.equals("Approve") && choice != null && userID != null) {
//			ERS_USERS use = (ERS_USERS) request.getSession().getAttribute("user");
//			ERS_REIMBURSEMENT toUpdate = eDao.selectERS_REIMBURSEMENT(choice);
//			toUpdate.setREIMB_RESLOVER(use);
//			toUpdate.setREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);
//			eDao.update(toUpdate);
//			System.out.println("IN POST APPROVE");
//			out.append("{\"NUMBER\":5,\"MESSAGE\":\"APPROVED\", \"TARGET\":\""+choice+"\"}");
//		} else if(name.equals("Deny") && choice != null && userID != null){
//			ERS_REIMBURSEMENT toUpdate = eDao.selectERS_REIMBURSEMENT(choice);
//			ERS_USERSDao uDao = new ERS_USERSDao();
//			ERS_USERS use = (ERS_USERS) uDao.selectERS_USERS(userID);
//			System.out.println("USERID"+userID);
//			System.out.println("USER"+use.getERS_USERS_ID());
//			toUpdate.setREIMB_RESLOVER(use);
//			toUpdate.setREIMB_STATUS(REIMBURSEMENT_STATUS.DENIED);
//			eDao.update(toUpdate);
//			System.out.println("IN POST DENY");
//			out.append("{\"NUMBER\":5,\"MESSAGE\":\"DENIED\", \"TARGET\":\""+choice+"\"}");
//		} else if(name.equals("Pending") && version != null) {
//			Query<ERS_REIMBURSEMENT> query = ses.getNamedQuery("findReimbursmentsByStatusID")
//					.setParameter("REIMB_STATUS", REIMBURSEMENT_STATUS.PENDING);
//			List<ERS_REIMBURSEMENT> reimList = query.list();
//			//List<ERS_REIMBURSEMENT> reimList = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.PENDING);
//			theLists.add(reimList);
//			System.out.println("IN POST GET-PENDING");
//		} else if(name.equals("Resolved") && version != null) {
//			Query<ERS_REIMBURSEMENT> query = ses.getNamedQuery("findReimbursmentsByStatusID")
//					.setParameter("REIMB_STATUS", REIMBURSEMENT_STATUS.APPROVED);
//			List<ERS_REIMBURSEMENT> reimLista = query.list();
//			//List<ERS_REIMBURSEMENT> reimLista = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);
//			Query<ERS_REIMBURSEMENT> query1 = ses.getNamedQuery("findReimbursmentsByStatusID")
//					.setParameter("REIMB_STATUS", REIMBURSEMENT_STATUS.DENIED);
//			List<ERS_REIMBURSEMENT> reimListd = query1.list();
//			//List<ERS_REIMBURSEMENT> reimListd = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.DENIED);
//			theLists.add(reimLista);
//			theLists.add(reimListd);
//			System.out.println("IN POST GET-RESOLVED");
//		}
//		List<Map<String,String>> easySend = new ArrayList<>();
//		
//		try {
//			for(List<ERS_REIMBURSEMENT> reimList: theLists) {
//				for(ERS_REIMBURSEMENT rei:reimList) {
//					Map<String,String> toAdd = new HashMap<>();
//														   toAdd.put("ID"			,rei.getREIMB_ID()+"");
//														   toAdd.put("AMOUNT"		,rei.getREIMB_AMOUNT()+"");
//														   toAdd.put("RECEIPT"		,rei.getREIMB_RECEIPT()+"");
//					if(rei.getREIMB_DESCRIPTION()!=null) { toAdd.put("DESCRIPTION"	,rei.getREIMB_DESCRIPTION()+" "); }
//					else { 								   toAdd.put("DESCRIPTION"	,"null"); }
//														   toAdd.put("AUTHOR"		,rei.getREIMB_AUTHOR().getERS_USERS_ID()+"");
//					if(rei.getREIMB_RESLOVER()!=null) {    toAdd.put("RESLOVER"		,rei.getREIMB_RESLOVER().getERS_USERS_ID()+""); }
//					else { 								   toAdd.put("RESLOVER"		,"null");}
//					if(rei.getREIMB_RESOLVED()!=null) {    toAdd.put("RESOLVED"		,rei.getREIMB_RESOLVED()+"");
//					}else { 							   toAdd.put("RESOLVED"		,"null"); }
//														   toAdd.put("STATUS"		,rei.getREIMB_STATUS()+"");
//														   toAdd.put("SUBMITTED"	,rei.getREIMB_SUBMITTED()+"");
//														   toAdd.put("TYPE"			,rei.getREIMB_TYPE()+"");
//					easySend.add(toAdd);
//				}
//			}
//			String theData = "";
//			if(easySend.size()>0) 
//			{ 
//				theData = mapper.writeValueAsString(easySend); 
//				List<String> storage = new ArrayList<>();
//				storage.add(12345+"");
//				storage.add(theData);
//				String toSend = mapper.writeValueAsString(storage);
//				System.out.println("RETURN POST REIMBURSMENT INSIDE");
//				System.out.println(toSend);
//				out.append(toSend);
//			} else { System.out.println("RETURN POST REIMBURSMENT OUTSIDE"); }
//		}catch (Exception e){
//			System.out.println(e);
//			System.out.println("###########################################");
//			System.out.println("########### REIMBURSMENT BROKE! ###########");
//			System.out.println("########### REIMBURSMENT BROKE! ###########");
//			System.out.println("########### REIMBURSMENT BROKE! ###########");
//			System.out.println("###########################################");
//			out.append(e.toString());
//		}
	}
}
