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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("START POST Pending");
		ObjectMapper mapper = new ObjectMapper();
		String name = request.getParameter("name");
		int version = Integer.parseInt(request.getParameter("version"));
		System.out.println("REQUEST Pending:"+request.getMethod());
		
		List<List<ERS_REIMBURSEMENT>> theLists = new ArrayList<>();
		if(name.equals("Pending")) {
			List<ERS_REIMBURSEMENT> reimList = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.PENDING);
			theLists.add(reimList);
		} else if(name.equals("Resolved")) {
			List<ERS_REIMBURSEMENT> reimLista = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);
			List<ERS_REIMBURSEMENT> reimListd = eDao.selectByREIMB_STATUS(REIMBURSEMENT_STATUS.DENIED);
			theLists.add(reimLista);
			theLists.add(reimListd);
		}
		List<Map<String,String>> easySend = new ArrayList<>();
		PrintWriter out = response.getWriter();
		try {
			for(List<ERS_REIMBURSEMENT> reimList: theLists) {
				for(ERS_REIMBURSEMENT rei:reimList) {
					Map<String,String> toAdd = new HashMap<>();
					toAdd.put("ID"			,rei.getREIMB_ID()+"");
					toAdd.put("AMOUNT"		,rei.getREIMB_AMOUNT()+"");
					toAdd.put("RECEIPT"		,rei.getREIMB_RECEIPT()+"");
					if(rei.getREIMB_DESCRIPTION()!=null) {
						toAdd.put("DESCRIPTION"	,rei.getREIMB_DESCRIPTION()+" ");
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
			}
			
			String theData = mapper.writeValueAsString(easySend);
			List<String> storage = new ArrayList<>();
			storage.add(12345+"");
			storage.add(theData);
			String toSend = mapper.writeValueAsString(storage);
			System.out.println("RETURN POST Pending");
			//toSend = "["+ERS_REIMBURSEMENTDao.version + "," + toSend + "]";
			System.out.println(toSend);
			out.append(toSend);
		}catch (Exception e){
			System.out.println(e);
			System.out.println("PENDING BROKE!");
			System.out.println("PENDING BROKE!");
			System.out.println("PENDING BROKE!");
			out.append(e.toString());
		}
	}
}
