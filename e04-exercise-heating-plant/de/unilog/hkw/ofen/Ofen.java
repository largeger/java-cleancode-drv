package de.unilog.hkw.ofen;

import de.unilog.hkw.global.Brennbar;
import de.unilog.hkw.ofen.TemperaturException;


/**
 * Der Ofen beschreibt das Modell unser Heizkraftwerksanwendung,
 * das heisst, hier ist der Geschaeftsprozess abgebildet,
 * der Ofen wird beladen, Brennelemente werden verbrannt und
 * erhoehen die Temperatur des Ofens. Wird der Ofen zu heiss
 * wird automatisch gekuehlt.
 *
 * Als Programmiertechniken werden benutzt:
 * - Casting der brennbaren Elemente
 * - Garbage Collection der Brennelemente
 * - innere Klasse
 * - packages fuer Rollenverteilung
 * - Exception Handling
 * - Verwendung von User-Exceptions
 *
 * @version 1.2 krg 2.5.2003 (hkw02)
 */
public class Ofen  {

  private int istTemperatur = 20;
  private int sollTemperatur;
  private int kuehlTemperatur = 30;
  private Brennkammer bk = null;

  /**
   * Der Ofen ist lediglich der Behaelter fuer die Brennelemente
   * und die Brennkammer, die Erwaermung von Wasser und
   * Erzeugung des Stroms ueber Turbinen verbleibt als Uebung :-)
   *
   * Die Brennkammer ist jetzt als innere Klasse implementiert, da sie
   * in Wirklichkeit ebenfalls innerer Bestandteil des Ofens ist.
   * Wir koennen mit inneren Klassen die Aggregation/Komposition realisieren.
   */
  public Ofen(int sollTemperatur) {
    this.sollTemperatur  = sollTemperatur;
    //die Brennkammer hat jetzt einen parameterlosen Konstruktor
    bk = new Brennkammer();
  }

  /*
   * Getter und Setter fuer Properties
   */
  public int getIstTemperatur() { return this.istTemperatur; }
  public int getSollTemperatur() { return this.sollTemperatur; }
  public int getKuehlTemperatur() { return this.kuehlTemperatur; }
  public void setSollTemperatur(int i) { this.sollTemperatur = i; }
  public void setKuehlTemperatur(int i) { this.kuehlTemperatur = i; }
  private void setIstTemperatur(int i) { this.istTemperatur = i; }

  /**
   * Diese Methode ist jetzt private, weil nur die Brennkammer
   * die Temperatur des Ofens erhoehen darf
   */
  private void erhoeheTemperatur(int brennwert) {
    setIstTemperatur(this.istTemperatur + brennwert);
  }

  private void kuehlen() {
    setIstTemperatur(istTemperatur - kuehlTemperatur);
  }


  /**
   * In den Ofen koennen beliebige Objekte gegeben werden.
   * Die Elemente, die nicht Brennbar sind fuehren in der
   * ersten Fassung zum Programmabbruch
   *
   * Die Exceptions werden nun abgefangen.
   * Falls die Temperatur in der Brennkammer zu hoch ist
   * wird eine Exception abgefangen und der Ofen wird
   * automatisch gekuehlt
   */
  public void beladen(Object o) {
  	if (o == null) {
  		System.out.println("null-Objekt hat keinen Heizwert");
  	}
  	else {
	    try {
	      bk.verbrennen((Brennbar)o);
	    }
	    catch(ClassCastException cce) {
	    	System.out.println(cce + ": " + o.getClass().getName() + " nicht brennbar");
	    }
	    catch(TemperaturException te) {
	    	System.out.println(te.toString());
	      kuehlen();
	    }
		}
	}


	//=========================================================================
  /**
   * Die Brennkammer als member inner class:
   * Kein Konstruktor mit Referenz auf Ofen mehr noetig
   * Direkter Zugriff auf private Attribute von Ofen oder mit Ofen.this.attr
   */
  private class Brennkammer {

    /** wird bei einer inner class nicht benoetigt
    public Brennkammer(Ofen o) {
      super();
    } // Brennkammer()
    */

    /**
     * Diese Methode nimmt Elemente entgegen, die Brennbar sind
     * zunaechst Holz, dann alle brennbaren Elemente. Die
     * Brennkammer erhoeht die Temperatur des Ofens.
     *
     * Polymorphie:
     * zur Laufzeit wird die richtige brennen()-Methode des Brennelements
     * aufgerufen(Holz, Papier, Gas), da der Ofen lt. Signatur nicht
     * weiss was f�r ein Objekt er bekommt!
     *
     * Gezeigt werden die verschiedenen Moeglichkeiten auf Methoden,
     * Attribute der aeusseren Klasse zuzugreifen, diese koennen sogar
     * private sein!
     */
    public void verbrennen(Brennbar b) throws TemperaturException {
      int heizleistung = b.brennen();
      Ofen.this.erhoeheTemperatur(heizleistung); // Mit Namen der aeusseren Klasse
      System.out.println("Temperatur: ist=" + istTemperatur + ", soll=" + sollTemperatur);

      if (istTemperatur >= sollTemperatur) {
        throw new TemperaturException(istTemperatur);
      }
    }
  } // inner class Brennkammer
	//====================================================================

}
