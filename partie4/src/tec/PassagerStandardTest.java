package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerStandardTest {
		
	private PassagerStandard p , p2 , p3 , p4;
	
	@Before
	public void setUp () {
		this.p = new PassagerStandard("Monique", 5);
		this.p2 = new PassagerStandard("Gerard", 2);
		this.p3 = new PassagerStandard("Azer", 6);
		this.p4 = new PassagerStandard("qwerty", 3);
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
	public void testMonterDans() {
		Autobus testAutoBus = new Autobus(1, 2);
		try {
			p.monterDans(testAutoBus);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue(this.p.getEP().estAssis()); 
		assertNotNull(testAutoBus);
		assertNotNull(testAutoBus.getListPassager().get(0));
		assertEquals(1,	testAutoBus.getJaugeAssis().getValeur());
		assertEquals(0, testAutoBus.getJaugeDebout().getValeur());
		assertEquals(1 ,testAutoBus.getListPassager().size());
		
		try {
			p2.monterDans(testAutoBus);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		
		assertEquals(1,	testAutoBus.getJaugeAssis().getValeur());
		assertEquals(1, testAutoBus.getJaugeDebout().getValeur());
		assertEquals(2,testAutoBus.getListPassager().size());
		
		try {
			p3.monterDans(testAutoBus);
			p4.monterDans(testAutoBus);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		
		assertEquals(3,testAutoBus.getListPassager().size());
		assertTrue(p4.estDehors());
		
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
//	public void testNouvelArret() {
//		Autobus ab = new Autobus(1, 2);
//		p.setEP(new EtatPassager(Etat.DEBOUT)); // on part du principe que le passager est deja dans un bus
//		p.nouvelArret(null, 2);
//		assertFalse(p.estDehors());
//		p.nouvelArret(null, 5);
//		assertTrue(p.estDehors());
//	}

}
