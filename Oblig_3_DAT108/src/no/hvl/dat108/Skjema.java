package no.hvl.dat108;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class Skjema {

	private String fornavn;
	private String fornavnFeilmelding;
	private String etternavn;
	private String etternavnFeilmelding;
	private String mobil;
	private String mobilFeilmelding;
	private String passord;
	private String passordFeilmelding;
	private String passordRep;
	private String passordRepFeilmelding;
	private String kjonn;
	private String kjonnFeilmelding;
	private String kvinneC;
	private String mannC;
	private final String REGEXNAVN = "([A-ZÆØÅ][A-Za-z æøå-]{1,20})";
	private final String REGEXMOBIL = "[0-9]{8}$";
	private final String REGEXPASSORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
	

	public Skjema(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.fornavnFeilmelding = "";
		this.etternavn = request.getParameter("etternavn");
		this.etternavnFeilmelding = "";
		this.mobil = request.getParameter("mobil");
		this.mobilFeilmelding = "";
		this.passord = request.getParameter("passord");
		this.passordFeilmelding = "";
		this.passordRep = request.getParameter("passordRepetert");
		this.passordRepFeilmelding = "";
		this.kjonn = request.getParameter("kjonn");
		this.kjonnFeilmelding = "";
		this.kvinneC = "";
		this.mannC = "";
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getKvinneC() {
		return kvinneC;
	}

	public void setKvinneC(String kvinneC) {
		this.kvinneC = kvinneC;
	}

	public String getMannC() {
		return mannC;
	}

	public void setMannC(String mannC) {
		this.mannC = mannC;
	}
	/**
	 * tester om alle input boksene er gyldig 
	 * @return
	 */
	public boolean allegyldig() {
		if (this.fornavngyldig() && this.etternavngyldig() && this.mobilgyldig() && this.passordgyldig()
				&& this.passordRepgyldig() && this.kjonngyldig()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * tester om fornavnet matcher det regulære uttrykket: REGEXNAVN
	 * @return true hvis det matcher og false ellers
	 */
	public boolean fornavngyldig() {
		return fornavn.matches(REGEXNAVN);

	}
	/**
	 * tester om etternavnet matcher det regulære uttrykket:REGEXNAVN
	 * @return true hvis det mathcer og false ellers
	 */
	public boolean etternavngyldig() {
		return etternavn.matches(REGEXNAVN);
	}
	/**
	 * tester om mobilnummeret matcher det regulære uttrykket: REGEXMOBIL
	 * @return true hvis det matcher og false ellers
	 */
	public boolean mobilgyldig() {
		return mobil.matches(REGEXMOBIL);
	}
	/**
	 * tester om passordet mathcer det regulære uttrykket: REGEXPASSORD
	 * @return true om det matcher og false ellers
	 */
	public boolean passordgyldig() {
		return passord.matches(REGEXPASSORD);
	}
	 
	/**
	 * opretter en person og kryperer passorde som er laget med passordUtil
	 * @return Person
	 */
	@SuppressWarnings("static-access")
	public Person lagPerson() {
		PassordUtil pass = new PassordUtil();
		passord = pass.krypterPassord(passord);
		return new Person(fornavn, etternavn, mobil, passord, kjonn);
	}
	/**
	 * sjekker hvilke kjonn personen er og setter variablen kvinneC eller mannC til "checked" på bakgrunn av hvilke kjonn personen er
	 * dette brukes i paameldingsskjema.jsp for å lagre hvilke radio brukeren har trykket på.
	 * 
	 */
	public void checker() {

		if (kjonn != null) {
			if (kjonn.equals("kvinne")) {
				kvinneC = "checked";
			} else {
				mannC = "checked";
			}
		}
	}
	/**
	 * sjekker om passorde som repeteres er det samme passorde som er skrevet inn over
	 * @return true om det er likt og false ellers
	 */
	public boolean passordRepgyldig() {
		if (passordRep != null && passord != null) {
			return (passordRep.equals(passord));
		} else {
			return false;
		}
	}
	/**
	 * 
	 * sjekker om det er trykket på en av radio knappene er trykket på 
	 * @return true om det er trykket på no false ellers
	 */
	public boolean kjonngyldig() {
		if (kjonn != null) {
			this.checker();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * går igjennom alle boksene og ser om det er gyldig input, lager feilmeldingsstringer om det er noe feil
	 * tom string om det ikke er noe feil
	 * @param unikNr
	 */
	public void setOppFeilmeldinger(boolean unikNr) {
		if (!fornavngyldig()) {
			fornavn = "";
			fornavnFeilmelding = "Ugyldig fornavn";
		}

		if (!etternavngyldig()) {
			etternavn = "";
			etternavnFeilmelding = "Ugyldig etternavn";
		}
		if (!mobilgyldig()) {
			mobil = "";
			mobilFeilmelding = "Ugyldig mobilnummer";
		}
		if (!passordRepgyldig()) {
			passordRep = "";
			passordRepFeilmelding = "Forskjellig passord";
		}
		if (!passordgyldig()) {
			passord = "";
			passordFeilmelding = "Ugyldig passord";
			passordRep="";
		}
		if (!kjonngyldig()) {
			kjonnFeilmelding = "Vennligst velg kjønn";
		}
		if(!unikNr) {
			mobil = "";
			mobilFeilmelding = "allerede registrert";
		}
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getFornavnFeilmelding() {
		return fornavnFeilmelding;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getEtternavnFeilmelding() {
		return etternavnFeilmelding;
	}

	public String getMobil() {
		return mobil;
	}

	public String getMobilFeilmelding() {
		return mobilFeilmelding;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordFeilmelding() {
		return passordFeilmelding;
	}

	public String getPassordRep() {
		return passordRep;
	}

	public String getPassordRepFeilmelding() {
		return passordRepFeilmelding;
	}

	public String getKjonnFeilmelding() {
		return kjonnFeilmelding;
	}

}
