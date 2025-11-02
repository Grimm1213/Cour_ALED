package es.upm.aled.tareas;

import java.util.concurrent.Callable;

//Va ser una tarea que ejecuta un thread
public class MCD implements Callable<Integer> {

	
	private int num1;
	private int num2;
	
	
	
	public MCD(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}



	@Override
	// call() devuelve aglo
	public Integer call() throws Exception {
		//Calculo el MCD
		
		int resto = num1%num2;
		
		while(resto!=0) {
		
			int nuevoResto = num2%resto;
			num2 = resto;
			resto = nuevoResto;
		}
		return num2;
	}
	

}
