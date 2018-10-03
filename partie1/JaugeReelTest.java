package partie1;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeReelTest {
	
	private JaugeReel j1 , j2 , j3 , j4 , j5 , j6 , j7 , j8 , j9 , j10;
	
	@Before
	public void setUp() throws Exception {
		j1 = new JaugeReel(10, 100, 11); //verte
		j2 = new JaugeReel(50, 100, 35); // bleu
		j3 = new JaugeReel(0, 50, 60); // rouge
		j4 = new JaugeReel (0,50,0); // departe == min
		j5 = new JaugeReel(10, 50, 8); // depart < min
		j6 = new JaugeReel(50, 40, 45); // max<depart<min
		j7 = new JaugeReel(50, 50, 50); // max = min = depart
		j8 = new JaugeReel(50, 50, 80); // max = min < depart
		j9 = new JaugeReel(10, 40, 50); // min < max < depart
		j10 = new JaugeReel(10, 50, 50); // min < max = depart
	}

	@After
	public void tearDown() throws Exception {
		j1 = null;
		j2 = null;
		j3 = null;
	}

	@Test
	public void testJaugeReel() {
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
	public void testLimiteVigieMaxInferieurVigieMin() {
		assert j6.estBleu() == true : "La jauge doit etre bleue";
		assert j6.estRouge() == true : "La jauge doit etre rouge";
		assert j6.estVert() == false : "La jauge ne doit pas etre verte";
		// l'etat n'est pas coherent mais est autorisé dans ce programme, les tests peuvent donc passer
	}
	
	@Test
	public void testMaxEgaleMin () {
		assert j7.estBleu() == true : "La jauge doit etre bleue";
		assert j7.estRouge() == true : "La jauge doit etre rouge";
		assert j7.estVert() == false : "La jauge ne doit pas etre verte";
		
		assert j8.estBleu() == false : "La jauge ne doit pas etre bleue";
		assert j8.estRouge() == true : "La jauge doit etre rouge";
		assert j8.estVert() == false : "La jauge ne doit pas etre verte";
		
		//cet état est deja plus cohérent mais il faudrit que la jauge soit bleu quand val < min et pas val <= min, comme ça nous pourrions avoir une jauge verte quand max = min = depart
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
