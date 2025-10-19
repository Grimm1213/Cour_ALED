package es.upm.aled.complejidad.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import 

public class Patient implements Comparable{
	private String name;
	private int Ssn;
	

	
	public Patient(String name, int ssn) {
		super();
		this.name = name;
		Ssn = ssn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Ssn, name);
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
		return Ssn == other.Ssn && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", Ssn=" + Ssn + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSsn() {
		return Ssn;
	}
	
	public void setSsn(int ssn) {
		Ssn = ssn;
	}
	
	@Override
	//>0 si ESTE obj et mayor
	// 0 si es igual
	//<0 si ESTE obj est menor
	//ordenar por SSN
	public int compareTo(Object o) {
		Patient otroPaciente = (Patient) o;
		return this.Ssn - otroPaciente.getSsn();	
	}
	
	public static void main(String[] args) {
		
		Patient a = new Patient ("Ana",999);
		Patient b = new Patient ("Wenceslao",111);
		Patient[] lista1 = {a,b};
		Arrays.sort(lista1);
		System.out.println(lista1[0]);
		

		
		

	}

	

}
