package tec;

import tec.EtatPassager.Etat;

public class PassagerStandard extends PassagerAbstrait implements Usager , Passager  {
	
	public PassagerStandard(int destination) {
		super(destination);
	}
	
	public PassagerStandard (String nom , int arret) {
		super(nom , arret);
	}


	@Override
	public void choixPlaceMontee(Bus b) {
		b.demanderPlaceAssise(this);
		if(this.getEP().getEtat() != Etat.ASSIS) {
			b.demanderPlaceDebout(this);
		}
	}

	@Override
	public void choixChangerPlace(Bus b, int arret) {
		
	}

}
