package es.upm.aled.complejidad;

public class Bubblesort {
	
	private static void bubbleSort(int [] list) {
		for ( int i = 0; i<list.length; ++i) {
			for ( int j = 0; j < list.length - 1 - i;++j) { // menos uno par no estar out of bound y el menos i es porque el ultimo esta bien
				
				
				//Si es mayor el segundo, los cambiamos
				if(list[j] > list[j+1]) {
					//Permutacion de dos numeros
					int temp = list[j];
					list[j]= list[j+1];
					list[j+1] = temp;
					}
			}
		}
	}

	
	public static void main(String[] args) {
		int [] list = {31,29,27,23,21,19,17,15,13,11,9,7,5,3,1};
		bubbleSort(list);
		System.out.println("Ordenado:");
		for (int v : list) {
			System.out.println(v);
		}
	}
}
