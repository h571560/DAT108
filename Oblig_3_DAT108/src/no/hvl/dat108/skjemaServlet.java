package no.hvl.dat108;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class skjemaServlet
 */
@WebServlet("/skjemaServlet")
public class skjemaServlet extends HttpServlet {
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
		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema_MAL.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bruker = request.getParameter("mobil");
		
		HttpSession sesjon = request.getSession(false);
		if(sesjon != null) {
			sesjon.invalidate();
		}
		
		sesjon = request.getSession(true);
		request.getSession().setAttribute("mobilnr",bruker);
		
		String mobil = request.getParameter("mobil");
		
		List<Person> deltagerListe = personEAO.hentPaameldingsListe();
		

		Skjema skjema = new Skjema(request); // kunnne v�rt en egen metode, men denne sjekker om mobilnummeret allerede 
		boolean unikNr = true;				// eksisterer i databasen, og gj�r s� det unikNr blir false om det fins fra f�r
		if(skjema.allegyldig()) {			// som igjen gj�r at det ikke blir mulig � legge det til i databasen og buker f�r opp en feilmelding
			for(Person p: deltagerListe) {
				if(mobil.equals(p.getMobil())) {
					unikNr = false;
				}
			}
		}

		if (skjema.allegyldig() && unikNr) {
			
			Person person = skjema.lagPerson();
			synchronized(personEAO) {
			personEAO.leggTil(person);
			}

			request.getSession().setAttribute("fornavn", skjema.getFornavn());
			request.getSession().setAttribute("etternavn", skjema.getEtternavn());
			request.getSession().setAttribute("mobil", skjema.getMobil());
			request.getSession().setAttribute("kjonn", skjema.getKjonn());
			request.getSession().removeAttribute("skjema");
			response.sendRedirect("paameldingServlet");

		} else {
			skjema.setOppFeilmeldinger(unikNr);
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("skjemaServlet");
		}
	}

}
