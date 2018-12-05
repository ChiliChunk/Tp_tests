package tec;

import tec.EtatPassager.Etat;

public class PassagerStresse extends PassagerAbstrait {

	public PassagerStresse(int destination) {
		super(destination);
	}
	
	public PassagerStresse(String nom , int destination) {
		super(nom , destination);
	}

//	@Override
//	public void monterDans(Transport t) throws UsagerInvalideException {
//		
//		if (getEP().getEtat() != Etat.DEHORS) {
//			throw new UsagerInvalideException("Erreur le passager veut monter alors qu'il est deja dans un bus");
//		}
//		Autobus b = null ;
//		boolean error = false;
//		try{
//			b = (Autobus)t; // le cast en autobus est obligé pour connaitre sont arret pour throw exception si destination < arret
//		}catch(Exception e) {
//			error = true;
//			System.out.println("Le transport donné n'est pas un autobus");
//		}
//		
//		if (error == false) { // si le cast s'est bien passé
//			if ( arret < b.getIndArret()) {
//				throw new UsagerInvalideException("La destination du passager < arret courant");
//			}
//			b.demanderPlaceAssise(this);
//			if (EP.getEtat() == Etat.ASSIS) { // si il a reussi a monter, on l'ajoute dans la liste du bus
//				b.addPassager(this);
//			}
//		}	
//	}
//
//	@Override
//	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException {
//		if (numeroArret >  arret) {
//			throw new UsagerInvalideException("Destination < arretCourant"); // ne sera jamais atteint parce que on test deja cette erreur avant dans l'algo quand le passager monte dans le bus
//		}
//		if (numeroArret ==  arret) {
//			bus.demanderSortie(this);
//		}
//		else if (arret - numeroArret <= 3 && this.getEP().getEtat() != Etat.DEBOUT) {
//			bus.demanderChangerEnDebout(this);
//		}
//	}

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
