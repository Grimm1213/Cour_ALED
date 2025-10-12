package es.upm.aled.complejidad;

public class Complejidad {
	
	//Devolver la suma de todos los enteros del array
	// O(n-1+1+) => O(n)
	public static int sumIntArray (int[] lista) {
		int sum = 0;
		
		//Esto se ejecuta tanats veces como el tamano del array -1
		for(int i = 0;i< lista.length;++i) {
			
			sum+=lista[i];
		}
		return sum;
	}
	
	//Devolver la suma de todos los enteros del array dos veces
	//O(2n) => O(n)
	public static int sumIntArrayTwice(int[] lista) {
		int sum = 0;
		
		//Esto se ejecuta tanats veces como el tamano del array -1
		for(int i = 0;i< lista.length;++i) {
			
			sum+=lista[i];
		}
		
		//Esto se ejecuta tanats veces como el tamano del array -1
		for(int j = 0;j< lista.length;++j) {
			
			sum+=lista[j];
		}
		
		return sum;
	}
	
	//Devolver la suma de todos los enteros del array
	//Caso peor: el 69 esta en n
	//O(n)
		public static int sumIntArrayStop69 (int[] lista) {
			int sum = 0;
			
			//Esto se ejecuta tanats veces como el tamano del array -1
			for(int i = 0;i< lista.length;++i) {
				if(lista[i] == 69) {
					return sum;
				}
				sum+=lista[i];
			}
			return sum;
		}
	
		//O(n^2) "n al cuadrado"
	public static int numDuplicados(int [] lista) {
		int numDupl = 0;
		for(int i = 0;i< lista.length;++i) {
			for(int j = 0;j<lista.length;++j) {
				//Esto se ejecuta tantas veces com (tamano del array^2
				if ((i<j) && (lista[i] == lista[j])) {
					numDupl ++;
				}
			}
		}
		return numDupl;
	}
	
	//O(6 +n^3) => O(n^3)
	public static int[][] multiplyMatix(int [][] A, int [][] B){
		int rows1 = A.length;
		int rows2 = B.length;
		int cols1 = A[0].length;
		int cols2 = B[0].length;
		
		int [][] C = new int [rows1][cols2];
		
		
		//Asumimos que rows1=rows2=cols1=cols2=n
		for(int i = 0;i<rows1;++i) {
			for(int j = 0;j<cols2;++j) {
				for(int k = 0;k<cols1;++k) {
					//Esto va pasar rows1*cols2*cols1 veces
					//Esto pasa n^3veces
					C[i][j] += A[i][k] * B[k][j]; 
				}
			}
		}
		return C;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
