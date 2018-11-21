package tec;

import java.security.InvalidParameterException;

import tec.EtatPassager.Etat;

public class PassagerStandard implements Usager , Passager {
	private EtatPassager EP;
	private String nom;
	private int arret;
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
	
	public PassagerStandard(String nom , int arret) {
		if (nom.equals("") || arret < 1) {
			throw new InvalidParameterException("Le nom ne doit pas etre vide et l'arret doit etre > 0");
		}
		this.nom = nom;
		this.arret = arret;
		this.EP = new EtatPassager(EtatPassager.Etat.DEHORS);
	}
	
	public PassagerStandard(int destination) {
		this("PassagerStandard" + destination , destination);
	}
	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if (this.getEP().getEtat() != Etat.DEHORS) {
			throw new UsagerInvalideException("Erreur le passager veut monter alors qu'il est deja dans un bus");
			
		}
		Autobus b = null ;
		boolean error = false;
		try{
			b = (Autobus)t; // le cast en autobus est obligé pour connaitre sont arret pour throw exception si destination < arret
		}catch(Exception e) {
			error = true;
			System.out.println("Le transport donné n'est pas un autobus");
		}
		
		if (error == false) { // si le cast s'est bien passé
			if (this.arret < b.getIndArret()) {
				throw new UsagerInvalideException("La destination du passager < arret courant");
			}
			b.demanderPlaceAssise(this);
			if (this.estAssis() == false) { // si il n'a pas reussi a avoir de place assise
				b.demanderPlaceDebout(this);
			}
			if (this.EP.getEtat() != Etat.DEHORS) { // si il a reussi a monter, on l'ajoute dans la liste du bus
				b.addPassager(this);
			}
		}	
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
		if (numeroArret > this.arret) {
			throw new UsagerInvalideException("Destination < arretCourant"); // ne sera jamais atteint parce que on test deja cette erreur avant dans l'algo quand le passager monte dans le bus
		}
		if (numeroArret == this.arret) {
			bus.demanderSortie(this);
		}
	}

}
