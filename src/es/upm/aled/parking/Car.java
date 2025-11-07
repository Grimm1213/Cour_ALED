package es.upm.aled.parking;

public class Car extends Thread {

	private int plate;
	private Parking parking;
	
	public Car(int plate,Parking parking) {
		this.plate=plate;
		this.parking=parking;
	}
	
	
	
}
