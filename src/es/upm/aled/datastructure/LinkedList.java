package es.upm.aled.datastructure;

public class LinkedList {
	private Node primero;
	
	public LinkedList (Node prim) {
		this.primero = prim;
	}

	public Node getPrimero() {
		return primero;
	}

	public void setPrimero(Node primero) {
		this.primero = primero;
	}

}
