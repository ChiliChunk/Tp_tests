package partie2;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeTest {
	
	public enum type {REEL , NEGATIF , NATUREL , DISTANCE}; // type des jauge
	
	public Jauge creerJauge (type t , int min , int max , int depart) {
		Jauge result;
		switch (t) {
		case REEL:
			result = new JaugeReel(min, max, depart);
			break;
		
		case NEGATIF:
			result = new JaugeNegatif(min, max, depart);
			break;
			
		case NATUREL:
			result = new JaugeNaturel(min, max, depart);
			break;
			
		case DISTANCE:
			result = new JaugeDistance(min, max, depart);
			break;
			
		default:
			result = null;
			break;
		}
		return result;
	}
	
	public Jauge creerJauge ( int min , int max , int depart) { // pour la question du cours
		return new JaugeNaturel(min, max, depart);
	}
	
	private JaugeNaturel j1 , j2 , j3 , j4 , j5 , j6 , j7 , j8 , j9 , j10;
	
	@Before
	public void setUp() throws Exception {
		j1 = new JaugeNaturel(10, 100, 11); //verte
		j2 = new JaugeNaturel(50, 100, 35); // bleu
		j3 = new JaugeNaturel(0, 50, 60); // rouge
		j4 = new JaugeNaturel (0,50,0); // departe == min
		j5 = new JaugeNaturel(10, 50, 8); // depart < min
		j6 = new JaugeNaturel(50, 40, 45); // max<depart<min
		j7 = new JaugeNaturel(50, 50, 50); // max = min = depart
		j8 = new JaugeNaturel(50, 50, 80); // max = min < depart
		j9 = new JaugeNaturel(10, 40, 50); // min < max < depart
		j10 = new JaugeNaturel(10, 50, 50); // min < max = depart
	}
	
	@After
	public void tearDown() throws Exception {
		j1 = null;
		j2 = null;
		j3 = null;
	}

	@Test
	public void testJaugeNaturel() {
		assertNotNull("Ma jauge a bien ete creee" , j1);
	}

	@Test
	public void testEstRouge() {
		assertTrue("ma jauge est rouge" , j3.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue("ma jauge est verte" , j1.estVert());
	}

	@Test
	public void testEstBleu() {
		assertTrue("ma jauge est verte" , j2.estBleu());
	}
	
	@Test
	public void testDansIntervalle () {
		assert j1.estVert() == true : "La jauge doit etre verte";
		assert j1.estRouge() == false : "La jauge doit etre verte";
		assert j1.estBleu()== false : "La jauge doit etre verte";
		
//		assert j2.estVert() == false : "La jauge doit etre bleue";
//		assert j2.estRouge() == false : "La jauge doit etre bleue";
//		assert j2.estBleu()== true : "La jauge doit etre bleue";
//		
//		assert j3.estVert() == false : "La jauge doit etre rouge";
//		assert j3.estRouge() == true : "La jauge doit etre rouge";
//		assert j3.estBleu()== false : "La jauge doit etre rouge";
//		
	}
	
	@Test
	 public void testDeplacement ( ) {
		j1.decrementer();
		assert j1.estVert() == false : "La jauge doit etre bleu";
		assert j1.estRouge() == false : "La jauge doit etre bleu";
		assert j1.estBleu()== true : "La jauge doit etre bleu";
	
		j1.incrementer();
		assert j1.estVert() == true : "La jauge doit etre verte";
		assert j1.estRouge() == false : "La jauge doit etre verte";
		assert j1.estBleu()== false : "La jauge doit etre verte";
	
	}
	
	@Test
	public void testInferieurInterval() {
		assert j4.estVert() == false : "La jauge doit etre bleu";
		assert j4.estRouge() == false : "La jauge doit etre bleu";
		assert j4.estBleu()== true : "La jauge doit etre bleu";
		
		assert j5.estVert() == false : "La jauge doit etre bleu";
		assert j5.estRouge() == false : "La jauge doit etre bleu";
		assert j5.estBleu()== true : "La jauge doit etre bleu";
	}
	
	@Test
	private void testCreationNonValide ( ) { 
		Jauge inverse = creerJauge ( 78 , 13 , 0 ) ;
		Jauge egale = creerJauge ( -45 , -45, -45); 
	}
	
	@Test
	public void testSuperieurIntervalle() {
		assert j9.estBleu() == false : "La jauge doit etre rouge";
		assert j9.estRouge() == true : "La jauge doit etre rouge";
		assert j9.estVert() == false : "La jauge doit etre rouge";
		
		assert j10.estBleu() == false : "La jauge doit etre rouge";
		assert j10.estRouge() == true : "La jauge doit etre rouge";
		assert j10.estVert() == false : "La jauge doit etre rouge";
	}
	
}
