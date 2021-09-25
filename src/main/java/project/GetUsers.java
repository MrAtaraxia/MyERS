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

import project.dao.ERS_REIMBURSEMENTDao;
import project.model.ERS_REIMBURSEMENT;
import project.model.REIMBURSEMENT_STATUS;

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
		System.out.println("START POST Resolved");
		System.out.println();
		System.out.println("REQUEST GR:"+request.getMethod());
		System.out.println("STATUS APPROVED:"+REIMBURSEMENT_STATUS.APPROVED.toString());
		List<ERS_REIMBURSEMENT> reimLista = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);

		List<ERS_REIMBURSEMENT> reimListd = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.DENIED);
											//   selectByREIMB_STATUS_ID
		List<Map<String,String>> easySend = new ArrayList<>();
		for(ERS_REIMBURSEMENT rei:reimLista) {
			Map<String,String> toAdd = new HashMap<>();
			toAdd.put("ID"			,rei.getREIMB_ID()+"");
			toAdd.put("AMOUNT"		,rei.getREIMB_AMOUNT()+"");
			toAdd.put("RECEIPT"		,rei.getREIMB_RECEIPT()+"");			
			if(rei.getREIMB_DESCRIPTION()!=null) {
				toAdd.put("DESCRIPTION"	,rei.getREIMB_DESCRIPTION()+"");
			}else {
				toAdd.put("DESCRIPTION"	,"null");
			}
			toAdd.put("AUTHOR"		,rei.getREIMB_AUTHOR().getERS_USERS_ID()+"");
			if(rei.getREIMB_RESLOVER()!=null) {
				toAdd.put("RESLOVER"	,rei.getREIMB_RESLOVER().getERS_USERS_ID()+"");
			}else {
				toAdd.put("RESLOVER"	,"null");
			}
			if(rei.getREIMB_RESOLVED()!=null) {
				toAdd.put("RESOLVED"	,rei.getREIMB_RESOLVED()+"");
			}else {
				toAdd.put("RESOLVED"	,"null");
			}
			toAdd.put("STATUS"		,rei.getREIMB_STATUS()+"");
			toAdd.put("SUBMITTED"	,rei.getREIMB_SUBMITTED()+"");
			toAdd.put("TYPE"		,rei.getREIMB_TYPE()+"");
			easySend.add(toAdd);
		}		for(ERS_REIMBURSEMENT rei:reimListd) {
			Map<String,String> toAdd = new HashMap<>();
			toAdd.put("ID"			,rei.getREIMB_ID()+"");
			toAdd.put("AMOUNT"		,rei.getREIMB_AMOUNT()+"");
			toAdd.put("RECEIPT"		,rei.getREIMB_RECEIPT()+"");
			if(rei.getREIMB_DESCRIPTION()!=null) {
				toAdd.put("DESCRIPTION"	,rei.getREIMB_DESCRIPTION()+"");
			}else {
				toAdd.put("DESCRIPTION"	,"null");
			}
			toAdd.put("AUTHOR"		,rei.getREIMB_AUTHOR().getERS_USERS_ID()+"");
			if(rei.getREIMB_RESLOVER()!=null) {
				toAdd.put("RESLOVER"	,rei.getREIMB_RESLOVER().getERS_USERS_ID()+"");
			}else {
				toAdd.put("RESLOVER"	,"null");
			}
			if(rei.getREIMB_RESOLVED()!=null) {
				toAdd.put("RESOLVED"	,rei.getREIMB_RESOLVED()+"");
			}else {
				toAdd.put("RESOLVED"	,"null");
			}
			toAdd.put("STATUS"		,rei.getREIMB_STATUS()+"");
			toAdd.put("SUBMITTED"	,rei.getREIMB_SUBMITTED()+"");
			toAdd.put("TYPE"		,rei.getREIMB_TYPE()+"");
			easySend.add(toAdd);
		}
		//reimList.
		ObjectMapper mapper = new ObjectMapper();
		//response.setContentType("text/plain")
		//response.setContentType("application/json");
		//User use = mapper.readValue(request.getReader(), User.class);
		String toSend = mapper.writeValueAsString(easySend);
		System.out.println("RETURN POST Resolved");
		PrintWriter out = response.getWriter();
		System.out.println(toSend);
		out.append(toSend);
	}
}
