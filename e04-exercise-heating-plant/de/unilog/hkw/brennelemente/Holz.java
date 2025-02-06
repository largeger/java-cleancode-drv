package de.unilog.hkw.brennelemente;


import de.unilog.hkw.global.Brennbar;

/**
 * Das Brennelement Holz besitzt die Methode brennen(), die
 * von der Brennkammer des Ofens aufgerufen wird.
 *
 * @version 2.6.107 krg Sortierbare Brennelemente
 */
public class Holz implements Brennbar {

  /**
   * Anhand vom Holztyp kann der Brennwert definiert werden.
   * Typen sind u.a. "Buche", "Eiche" usw.
   * protected damit die Kinder(z.B. Papier) darauf zugreifen koennen!
   */
  protected String typ;
  protected int brennwert = 1;

  /**
   * Der statische Block wird nur einmal aufgerufen, naemlich
   * beim Laden der Klassendefinition in die JVM.
   * uebertragen: der Heizer geht in den Keller und holt ein
   * Buendel Holz, dann wirft er Scheit fuer Scheit in den Ofen :-)
   */
  static {
    System.out.println("Holz und geladen");
  }

  /**
   * Wir wollen mit Absicht *keinen* Default-Konstruktor, der
   * Compiler fuegt diesen nun auch nicht hinzu, da wir einen
   * speziellen Konstruktor angeben. Fuer die Vererbung (Papier)
   * wird dies eine Rolle spielen.
   */
  public Holz(String typ) {
    this.typ = typ;
    if (typ.startsWith("Bruchholz")) brennwert = 3;
    else if (typ.startsWith("Fichte")) brennwert = 4;
    else if (typ.startsWith("Buche")) brennwert = 5;
    System.out.println("Holz " + typ + " erzeugt, brennwert=" + brennwert);
  }

/*
  public Holz() {
    this("Fichte");
  } // Holz()
*/

  /**
   * Lediglich die Ausgabe, dass das Element verbrannt wird.
   * Eine Verbesserung waere die Rueckgabe des Brennwertes und
   * somit dynamische Erhoehung der Temperatur des Ofens.
   */
  public int brennen() {
  	System.out.println(typ + " verbrennt");
    return brennwert;
  }

  /*protected void finalize() throws Throwable {
  	System.out.println("GC: " + this.typ + " aufger�umt.");
    super.finalize();
  }*/

  public String toString() {
  	return this.getClass().getSimpleName() + ": typ=" + this.typ
  			+ ", brennwert=" + this.brennwert;
  }

  /**
   * @return Returns the brennwert.
   */
  public int getBrennwert() {
  	return brennwert;
  }

  public int compareTo(Brennbar other) {
  		return this.brennwert - other.getBrennwert();
  }

}
