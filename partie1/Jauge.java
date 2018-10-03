package partie1;

public interface Jauge {
	
	public enum type {REEL , NEGATIF , NATUREL , DISTANCE}; // type des jauge

	
	public boolean estRouge();
	public boolean estVert();
	public boolean estBleu();
	public void incrementer();
	public void decrementer();
	
}
