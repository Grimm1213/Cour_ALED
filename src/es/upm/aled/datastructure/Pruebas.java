package es.upm.aled.datastructure;

public class Pruebas {

	public static void main(String[] args) {
		Node primero = new Node(7);
		Node segundo = new Node(3);
		primero.setNext(segundo);
		Node tercero = new Node(10);
		segundo.setNext(tercero);
		
		
		LinkedList lista = new LinkedList(primero);
		lista.getPrimero().getNext().getValue();
		
		
		//Solo puedo usar principio
		Node principio = primero;
		
		principio.getNext().getNext();//--> estoy en el terero aqui
		

	}

}
