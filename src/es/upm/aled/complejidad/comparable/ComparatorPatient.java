package es.upm.aled.complejidad.comparable;

import java.util.Comparator;

public class ComparatorPatient implements Comparator {

	@Override
	// Devuelve >0 si objeto1 es mayor que objeto2
	// Devuelve 0 si son iguales (en orden)
	// Devuelve <0 si objecto1 es menor que objeto2
	// Ordenar por name
	public int compare(Object arg0, Object arg1) {
		Patient p1 = (Patient) arg0;
		Patient p2 = (Patient) arg1;
		return p1.getName().compareTo(p2.getName());
	}

}
