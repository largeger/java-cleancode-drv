package de.unilog.hkw.moebel;

import de.unilog.hkw.global.Brennbar;
import de.unilog.hkw.moebel.Moebel;


/**
 * Ein Sofa ist ein Brennbares Moebelstueck, es implementiert
 * daher das Interface global.Brennbar
 *
 * @version 2.6.107 krg hkw03 Sortierbare Brennelemente
 */
public class Sofa extends Moebel implements Brennbar {

	private int brennwert = 10;

  public Sofa(String typ) {
    super(typ);
  }

  public int brennen() {
  	System.out.println(this.typ + " verbrennt");
    return this.brennwert;	//Alle Sofas brennen gut
  }

/*  protected void finalize() throws Throwable {
  	System.out.println("GC: " + this.typ + " aufgeraeumt.");
    super.finalize();
  }*/

  public String toString() {
  	return this.getClass().getSimpleName() + ": typ=" + this.typ
  			+ ", brennwert=" + this.brennwert;
  }

	public int getBrennwert() {
		return this.brennwert;
	}

	public int compareTo(Brennbar other) {
  		return this.brennwert - other.getBrennwert();
	}

}
