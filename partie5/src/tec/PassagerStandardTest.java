package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerStandardTest extends PassagerAbstraitTest{
	
	@Before
	void setup(){
		this.p = new PassagerStandard("Monique", 5);
		this.p2 = new PassagerStandard("Gerard", 2);
		this.p3 = new PassagerStandard("Azer", 6);
		this.p4 = new PassagerStandard("qwerty", 3);
	}
	
	@Test
	public void testMonterDans() {
		
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
	public void testNouvelArret() {
		
		p.setEP(new EtatPassager(Etat.DEBOUT)); // on part du principe que le passager est deja dans un bus
		try {
			p.nouvelArret(ab, 2);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertFalse(p.estDehors());
		try {
			p.nouvelArret(ab, 5);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue(p.estDehors());
	}

}
