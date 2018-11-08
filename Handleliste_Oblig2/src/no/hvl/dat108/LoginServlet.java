package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String feilmelding = "Feil passord, vennligst prøv igjen";
		String invalidUser = request.getParameter("invalid");

		out.print("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Vennligst logg inn med brukernavn og passord<h1>");
		if (invalidUser != null) {
			out.println("<h1 style=\"color:red\";>" + feilmelding + "</h1>");
		}
		out.println("<form ation=\"/login\" method=\"post\">");
		out.println("<input type=\"text\" name=\"username\" placeholder=\"brukernavn...\">");
		out.println("<br>");
		out.println("<input type=\"password\" name=\"password\" placeholder=\"passord...\">");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"logg inn\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig c = this.getServletConfig();
		HttpSession session= request.getSession();
		if(session != null) {
			session.invalidate();
		}
		session = request.getSession(true);
		int tidsInterval = Integer.parseInt(c.getInitParameter("tid"));
		session.setMaxInactiveInterval(tidsInterval);
		session.setAttribute("bruker", request.getParameter("password"));

		String passord = request.getParameter("password");
		if (passord.equals(c.getInitParameter("passord"))) {
			response.sendRedirect("HandlelisteServlet");
		} else {
			response.sendRedirect("LoginServlet" + "?invalid");
		}
	}

}
