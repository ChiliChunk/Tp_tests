package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutobusTest {
	
	private Autobus a;
	
	@Before
	public void setUp(){
		this.a = new Autobus(1, 2);
	}
	
	@Test
	public void testAutobus() {
		assertNotNull(a);
	}

	@Test
	public void testAllerArretSuivant() {
		int currentStop = a.getIndArret();
		try {
			a.allerArretSuivant();
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		int nextStop = a.getIndArret();
		assertEquals(currentStop + 1, nextStop);
		
	}

	@Test
	public void testAPlaceAssise() {
		
		assertEquals(a.aPlaceAssise(), true );
		while (a.getJaugeAssis().estRouge() == false) {
			a.getJaugeAssis().incrementer();
		}
		assertEquals(a.aPlaceAssise(), false);
	}

	@Test
	public void testAPlaceDebout() {
		assertEquals(a.aPlaceDebout(), true );
		while (a.getJaugeDebout().estRouge() == false) {
			a.getJaugeDebout().incrementer();
		}
		assertEquals(a.aPlaceDebout(), false);
	}

	@Test
	public void testDemanderPlaceAssise() {
		a.setJaugeAssis(new JaugeNaturel(0,2,0));
		assertTrue(a.aPlaceAssise());
		a.demanderPlaceAssise(null);
		a.demanderPlaceAssise(null);
		assertFalse(a.aPlaceAssise());
	}

	@Test
	public void testDemanderPlaceDebout() {
		a.setJaugeDebout(new JaugeNaturel(0,2,0));
		assertTrue(a.aPlaceDebout());
		a.demanderPlaceDebout(null);
		a.demanderPlaceDebout(null);
		assertFalse(a.aPlaceDebout());
	}

	@Test
	public void testDemanderChangerEnDebout() {
		a.setJaugeDebout(new JaugeNaturel(0,2,0));
		a.setJaugeAssis(new JaugeNaturel(0,2,0));
		a.demanderPlaceAssise(null);
		a.demanderPlaceAssise(null);
		assertFalse(a.aPlaceAssise());
		assertTrue(a.aPlaceDebout());
		a.demanderChangerEnDebout(null);
		a.demanderChangerEnDebout(null);
		assertFalse(a.aPlaceDebout());
		assertTrue(a.aPlaceAssise());

	}

	@Test
	public void testDemanderChangerEnAssis() {
		a.setJaugeDebout(new JaugeNaturel(0,2,0));
		a.setJaugeAssis(new JaugeNaturel(0,2,0));
		a.demanderPlaceDebout(null);
		a.demanderPlaceDebout(null);
		assertTrue(a.aPlaceAssise());
		assertFalse(a.aPlaceDebout());
		a.demanderChangerEnAssis(null);
		a.demanderChangerEnAssis(null);
		assertTrue(a.aPlaceDebout());
		assertFalse(a.aPlaceAssise());
	}

//	@Test
//	public void testDemanderSortie() { // comment faire si aucune interaction encore avec Passager?
//		fail("Not yet implemented");
//	}

}
