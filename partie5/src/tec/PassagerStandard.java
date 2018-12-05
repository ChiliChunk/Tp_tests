package tec;

import tec.EtatPassager.Etat;

public class PassagerStandard extends PassagerAbstrait implements Usager , Passager  {
	
	public PassagerStandard(int destination) {
		super(destination);
	}
	
	public PassagerStandard (String nom , int arret) {
		super(nom , arret);
	}

//	@Override
//	public void monterDans(Transport t) throws UsagerInvalideException {
//		if (getEP().getEtat() != Etat.DEHORS) {
//			throw new UsagerInvalideException("Erreur le passager veut monter alors qu'il est deja dans un bus");
//			
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
//			if (estAssis() == false) { // si il n'a pas reussi a avoir de place assise
//				b.demanderPlaceDebout(this);
//			}
//			if (EP.getEtat() != Etat.DEHORS) { // si il a reussi a monter, on l'ajoute dans la liste du bus
//				b.addPassager(this);
//			}
//		}	
//	}
//	
//
//	
//	@Override
//	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException{
//		if (numeroArret >  arret) {
//			throw new UsagerInvalideException("Destination < arretCourant"); // ne sera jamais atteint parce que on test deja cette erreur avant dans l'algo quand le passager monte dans le bus
//		}
//		if (numeroArret ==  arret) {
//			bus.demanderSortie(this);
//		}
//	}

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
