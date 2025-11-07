package es.upm.aled.racecondition;

public class IncreaserGetSet extends Increaser{
	
	public IncreaserGetSet(Counter c) {
		super(c);
	}

	@Override
	public void run() {
		for(int i = 0;i<1000000;++i) {
			//START region critica
			//synchronized(c) {
				int count = c.getCount();
				count++;
				c.setCount(count);
			//}
			
			//END Region critica
		}
	}

}
