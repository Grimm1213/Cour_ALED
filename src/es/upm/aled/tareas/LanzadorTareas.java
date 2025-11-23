package es.upm.aled.tareas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LanzadorTareas {

	public static void main(String[] args) {
		try {
		//Creo el servicio de ejecucion de thread--> programa que se oferece hacer une tarea precisa para mi
		int cores = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(cores);
		
		//Crear tareas
		Callable<Integer> tarea1 = new MCD(1500,4000);
		//Envia las tareas al servicio de ejecucion
		
		Future<Integer> resultadoFuturo = executor.submit(tarea1);
		//Este codigo NO SE BLOQUEA hasta que termine la tarea
		System.out.println("Hey");
	
		//Esperar a que termina las tareas
		//Este codigo SE BLOQUEA hasta que termine la tarea
		
			int resultado = resultadoFuturo.get();
			System.out.println("Hey");
			System.out.println(resultado);
		} catch (InterruptedException  | ExecutionException e) {
			// TODO Auto-generated catch block
		}
		
	}

}
