package tec;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import tec.EtatPassager.Etat;

public class Autobus implements Transport, Bus{
	private JaugeNaturel jaugeDebout;
	private JaugeNaturel jaugeAssis;
	private int indArret;
	private ArrayList<Passager> alPassager;
	private ArrayList<Passager> toRemove;
	private int max;
	
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
		if (assise < 0 || debout < 0) {
			throw new InvalidParameterException("Les nombres de places assises et debout ne doivent pas etre < 0");
		}
		this.jaugeAssis = new JaugeNaturel(0, assise, 0);
		this.jaugeDebout = new JaugeNaturel(0, debout, 0);
		this.indArret = 0;
		this.alPassager = new ArrayList<Passager>();
		this.toRemove = new ArrayList<Passager>();
		this.max = 50; 
	}
	
	public Autobus(int nbPlace) {
		this(nbPlace , nbPlace);
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		this.indArret ++;
		if (indArret > this.max ) { // implementation si par la suite nous voulons ajouter un arret supp a 50
			throw new UsagerInvalideException("Arret max atteint");
		}
		
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
			p.accepterPlaceDebout();
		}		
		
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		if (this.jaugeAssis.estBleu() || this.jaugeAssis.estVert()) { // il y a de la place
			this.jaugeAssis.incrementer();
			this.jaugeDebout.decrementer();
			p.accepterPlaceAssise();
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
