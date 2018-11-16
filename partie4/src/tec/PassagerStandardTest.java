package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerStandardTest {
		
	private PassagerStandard p;
	
	@Before
	public void setUp () {
		this.p = new PassagerStandard("Monique", 5);
	}
	
	@Test
	public void testPassagerStandard () {
		
	}
	
	@Test
	public void estExterieurALaCreation() {
		assertTrue(this.p.getEP().estExterieur()); // des qu'on créé une personne elle est considérée comme a l'exterieur
	}

	@Test
	public void testNom() {
		assertTrue(this.p.getNom() == "Monique");
	}

	@Test
	public void testMonterDans() {
		try {
			p.monterDans(null);
		} catch (UsagerInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(this.p.getEP().estAssis() || this.p.getEP().estDebout());
	}

	@Test
	public void testEstDehors() {
		p.setEP(new EtatPassager(Etat.DEHORS));
		assertTrue(p.estDehors());
		p.setEP(new EtatPassager(Etat.DEBOUT));
		assertFalse(p.estDehors());
		p.setEP(new EtatPassager(Etat.ASSIS));
		assertFalse(p.estDehors());
	}

	@Test
	public void testEstAssis() {
		p.setEP(new EtatPassager(Etat.DEHORS));
		assertFalse(p.estAssis());
		p.setEP(new EtatPassager(Etat.DEBOUT));
		assertFalse(p.estAssis());
		p.setEP(new EtatPassager(Etat.ASSIS));
		assertTrue(p.estAssis());
	}

	@Test
	public void testEstDebout() {
		p.setEP(new EtatPassager(Etat.DEHORS));
		assertFalse(p.estDebout());
		p.setEP(new EtatPassager(Etat.DEBOUT));
		assertTrue(p.estDebout());
		p.setEP(new EtatPassager(Etat.ASSIS));
		assertFalse(p.estDebout());
	}

	@Test
	public void testAccepterSortie() {
		p.accepterSortie();
		assertTrue(p.estDehors()); // j'utilise .estDehors parce que je pars du principe que cette methode fonctionne parce qu'lle a été testée
	}

	@Test
	public void testAccepterPlaceAssise() {
		p.accepterPlaceAssise();
		assertTrue(p.estAssis());
	}

	@Test
	public void testAccepterPlaceDebout() {
		p.accepterPlaceDebout();
		assertTrue(p.estDebout());
	}

	@Test
	public void testNouvelArret() {
		p.setEP(new EtatPassager(Etat.DEBOUT)); // on part du principe que le passager est deja dans un bus
		p.nouvelArret(null, 2);
		assertFalse(p.estDehors());
		p.nouvelArret(null, 5);
		assertTrue(p.estDehors());
	}

}
