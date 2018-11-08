package no.hvl.dat108;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deltagerListeServlet
 */
@WebServlet("/deltagerListeServlet")
public class deltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@EJB
	private PersonEAO personEAO;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesjon = request.getSession(false);
		
		ArrayList<String> fargeListe = new ArrayList<String>();

		if (sesjon == null || sesjon.getAttribute("mobilnr") == null) {
			response.sendRedirect("logginnServlet");

		} else {
			String mobilNrBruker = (String) sesjon.getAttribute("mobilnr");
			request.getSession().setAttribute("bruker", mobilNrBruker);
			request.getSession().setAttribute("list", personEAO.hentPaameldingsListe());
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste_MAL.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
