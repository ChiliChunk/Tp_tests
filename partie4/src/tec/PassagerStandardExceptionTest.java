package tec;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerStandardExceptionTest {

	PassagerStandard nomVide , arretLt0;
	PassagerStandard p , p2;
	Transport t , t2;
	
	
	@Before
	public void setUp() {
		t = new Autobus(1, 2);
		p = new PassagerStandard("Test", 3);
		p.setEP(new EtatPassager(Etat.DEBOUT)); // on set un passager avec un etat != DEHORS
		p2 = new PassagerStandard("test", 3);
		
		t2 = new Autobus(1, 2);
		((Autobus)t2).setIndArret(4);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testNom() {
		nomVide = new PassagerStandard("", 5);
//		assertNull(nomVide);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testArret() {
		arretLt0 = new PassagerStandard("Lt0", -2);
//		assertNull(arretLt0);
	}
	
	@Test (expected = UsagerInvalideException.class)
	public void testMonterDansEtat() throws UsagerInvalideException{
		p.monterDans(t);
	}
	
	@Test (expected = UsagerInvalideException.class)
	public void testMonterDansArret() throws UsagerInvalideException{
		p2.monterDans(t2);
	}

}
