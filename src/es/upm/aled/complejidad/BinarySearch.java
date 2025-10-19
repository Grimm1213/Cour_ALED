package es.upm.aled.complejidad;

public class BinarySearch {
	
	
	
	private static int binarySearch(int[] list, int lo, int hi,int value) {
		
		//DEBERES : recursividad
		
		do {
			int me = (int) Math.floor(lo + (hi-lo)/2);
			int v = list[me]; // O(1)
			
			if(v==value) {
				return me;
				
			}else if(v>value){
				hi = me;
				
			}else {
				lo = me+1;
			}	
			
		}while(lo<hi);
		return -1;
	}
	
	
	
	
	
	
	
	//Metodo  facachada
	private static int binarySearch(int[] list,int value) {
		return binarySearch(list,0,list.length,value);
	}
	
	
	public static void main (String[] args) {
		int[] list = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31};
		int value = 19;
		int pos = binarySearch(list,value);
		System.out.println("Posicion: " + pos);
	}
}
