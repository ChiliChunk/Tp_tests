package tec;

import java.util.ArrayList;

import tec.EtatPassager.Etat;

public class Autobus implements Transport, Bus{
	private JaugeNaturel jaugeDebout;
	private JaugeNaturel jaugeAssis;
	private int indArret;
	private ArrayList<Passager> alPassager;
	private ArrayList<Passager> toRemove;
	
	public ArrayList<Passager> getListPassager(){
		return this.alPassager;
	}
	
	public int getIndArret() {
		return this.indArret;
	}
	
	public void addPassager(Passager p ) {
		if (!this.alPassager.contains(p)) //temp fix => pourquoi demanderPlaceAssise est appelé plusieur fois pas passager? il sont donc ajouté 2 fois...
			this.alPassager.add(p);
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
		this.alPassager = new ArrayList<Passager>();
		this.toRemove = new ArrayList<Passager>();
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		this.indArret ++;
		for (Passager pass : this.alPassager) { // on notifie tout les passagers du nouvel arret
			pass.nouvelArret(this, indArret);
		}
		this.alPassager.removeAll(toRemove); // on les remove tous a la fin pour ne pas changer l'arraylist des passager pdt qu'on la parcours
		this.toRemove.clear();
	}
	
	@Override
	public String toString() {
		return "[ arret : " + this.getIndArret() + " ; assis : " + this.jaugeAssis.getValeur() + " ; debout : " + this.jaugeDebout.getValeur() + " total "+ this.alPassager.size()+ "]";
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
		if (this.aPlaceAssise()) { // il y a de la place

			this.jaugeAssis.incrementer();
			this.addPassager(p);
			p.accepterPlaceAssise();
		}
		
		
	}

	@Override
	public void demanderPlaceDebout(Passager p) {

		if (this.aPlaceDebout()) { // il y a de la place
			this.jaugeDebout.incrementer();
			this.addPassager(p);
			p.accepterPlaceDebout();
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
		this.toRemove.add(p);
		Etat et = null;
		try {
			et = ((PassagerStandard)p).getEP().getEtat();
		}catch (Exception e) {
			System.out.println("On ne peut traiter que des PassagerStandard");
		}
		if (et == Etat.ASSIS) {
			this.jaugeAssis.decrementer();
		}
		else {
			this.jaugeDebout.decrementer();
		}
		p.accepterSortie();
	}
}
