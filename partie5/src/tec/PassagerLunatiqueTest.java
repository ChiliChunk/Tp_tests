package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PassagerLunatiqueTest extends PassagerAbstraitTest{
	
	@Before
	public void setup() {
		this.p = new PassagerLunatique("Monique", 5);
		this.p2 = new PassagerLunatique("Gerard", 2);
		this.p3 = new PassagerLunatique("Azer", 6);
		this.p4 = new PassagerLunatique("qwerty", 3);
	}
	
	@Test
	public void testChoixPlaceMontee() {
		//test cas nominal
		assertTrue(p.estDehors());
		try {
			p.monterDans(autobusUnePlaceDebout);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue(p.estDebout());
		
		//test cas pas de place debout
		assertTrue(p2.estDehors());
		try {
			p2.monterDans(autobusUnePlaceDebout);
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
		assertTrue(p.estDebout());
		assertTrue(ab.getIndArret() == 0);
		try {
			ab.allerArretSuivant();
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue(ab.getIndArret() == 1);
		assertTrue(p.estAssis());
	}

	@Test
	public void testPassagerLunatiqueStringInt() {
		assertNotNull(p);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(p4);
	}

}
