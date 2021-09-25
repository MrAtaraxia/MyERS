package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandlerServlet
 */
public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		System.out.println("Error");
		out.println("Error");
		try {
		
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		
		Class<?> expceptionClass = (Class<?>) request.getAttribute("javax.servlet.error.exception_type");
		
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		
		String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
		
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		String servletName = (String) request.getAttribute("javax.servlet.error.sevlet_name");
		System.out.println(exception);
		System.out.println(expceptionClass);
		System.out.println(statusCode);
		System.out.println(errorMessage);
		System.out.println(requestUri);
		System.out.println(servletName);
		out.println(exception);
		out.println(expceptionClass);
		out.println(statusCode);
		out.println(errorMessage);
		out.println(requestUri);
		out.println(servletName);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
