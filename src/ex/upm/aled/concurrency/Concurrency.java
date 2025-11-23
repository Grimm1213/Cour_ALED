package ex.upm.aled.concurrency;

public class Concurrency {

	public static void main(String[] args) {
		Hora h = new Hora();
		h.start();
		Sonido s = new Sonido();
		s.start();
		try {
			// Espero a que termine Sonido
			s.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termino");
	}
}

