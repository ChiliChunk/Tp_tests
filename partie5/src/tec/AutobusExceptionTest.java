package tec;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

public class AutobusExceptionTest {

	Autobus assisLt0 , deboutLt0 , a1 , a2;
	
	@Before
	public void setUp () {
		a1 = new Autobus(1, 2);
		a1.setIndArret(50);
		
		a2 = new Autobus(1, 2);
		a2.getListPassager().add(new PassagerStandard("AjouteEnDur", 3));
		a2.setIndArret(4);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testAssis() {
		assisLt0 = new Autobus(-2, 5);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testDebout() {
		deboutLt0 = new Autobus(5, -3);
	}
	
	@Test  (expected = UsagerInvalideException.class)
	public void testAllerArretSuivantMax() throws UsagerInvalideException {
		a1.allerArretSuivant();
	}
	
	@Test  (expected = UsagerInvalideException.class)
	public void testAllerArretSuivantDestinationArret() throws UsagerInvalideException {
		a2.allerArretSuivant();
	}

}
