

public class FauxPassager { 
  static final byte DEHORS = 0;
  static final byte ASSIS  = 1;
  static final byte DEBOUT = 2;
  byte status = DEHORS;

  String message ="???";

  public String nom() {
    return null;
  }

  boolean estDehors() {
    return status == DEHORS;
  }
  
  boolean estAssis() {
    return status == ASSIS;
  }
  
  boolean estDebout() {
    return status == DEBOUT;
  }

  void accepterSortie() {
    message = ":accepterSortie:";
  }

  void accepterPlaceAssise() {
    message = ":accepterPlaceAssise:";
  }

  void accepterPlaceDebout() {
    message = ":accepterPlaceDebout:";
  }

  void nouvelArret(Bus bus, int numeroArret) {
    message = ":nouvelArret " + numeroArret + ":";
  }

  public void monterDans(Transport t) { // throws UsagerInvalideException {
  }
}
