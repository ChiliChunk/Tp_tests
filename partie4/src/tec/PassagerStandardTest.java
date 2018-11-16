package tec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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

}
