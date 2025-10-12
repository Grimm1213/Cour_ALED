package upm.es.recursive.backtrack;

public class Test {
	public static void main(String[] args ) {
		
		Coordinate sitio1 = new Coordinate(4,3);
		Coordinate sitio2 = new Coordinate(4,3);
		boolean iguales = (sitio1==sitio2);
		System.out.println("Son iguales ? " + iguales); // false
		System.out.println("Son iguales ? " + sitio1.equals(sitio2)); // true
		
	}

}
