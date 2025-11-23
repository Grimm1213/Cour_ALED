package es.upm.aled.complejidad.comparable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Patient implements Comparable {

	private String name;
	private int ssn;
	
	public Patient(String name, int ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSSN() {
		return ssn;
	}

	public void setSSN(int ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", ssn=" + ssn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, ssn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(name, other.name) && ssn == other.ssn;
	}

	@Override
	// Devuelve >0 si ESTE objeto es mayor que el que me pasan
	// Devuelve 0 si son iguales (en orden)
	// Devuelve <0 si ESTE objeto es menor que el que me pasan
	// Ordenar por SSN
	public int compareTo(Object obj) {
		Patient otroPaciente = (Patient) obj;
		return this.ssn - otroPaciente.getSSN();
	}
	
	public static void main(String[] args) {
		Patient a = new Patient("Ana", 999);
		Patient b = new Patient("Wenceslao", 111);
		Patient[] lista1 = { a, b };
		Arrays.sort(lista1);
		System.out.println("Lista 1: " +
						lista1[0] + ", " + lista1[1]);
		Comparator comp = new ComparatorPatient();
		Arrays.sort(lista1,comp);
		System.out.println("Lista 1: " +
				lista1[0] + ", " + lista1[1]);

	}
}







