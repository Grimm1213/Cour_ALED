package es.upm.aled.concurencia;

public class Concurrencia {

	public static void main(String[] args) {
		
		
		Reloj r = new Reloj();
		//Start() ejecuta run() y "se desentiende"
		r.start();
		Pitiditos p = new Pitiditos();
		p.start();
	}

}
