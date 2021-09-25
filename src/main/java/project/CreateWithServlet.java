package project;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
import project.dao.*;
import project.model.*;

//@WebServlet("/CreateWithServlet")
public class CreateWithServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8399984681507942157L;
	private static final Exception IllegalAccessException = null;

	// This Method Is Called By The Servlet Container To Process A 'GET' Request.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
			handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ERS_USER_ROLES uObj = new ERS_USER_ROLES();
        System.out.println("END THIS! NOT WORKING");
        throw IllegalAccessException;
//
//    	System.out.println("DATA:");
//    	for(ERS_USER_ROLES urole: uRoles) {
//        	System.out.println(urole);
//        }
//        request.getSession().setAttribute("roles", uRoles);
// 
//        RequestDispatcher rd = request.getRequestDispatcher("/getData.jsp");
//        rd.forward(request, response);
    }
}
