package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/add")
public class AddServlet extends HttpServlet{

	/**
	 * up to 42:00
	 */
	
	//request dispatcher
	
	//or redirect.
	private static final long serialVersionUID = -5359552419712201376L;
	
		
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k = i + j;
//		PrintWriter out = res.getWriter();
//		
//		out.println("result is " + k);
//		
//	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//res.setContentType("application/json"); //JSON
		//application/java-archive
		//response.setContentType("text/html");
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		PrintWriter out = res.getWriter();
		
		out.println("result is " + k);
		
		RequestDispatcher rd = req.getRequestDispatcher("square");
		rd.forward(req,res);
	}
}
