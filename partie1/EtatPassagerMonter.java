package partie1;

/**
 * Cette classe représente l'état d'un passager dans un transport.
 * Il y a un état à l'exterieur du transport (dehors) et deux états à 
 * l'intérieur (assis, debout).
 *  
 * Les instances de cette classe sont des objets constants.
 **/
public class EtatPassagerMonter implements IEtatPassager{
  /**
   * Définit les trois états possible d'un passager dans un transport.
   */
  public enum Etat {/** passager assis à l'intérieur */  ASSIS, 
                    /** passager debout à l'intérieur */ DEBOUT
                            };

  private final Etat monEtat;

  /**
   * Construit une instance en précisant l'état du passager.
   * 
   * @param e  valeur de l'état.
   */
  public EtatPassagerMonter(Etat e) {
    monEtat = e;

    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  /**
   * Le passager est-il assis à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
    return monEtat == Etat.ASSIS;
  }

  /**
   * Le passager est-il debout à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
	  return monEtat == Etat.DEBOUT;
  }

  /**
   * Le passager est-il a l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
    return (monEtat == Etat.ASSIS || monEtat == Etat.DEBOUT);
  }



  /**
   * Cette méthode est heritée de la classe {@link java.lang.Object}.
   * Trés utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * <p> Un code par défaut est définit dans 
   * {@link java.lang.Object#toString() la classe Object} 
   * Il faut adapter (redéfinir) le code de cette méthode à chaque classe.
   *
   * Pour les chaînes de cararctéres, l'opérateur + correspond a la concaténation. 
   */
  @Override
  public String toString() {
    return "<" + monEtat + ">";
  }


@Override
public boolean estExterieur() {
	// TODO Auto-generated method stub
	return false;
}
}