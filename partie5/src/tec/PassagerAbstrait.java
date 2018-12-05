package tec;

import java.security.InvalidParameterException;

import tec.EtatPassager.Etat;

public abstract class PassagerAbstrait implements Usager , Passager {
	
	protected EtatPassager EP;
	private String nom;
	protected int arret;
	
	public EtatPassager getEP() {
		return EP;
	}
	public void setEP(EtatPassager eP) {
		EP = eP;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getArret() {
		return arret;
	}
	public void setArret(int arret) {
		this.arret = arret;
	}
	
	public PassagerAbstrait(String nom , int arret) {
		if (nom.equals("") || arret < 1) {
			throw new InvalidParameterException("Le nom ne doit pas etre vide et l'arret doit etre > 0");
		}
		this.nom = nom;
		this.arret = arret;
		this.EP = new EtatPassager(EtatPassager.Etat.DEHORS);
	}
	
	public PassagerAbstrait(int destination) {
		this("PassagerStandard" + destination , destination);
	}
	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException{
		this.choixPlaceMontee((Bus)t);
	}
	

	@Override
		public String toString() {
			return "volonté : " + this.arret + " Nom : " + this.nom + " etat : " + this.EP;
		}
	@Override
	public boolean estDehors() {
		return this.getEP().estExterieur();
	}
	
	@Override
	public boolean estAssis() {
		return this.getEP().estAssis();
	}
	
	@Override
	public boolean estDebout() {
		return this.getEP().estDebout();
	}
	
	@Override
	public void accepterSortie() {
		this.EP = new EtatPassager (Etat.DEHORS);
	}
	
	@Override
	public void accepterPlaceAssise() {
		this.EP = new EtatPassager (Etat.ASSIS);
	}
	
	@Override
	public void accepterPlaceDebout() {
		this.EP = new EtatPassager (Etat.DEBOUT);
	}
	
	@Override
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException{
		if (numeroArret >  arret) {
			throw new UsagerInvalideException("Destination < arretCourant"); // ne sera jamais atteint parce que on test deja cette erreur avant dans l'algo quand le passager monte dans le bus
		}
		if (numeroArret == this.arret) {
			bus.demanderSortie(this);
		}
		else {
			this.choixChangerPlace(bus, numeroArret);
		}
	}
	
	public abstract void choixPlaceMontee( Bus b);
		
	public abstract void choixChangerPlace( Bus b, int arret );


}
