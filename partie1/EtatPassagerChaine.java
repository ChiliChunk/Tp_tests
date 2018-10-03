package partie1;

/**
 * Cette classe représente l'état d'un passager dans un transport.
 * Il y a un état à l'exterieur du transport (dehors) et deux états à 
 * l'intérieur (assis, debout).
 *  
 * Les instances de cette classe sont des objets constants.
 **/
public class EtatPassagerChaine implements IEtatPassager{
  /**
   * Définit les trois états possible d'un passager dans un transport.
   */
  String monEtat;

  /**
   * Construit une instance en précisant l'état du passager.
   * 
   * @param e  valeur de l'état.
   */
  public EtatPassagerChaine(String e) {
    monEtat = e;

    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  /**
   * Le passager est-il à l'extérieur du transport ?
   *
   * @return vrai si instanciation avec DEHORS;
   */
  public boolean estExterieur() {
    return (this.monEtat.equals("DEHORS"));
  }

  /**
   * Le passager est-il assis à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
    return monEtat.equals("ASSIS");
  }

  /**
   * Le passager est-il debout à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
	  return monEtat.equals("DEBOUT");
  }

  /**
   * Le passager est-il a l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
    return (monEtat.equals("ASSIS") || monEtat.equals("DEBOUT"));
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
}