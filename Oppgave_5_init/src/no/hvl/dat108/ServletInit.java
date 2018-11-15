package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInit
 */
@WebServlet("/ServletInit")
public class ServletInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String serverInfo;
	
	@Override
	public void init() throws ServletException {
		serverInfo = getServletContext().getServerInfo();
	}
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Date naa = new Date();
		String dato = DateFormat.getDateInstance(DateFormat.LONG).format(naa);
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		String fornavn = request.getParameter("fornavn");
		if(fornavn == null) {
			fornavn = "Verden";
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>intitTest</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hei " + fornavn + "!</h1>");
		out.println("<p>Denne siden ble produsert " + dato + ".</p>");
		out.println("<h1>ServerInfo: " + serverInfo + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	

}
