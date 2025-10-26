package es.upm.aled.concurencia;

import java.time.LocalDateTime;

public class Reloj extends Thread{
	
	@Override
	public void run() {
		try {
				while (true) {
				sleep(1000);
				System.out.println(LocalDateTime.now().toString());
			}
		}catch (InterruptedException e) {
			return;
	}

}
}
