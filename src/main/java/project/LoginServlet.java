package project;

import java.io.IOException;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.model.USER_ROLES;
import project.service.LoginService;
 
@WebServlet("/logins") 
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String username = request.getParameter("username");   
		String password = request.getParameter("pass");
		System.out.println("IN LOGIN SERVLET!");
		System.out.println(username +"+"+ password);
		
		boolean result = LoginService.authenticateUser(username, password);
		USER_ROLES role = LoginService.currentUser.getUSER_ROLE();
		
		if(result == true){
			System.out.println("success");
			request.getSession().setAttribute("username", username); 
			request.getSession().setAttribute("user", LoginService.currentUser); 
			request.getSession().setAttribute("userID", LoginService.currentUser.getERS_USERS_ID()); 
			request.getSession().setAttribute("role", LoginService.currentUser.getUSER_ROLE());
			//request.getSession().getAttribute("userID");
			System.out.println("USER:"+request.getSession().getAttribute("user"));
			System.out.println("username:"+request.getSession().getAttribute("username"));
			System.out.println("userID:"+request.getSession().getAttribute("userID"));
			System.out.println("role:"+request.getSession().getAttribute("role"));
			if(role.toString().equals("EMPLOYEE")) {
				response.sendRedirect("e-home.html");
			} else if(role.toString().equals("MANAGER")) {
				response.sendRedirect("m-home.html");
			} else {
				System.out.println("success error");
				response.sendRedirect("error.jsp");
			}
		}
		else{
			System.out.println("error");
			response.sendRedirect("error.jsp");
		}
	}
}