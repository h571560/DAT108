package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class logIn {

	private String loginFeil;
	private String loginP;
	private String loginB;

	public logIn(HttpServletRequest request) {
		this.loginFeil = "";
		this.loginB = request.getParameter("mobil");
		this.loginP = request.getParameter("passord");
	}
	/**
	 * lager feilmeldingsstringen for inloggingsfeltene
	 */
	public void setOppFeilLogin() {
		loginP = "";
		loginB = "";
		loginFeil = "ugyldig brukernavn og/eller passord";

	}

	public String getLoginFeil() {
		return loginFeil;
	}

	public String getLoginP() {
		return loginP;
	}

	public String getLoginB() {
		return loginB;
	}

}
