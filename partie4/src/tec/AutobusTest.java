package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutobusTest {
	
	private Autobus a, a2;
	private Passager p , p2;
	private Usager u , u2;
	@Before
	public void setUp(){
		this.a = new Autobus(1, 2);
		this.a2 = new Autobus(1, 1);
		
		p = new PassagerStandard("Temp", 5);
		p2 = new PassagerStandard("Temp2", 4);
		
		u= new PassagerStandard("Temp", 1);
		u2 = new PassagerStandard("Temp2", 2);
		
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
		Passager p = new PassagerStandard("Temp", 5);
		Passager p2 = new PassagerStandard("Temp2", 4);
		a.setJaugeAssis(new JaugeNaturel(0,2,0));
		assertTrue(a.aPlaceAssise());
		a.demanderPlaceAssise(p);
		a.demanderPlaceAssise(p2);
		assertFalse(a.aPlaceAssise());
		assertTrue(p.estAssis());
		assertTrue(p2.estAssis());
	}

	@Test
	public void testDemanderPlaceDebout() {
		p = new PassagerStandard("Temp", 5);
		p2 = new PassagerStandard("Temp2", 4);
		a.setJaugeDebout(new JaugeNaturel(0,2,0));
		assertTrue(a.aPlaceDebout());
		a.demanderPlaceDebout(p);
		a.demanderPlaceDebout(p2);
		assertFalse(a.aPlaceDebout());
		assertTrue(p.estDebout());
		assertTrue(p2.estDebout());
	}

	@Test
	public void testDemanderChangerEnDebout() {
		p = new PassagerStandard("Temp", 5);
		p2 = new PassagerStandard("Temp2", 4);
		a.setJaugeDebout(new JaugeNaturel(0,2,0));
		a.setJaugeAssis(new JaugeNaturel(0,2,0));
		a.demanderPlaceAssise(p);
		a.demanderPlaceAssise(p2);
		assertTrue(p.estAssis());
		assertTrue(p2.estAssis());
		assertFalse(a.aPlaceAssise());
		assertTrue(a.aPlaceDebout());
		a.demanderChangerEnDebout(p);
		a.demanderChangerEnDebout(p2);
		assertFalse(a.aPlaceDebout());
		assertTrue(a.aPlaceAssise());
		assertTrue(p.estDebout());
		assertTrue(p2.estDebout());

	}

	@Test
	public void testDemanderChangerEnAssis() {
		p = new PassagerStandard("Temp", 5);
		p2 = new PassagerStandard("Temp2", 4);
		a.setJaugeDebout(new JaugeNaturel(0,2,0));
		a.setJaugeAssis(new JaugeNaturel(0,2,0));
		a.demanderPlaceDebout(p);
		a.demanderPlaceDebout(p2);
		assertTrue(p.estDebout());
		assertTrue(p2.estDebout());
		assertTrue(a.aPlaceAssise());
		assertFalse(a.aPlaceDebout());
		a.demanderChangerEnAssis(p);
		a.demanderChangerEnAssis(p2);
		assertTrue(a.aPlaceDebout());
		assertFalse(a.aPlaceAssise());
		assertTrue(p.estAssis());
		assertTrue(p2.estAssis());
	}

	@Test
	public void testDemanderSortie() { // comment faire si aucune interaction encore avec Passager?
		
		try {
			u.monterDans(a2);
			u2.monterDans(a2);
		} catch (UsagerInvalideException e) {
			System.out.print("Erreur quand l'uager monte dans l'autobus");
		}
		assertTrue(((PassagerStandard)u).estAssis());
		assertTrue(((PassagerStandard)u2).estDebout());
		a2.demanderSortie((Passager)u);
		assertTrue(((PassagerStandard)u).estDehors());
		a2.demanderSortie((Passager)u2);
		assertTrue(((PassagerStandard)u2).estDehors());		
	}

}
