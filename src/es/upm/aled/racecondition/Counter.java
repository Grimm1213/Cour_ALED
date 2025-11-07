package es.upm.aled.racecondition;

public class Counter {

	protected int count;
	
	//Region critica
	public int getCount() {
		return count;
	}
	
	//Region critica
	public void setCount(int count) {
		this.count = count;
	}
	
	//Region critica
	public void increase() {
		count++;
	}
		

	

}
