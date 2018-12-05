package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerAbstraitTest {
	
	public PassagerAbstrait p , p2 , p3 , p4;
	Autobus testAutoBus , ab, autobusUnePlaceDebout;
	@Before
	public void setUp () {
		testAutoBus = new Autobus(1, 2);
		autobusUnePlaceDebout = new Autobus(1,1);
		ab = new Autobus(1, 2);
	}

	@Test
	public void testPassagerStandard () {
		assertNotNull(p);
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
		p.setEP(new EtatPassager(Etat.DEBOUT)); //je set un etat dedans
		p.accepterSortie();
		assertTrue(p.estDehors()); // j'utilise .estDehors parce que je pars du principe que cette methode fonctionne parce qu'lle a été testée
	}

	@Test
	public void testAccepterPlaceAssise() {
		p.setEP(new EtatPassager(Etat.DEBOUT)); //je set un etat != ASSIS
		p.accepterPlaceAssise();
		assertTrue(p.estAssis());
	}

	@Test
	public void testAccepterPlaceDebout() {
		p.setEP(new EtatPassager(Etat.ASSIS)); //je set un etat != DEBOUT
		p.accepterPlaceDebout();
		assertTrue(p.estDebout());
	}
	

//	@Test
//	public void testChoixPlaceMontee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testChoixChangerPlace() {
//		fail("Not yet implemented");
//	}

}
