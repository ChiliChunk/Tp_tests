package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PassagerStresseTest extends PassagerAbstraitTest {
	Autobus sansPlaceAssise;
	@Before
	public void setup() {
		this.p = new PassagerStresse("Monique", 5);
		this.p2 = new PassagerStresse("Gerard", 2);
		this.p3 = new PassagerStresse("Azer", 6);
		this.p4 = new PassagerStresse("qwerty", 3);
		sansPlaceAssise = new Autobus(1,2);

	}

	@Test
	public void testChoixPlaceMontee() {
		//test cas nominal
		assertTrue(p.estDehors());
		try {
			p.monterDans(ab);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue(p.estAssis());
		
		//test cas pas de place assise
		assertTrue(p2.estDehors());
		try {
			p2.monterDans(ab);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue(p2.estDehors());
	}

	@Test
	public void testChoixChangerPlace() {
		assertTrue(p.estDehors()); // le passager p est dans l'autobus ab
		try {
			p.monterDans(ab);
		} catch (UsagerInvalideException e1) {
			e1.printStackTrace();
		}
		assertTrue(ab.getIndArret() == 0);
		try {
			ab.allerArretSuivant();
			ab.allerArretSuivant();
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue(ab.getIndArret() == 2); //5-2=3 => le passager veut etre debout
		assertTrue(p.estDebout());
	}


	@Test
	public void testPassagerStresseStringInt() {
		assertNotNull(p);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(p4);
		
	}

}
