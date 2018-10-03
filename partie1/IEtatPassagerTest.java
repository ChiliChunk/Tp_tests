package partie1;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IEtatPassagerTest implements IEtatPassager {
	EtatPassager ep1 , ep2 , ep3;
	
	public IEtatPassager creerAssis (etat type) {
		IEtatPassager result = null;
		switch (type) {
		case PASSAGER:
			result = new EtatPassager(EtatPassager.Etat.ASSIS);
			break;
		
		case CHAINE:
			result =new EtatPassagerChaine("ASSIS");
			break;
			
		case MONTER:
			result = new EtatPassagerMonter(EtatPassagerMonter.Etat.ASSIS);
			break;
		default:
			break;
		}
		return result;
	}
	
	public IEtatPassager creerDehors (etat type) {
		IEtatPassager result = null;
		switch (type) {
		case PASSAGER:
			result = new EtatPassager(EtatPassager.Etat.DEHORS);
			break;
		
		case CHAINE:
			result =new EtatPassagerChaine("DEHORS");
			break;
			
		case MONTER:
			result = null;
			break;
		default:
			break;
		}
		return result;
		}
	
	public IEtatPassager creerDebout (etat type) {
		IEtatPassager result = null;
		switch (type) {
		case PASSAGER:
			result = new EtatPassager(EtatPassager.Etat.DEBOUT);
			break;
		
		case CHAINE:
			result = new EtatPassagerChaine("DEBOUT");
			break;
			
		case MONTER:
			result = new EtatPassagerMonter(EtatPassagerMonter.Etat.DEBOUT);
			break;
		default:
			break;
		}
		return result;
	}
	
	@Before
	public void setUp() throws Exception {
		ep1 = new EtatPassager(EtatPassager.Etat.ASSIS);
		ep2 = new EtatPassager(EtatPassager.Etat.DEBOUT);
		ep3 = new EtatPassager(EtatPassager.Etat.DEHORS);
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

	@Override
	public boolean estExterieur() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estAssis() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estDebout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInterieur() {
		// TODO Auto-generated method stub
		return false;
	}

}
