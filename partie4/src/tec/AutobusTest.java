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

//	@Test
//	public void testDemanderPlaceAssise() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDemanderPlaceDebout() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDemanderChangerEnDebout() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDemanderChangerEnAssis() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDemanderSortie() {
//		fail("Not yet implemented");
//	}

}
