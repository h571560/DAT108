package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KlasseListeServlet
 */
@WebServlet("/KlasseListeServlet")
public class KlasseListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private StudentEAO studentEAO;
	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
  			throws ServletException, IOException {
		
  		String kode = request.getParameter("kode");
  		
  		List<Student> klasseListe = studentEAO.hentKlasselisteFor(kode);
  		
  		response.setContentType("text/plain");
  		PrintWriter out = response.getWriter();
  		
  		klasseListe.forEach(out::println);
	}

}
