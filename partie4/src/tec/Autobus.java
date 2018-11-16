package tec;

public class Autobus implements Transport, Bus{
	private JaugeNaturel jaugeDebout;
	private JaugeNaturel jaugeAssis;
	private int indArret;
	
	public int getIndArret() {
		return this.indArret;
	}
	

	public JaugeNaturel getJaugeDebout() {
		return jaugeDebout;
	}

	public void setJaugeDebout(JaugeNaturel jaugeDebout) {
		this.jaugeDebout = jaugeDebout;
	}

	public JaugeNaturel getJaugeAssis() {
		return jaugeAssis;
	}

	public void setJaugeAssis(JaugeNaturel jaugeAssis) {
		this.jaugeAssis = jaugeAssis;
	}

	public void setIndArret(int indArret) {
		this.indArret = indArret;
	}
	
	public Autobus(int assise , int debout) {
		this.jaugeAssis = new JaugeNaturel(0, assise, 0);
		this.jaugeDebout = new JaugeNaturel(0, debout, 0);
		this.indArret = 0;
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		this.indArret ++;
	}
	
	@Override
	public String toString() {
		return "[ arret : " + this.getIndArret() + " ; assis : " + this.jaugeAssis.getValeur() + " ; debout : " + this.jaugeDebout.getValeur() + "]";
	}

	@Override
	public boolean aPlaceAssise() {
		return this.jaugeAssis.estVert() || this.jaugeAssis.estBleu();
	}

	@Override
	public boolean aPlaceDebout() {
		return this.jaugeDebout.estVert() || this.jaugeDebout.estBleu();
	}


	@Override
	public void demanderPlaceAssise(Passager p) {
		if (this.jaugeAssis.estBleu() || this.jaugeAssis.estVert()) { // il y a de la place
			this.jaugeAssis.incrementer();
		}
		
		// rajouter interaction avec p
		
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		if (this.jaugeDebout.estBleu() || this.jaugeDebout.estVert()) { // il y a de la place
			this.jaugeDebout.incrementer();
		}
		
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		if (this.jaugeDebout.estBleu() || this.jaugeDebout.estVert()) { // il y a de la place
			this.jaugeDebout.incrementer();
			this.jaugeAssis.decrementer();
		}		
		
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		if (this.jaugeAssis.estBleu() || this.jaugeAssis.estVert()) { // il y a de la place
			this.jaugeAssis.incrementer();
			this.jaugeDebout.decrementer();
		}				
	}

	@Override
	public void demanderSortie(Passager p) {
		// TODO Auto-generated method stub
		
	}
}
