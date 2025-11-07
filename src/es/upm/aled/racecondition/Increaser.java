package es.upm.aled.racecondition;

public class Increaser extends Thread{
	
	protected Counter c;
	
	public Increaser(Counter c) {
		this.c=c;
	}
	@Override
	public void run() {
		for(int i = 0;i<1000000;++i) {
			c.increase();
		}
	}
}
