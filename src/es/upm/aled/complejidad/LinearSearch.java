package es.upm.aled.complejidad;

public class LinearSearch {

	//indexOf()
	//Devuelve la posicion, -1 si no esta
	public static int LinearSearch(int[] lista, int valor) {
		//Recorro la lista
		for(int i = 0;i<lista.length;++i){
			//Son iguales
			if (lista[i] == valor) {
				return i;
			}
			
		}
		return -1;
	}
}
