package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonEAO {

	@PersistenceContext(name = "PersonPU")
	private EntityManager em;
	
	/**
	 * 
	 * lager en Liste med Person Objekter av data som er i databasen
	 * @return  Liste som inneholder Person Objekter
	 */
	@SuppressWarnings("unchecked")
	public List<Person> hentPaameldingsListe() {
		return em.createQuery("SELECT p FROM Person p ORDER BY p.fornavn, p.etternavn ASC").getResultList();
	}
	/**
	 * sender et Person Objekt til databasen og gj�r den om til data i Person tabellen
	 * @param p Person objekt
	 */
	public void leggTil(Person p) {
		em.persist(p);

	}

}
