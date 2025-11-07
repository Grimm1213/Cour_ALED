package es.upm.aled.racecondition;

//This class is Thread Safe
public class CounterMonitor extends Counter {
	
	@Override
	public synchronized int getCount() {
		return count;
	}
	
	//Region critica
	@Override
	public synchronized void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public synchronized void increase() {
		count++;
	}
}
