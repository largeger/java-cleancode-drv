package de.unilog.hkw.util;

/**
 * Interface fuer eine ObjectFactory. Es sind zwei create()-Methoden vorgesehen,
 * eine zur Erzeugung von Objekten mit dem parameterlosen Konstruktor,
 * eine mit einem String als Parameter.
 */
public interface ObjectFactory {
  public Object create(String pClassName);
  public Object create(String pClassName, String pParameter);
}
