package tec;

import java.util.Random;

import tec.EtatPassager.Etat;

public class PassagerStandard implements Usager {
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
		this.nom = nom;
		this.arret = arret;
		this.EP = new EtatPassager(EtatPassager.Etat.DEHORS);
	}
	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		Random rand = new Random();
		int  n = rand.nextInt(2) + 1;
		if(n == 1) {
			this.EP = new EtatPassager(Etat.DEBOUT);
		}
		else {
			this.EP = new EtatPassager(Etat.ASSIS); 
		}
	}
	

	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}

}
