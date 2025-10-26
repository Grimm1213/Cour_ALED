package es.upm.aled.concurencia;

import java.awt.Toolkit;

public class Pitiditos extends Thread {
	
	@Override
	public void run() {
		try {
		while(true) {
			sleep(666);
			Toolkit.getDefaultToolkit().beep();
		}
	}catch(InterruptedException e) {
		return;
	}

}
