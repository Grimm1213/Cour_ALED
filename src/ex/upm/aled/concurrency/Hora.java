package ex.upm.aled.concurrency;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Hora extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				sleep(1000);
				System.out.println(LocalDateTime.now().toString());
			}
		} catch (InterruptedException e) {
			return;
		}
	}

}
