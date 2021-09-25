package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collection;

import project.dao.ERS_REIMBURSEMENTDao;
import project.dao.ERS_USERSDao;
import project.model.ERS_REIMBURSEMENT;
import project.model.REIMBURSEMENT_STATUS;
import project.model.REIMBURSEMENT_TYPE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/SubmitServlet")
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class SubmitServlet extends HttpServlet {
	ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();
	ERS_USERSDao uDao = new ERS_USERSDao();
  /**
	 * 
	 */
	private static final long serialVersionUID = -3167699126063292199L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In POST");
		PrintWriter out = response.getWriter();
	    /* Receive file uploaded to the Servlet from the HTML5 form */
		int userID =  (int) request.getSession().getAttribute("userID");
	    /* Receive file uploaded to the Servlet from the HTML5 form */
	    //Part filePart = request.getPart("file");
	    String fileThing = request.getParameter("file");
	    System.out.println("FIleThing:"+fileThing);
	    //String aFile = filePart.getContentType();
	    //String nFile = filePart.getSubmittedFileName();
		//System.out.println("Name:"+nFile);
		//System.out.println("ContentType:"+aFile);
	    String contentType = "";
	    Collection<Part> FileParts = request.getParts();
	    for (Part part : FileParts) {
	    	if(part.getSubmittedFileName() != null) {
	    		contentType = part.getContentType();
	    		System.out.println("CONTENT TYPE:" + contentType);
	    		break;
	    	}
	    }
	    String ending = "";
	    String min = Integer.toString(LocalDateTime.now().getMinute());
	    String h = Integer.toString(LocalDateTime.now().getHour());
	    String y = Integer.toString(LocalDateTime.now().getYear());
	    String mon = Integer.toString(LocalDateTime.now().getMonthValue());
	    String day = Integer.toString(LocalDateTime.now().getDayOfMonth());
	    String fileName = y+"-"+mon+"-"+day+" "+h+"-"+min; //filePart.getName();
	    
	    System.out.println(fileName);switch(contentType) {
	    case"image/jpeg":
	    	ending="jpg";
	    	break;
	    case"image/png":
	    	ending="png";
	    	break;
	    case"pdf":
	    	ending="pdf";
	    	break;
	    }
	    for (Part part : FileParts) {
	    	part.write("C:\\upload\\" + userID + fileName + "." + ending);
	    }
		String type =  request.getParameter("type");
	    String description = request.getParameter("description");
	    Double amount = Double.valueOf(request.getParameter("amount"));
	    System.out.println("AMOUNT:"+amount);
	    System.out.println("Desc:"+description);
	    System.out.println("type:"+type);
	    ERS_REIMBURSEMENT reimbursement = new ERS_REIMBURSEMENT();
	    REIMBURSEMENT_STATUS lStatus = REIMBURSEMENT_STATUS.PENDING;
	    REIMBURSEMENT_TYPE lType = REIMBURSEMENT_TYPE.get(type);
	    reimbursement.setREIMB_AMOUNT(amount);
	    reimbursement.setREIMB_DESCRIPTION(description);
	    reimbursement.setREIMB_STATUS(lStatus);
	    reimbursement.setREIMB_TYPE(lType);
	    reimbursement.setREIMB_AUTHOR(uDao.selectERS_USERS(userID));
	    reimbursement.setREIMB_RECEIPT("C:\\upload\\" + userID + fileName + "." + ending);
	    //filePart.write("E:\\uploads\\" + fileName);
	    eDao.insert(reimbursement);
	    //System.out.println(fileName);
	    System.out.print("The file uploaded sucessfully.");
	    out.print("The file uploaded sucessfully.");
	    response.sendRedirect("e-home.html");
	}

}