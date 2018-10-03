package partie1;

public interface IEtatPassager {
	
	public enum etat {PASSAGER , CHAINE , MONTER};
	
	public boolean estExterieur();
	public boolean estAssis();
	public boolean estDebout();
	public boolean estInterieur();
	
}
