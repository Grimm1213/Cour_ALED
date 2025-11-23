package ex.upm.aled.concurrency;

import java.awt.Toolkit;
import java.util.Scanner;

public class Sonido extends Thread {

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String linea = sc.nextLine();
			Toolkit.getDefaultToolkit().beep();
			if (linea.equals("PARA")) {
				return;
			}
		}
	}

}
