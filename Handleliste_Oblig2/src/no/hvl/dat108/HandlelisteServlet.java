package no.hvl.dat108;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Servlet implementation class HandlelisteServlet
 */
@WebServlet("/HandlelisteServlet")
public class HandlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> varer;

	@Override
	public void init() {
		varer = new ArrayList<String>();
	}

//	private String escapeHtml(String s) {
//		String resultat = s;
//		resultat = resultat.replaceAll("<", "&lt;");
//		resultat = resultat.replaceAll(">", "&gt;");
//		resultat = resultat.replaceAll("&", "&amp;");
//		resultat = resultat.replaceAll("\"", "&quot;");
//		resultat = resultat.replaceAll("'", "&#39;");
//		// ...
//		return resultat;
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Handleliste</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Min handleliste</h1>");
		out.println("<form action=\"HandlelisteServlet\" method=\"post\">");
		out.println("<input type =\"submit\" value=\"legg til\" name=\"leggTil\">");
		out.println("<input type=\"text\" name=\"input\" placeholder=\"varenavn...\">");
		out.println("</form>");
		out.println("<br><br><br><br>");
		for (String s : varer) {
			{
				out.println("<form method=\"post\">");
				out.println("<input type=\"hidden\" value=\"" + s
						+ "\" name=\"delete\"><input type=\"submit\" value=\"slett\">"
						+ "<span style=\"font-size:30px;\">" + s + "</span></form>" + "<br>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("delete") != null
				&& varer.indexOf(StringEscapeUtils.escapeHtml(request.getParameter("delete"))) != -1) {
			synchronized (varer) {
				varer.remove(varer.indexOf(StringEscapeUtils.escapeHtml(request.getParameter("delete"))));
			}
		} else {
			String input = request.getParameter("input");
			String inputesc = StringEscapeUtils.escapeHtml(input);
			if (inputesc.matches("^\\S+(?: \\S+)*$")) {
				varer.add(inputesc);
			}
		}
		response.sendRedirect("HandlelisteServlet");

	}
}
