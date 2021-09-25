package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/square")
public class SquareServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String[] headParts = {"<style>.body{background-color: cyan;}</style>"};
		String toPrint = getParts.getHeader(headParts);
		String[] bodyParts = {"<b>Hello</b> from Square!"};
		toPrint += getParts.getBody(bodyParts);
		toPrint += getParts.getFooter();
		//out.println("<html><body bgcolor='cyan'>");
		//out.println("Hello from Square");
		out.println(toPrint);
	}
}
