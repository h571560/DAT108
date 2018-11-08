package no.hvl.dat108;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema ="oblig3", name="paamelding")
public class Person {
	
	
	String fornavn;
	String etternavn;
	@Id
	String mobil;
	String passord;
	String kjonn;
	
	public Person() {
		
	}
	
	
	public Person(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}

	@Override
	public String toString() {
		return "Person [fornavn=" + fornavn + ", etternavn=" + etternavn + ", mobil=" + mobil + ", passord=" + passord
				+ ", kjonn=" + kjonn + "]";
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	

	

}