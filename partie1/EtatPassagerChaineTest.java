package partie1;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EtatPassagerChaineTest {
	EtatPassagerChaine ep1 , ep2 , ep3;

	@Before
	public void setUp() throws Exception {
		ep1 = new EtatPassagerChaine("ASSIS");
		ep2 = new EtatPassagerChaine("DEBOUT");
		ep3 = new EtatPassagerChaine("DEHORS");
	}

	@After
	public void tearDown() throws Exception {
		ep1 = null;
		ep2 = null;
		ep3 = null;
	}

	@Test
	public void testEtatPassager() {
		assertNotNull("Objet bien créé" , ep1);
		assertNotNull("Objet bien créé" , ep2);
		assertNotNull("Objet bien créé" , ep3);
	}

	@Test
	public void testEstExterieur() {
		assertTrue("La personne doit etre dehors" , ep3.estExterieur());
	}

	@Test
	public void testEstAssis() {
		assertTrue("La personne doit etre assise" , ep1.estAssis());
	}

	@Test
	public void testEstDebout() {
		assertTrue("La personne doit etre debout" , ep2.estDebout());
	}

	@Test
	public void testEstInterieur() {
		assertTrue("Personne assise ou debout", ep1.estAssis() || ep1.estDebout());
		assertTrue("Personne assise ou debout", ep2.estAssis() || ep2.estDebout());

	}

	@Test
	public void testToString() {
		assertEquals("la string attendue est <ASSIS>", "<ASSIS>", ep1.toString());
		assertEquals("la string attendue est <DEBOUT>", "<DEBOUT>", ep2.toString());
		assertEquals("la string attendue est <DEHORS>", "<DEHORS>", ep3.toString());
	}

}
