package de.unilog.hkw;


import de.unilog.hkw.ofen.OfenControllerImpl;

public class JMain {

	public static void main(String[] args) {

		System.out.println("HKW Simulation gestartet. Starte OfenController");
		OfenControllerImpl oc = new OfenControllerImpl();
		oc.start();
		//oc.startSorted();
	}

}
