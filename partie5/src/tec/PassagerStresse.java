package tec;

import tec.EtatPassager.Etat;

public class PassagerStresse extends PassagerAbstrait {

	public PassagerStresse(int destination) {
		super(destination);
	}
	
	public PassagerStresse(String nom , int destination) {
		super(nom , destination);
	}

	@Override
	public void choixPlaceMontee(Bus b) {
		b.demanderPlaceAssise(this);
	}

	@Override
	public void choixChangerPlace(Bus b, int arret) {
		if(this.arret - arret <= 3) {
			b.demanderChangerEnDebout(this);
		}
	}

}
