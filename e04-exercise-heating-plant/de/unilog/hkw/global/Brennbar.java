package de.unilog.hkw.global;

/**
 * Skalierbarkeit:
 * Das Interface Brennbar ist die Schnittstille zwischen Ofen-Bauer
 * und Brennelemente-Hersteller, schliesslich soll der Generalarchitekt
 * des Heizkraftwerks verschiedene Oefen und Brennelemte verwenden koennen.
 *
 * @version 2.6.107 krg Brennbare Objekte koennen nach Brennwert sortiert werden.
 */
public interface Brennbar extends Comparable<Brennbar> {
	public int brennen();
	public int getBrennwert();
}
