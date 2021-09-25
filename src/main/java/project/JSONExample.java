package project;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.dao.ERS_USERSDao;
import project.model.ERS_USERS;
/**
 * Servlet implementation class JSONExample
 */
public class JSONExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper ob = new ObjectMapper();
		ERS_USERSDao eDao = new ERS_USERSDao();
		//User u = new User("2343", "abc", "def");
		List<ERS_USERS> users = eDao.selectAll();
		
		String jsonString=ob.writeValueAsString(users);
		System.out.println(jsonString);
		//ERS_USERS user = ob.readValue(jsonString, ERS_USERS.class);
		//System.out.println(user);
		//users=ob.readValue(jsonString, ERS_USERS.class);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonString);
		//response.getWriter().write(ObjectMapper().writeValuesAsString(new User("123", "abc", "def")));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
