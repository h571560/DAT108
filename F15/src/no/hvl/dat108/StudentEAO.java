package no.hvl.dat108;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudentEAO {
@PersistenceContext(name= "studentPU")
private EntityManager em;

public List<Student> hentKlasselisteFor(String klassekode){
	return em.find(Klasse.class,klassekode).getStudenter();
}
	
}
