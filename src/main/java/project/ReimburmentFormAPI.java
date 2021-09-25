package project;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ReimburmentFormAPI
 */
//@WebServlet(name = "ReimburmentFormAPI", urlPatterns = { "/ReimburmentFormAPI"});
public class ReimburmentFormAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimburmentFormAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("password"));
		String gender = request.getParameter("gender");
		String[] language = request.getParameterValues("language");
		//Declaring type of response.
		response.setContentType("text/plain");
		//Creating/Sending response.
		PrintWriter out = response.getWriter();
		System.out.println("Name: " + name + " age: " + age + " gender: " + gender);
		out.println("Name: " + name + " age: " + age + " gender: " + gender);
		for(String lang:language) {
			System.out.println(lang);
			out.println(lang);
		}
//		response.setContentType("text/plain");
//		out.println(to_send);
//		append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		doGet(request, response);
	}
}
