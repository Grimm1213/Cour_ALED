package es.upm.recurcion.suma;

public class suma {
	public static void main(String[] args) {
		int res = suma(5);
		
		System.out.println(res);
		
		
	}
	public static int suma(final int n) {
		if (n == 1) {
			return 1;
			
		}else {
			return n + suma(n-1);
		}
	}

}
