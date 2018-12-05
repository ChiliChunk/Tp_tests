package tec;

import tec.EtatPassager.Etat;

public class PassagerLunatique extends PassagerAbstrait{

	public PassagerLunatique(int destination) {
		super(destination);
	}
	
	public PassagerLunatique (String nom , int destination) {
		super (nom , destination);
	}

	@Override
	public void choixPlaceMontee(Bus b) {
		b.demanderPlaceDebout(this);
	}

	@Override
	public void choixChangerPlace(Bus b, int arret) {
		if (this.getEP().getEtat() != Etat.DEHORS) {
			if(this.getEP().getEtat() == Etat.ASSIS) {
				b.demanderChangerEnDebout(this);
			}
			else {
				b.demanderChangerEnAssis(this);
			}
		}
		
	}

}
