package no.hvl.dat103;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cookie = getCookieFromRequest(request, "hei");

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		addCookieToResponse(response,"hei","cookiecookie");
		
		if(cookie == null) {
		out.println("Velkommen!");
		}
		else {
			out.println("Velkommen tilbake ;)");
			out.println(cookie);
		}
	}

	private void addCookieToResponse(HttpServletResponse response, String navn, String verdi) {
		Cookie c = new Cookie(navn,verdi);
		c.setMaxAge(10);
		response.addCookie(c);
		
	}

	private String getCookieFromRequest(HttpServletRequest request, String navn) {
		if(request.getCookies()==null) {
			return null;
		}
		return Arrays.stream(request.getCookies())
				.filter(c -> c.getName().equals(navn))
				.map(Cookie::getValue)
				.findAny()
				.orElse(null);
	}

}
