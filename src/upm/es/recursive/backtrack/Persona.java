package upm.es.recursive.backtrack;

import java.util.List;
import java.util.ArrayList;

public class Persona {

    private String nombre;
    private List<Persona> hijos;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<Persona>(); 
    }

    public String getNombre() {
        return nombre;
    }

    public List<Persona> getHijos() {
        return hijos;
    }

    public void addHijo(Persona p) {
    	if (!hijos.contains(p)) {
    		 this.hijos.add(p);
    	}
    }

    public String descendientes() {
        if (hijos.isEmpty()) {
            return this.nombre + " ";
        }

        String misDescendientes = this.nombre + ": ";

        for (Persona hijo : this.hijos) {
            String descendientes = hijo.descendientes();
            misDescendientes = misDescendientes + descendientes + ", ";
        }

        return misDescendientes;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona ro = new Persona("Rodrigo");
		Persona no = new Persona("Nora");
		Persona afro = new Persona("Afrodita");
		ro.addHijo(no);
		ro.addHijo(afro);
		Persona lu = new Persona("Luis");
		no.addHijo(lu);
		Persona ra = new Persona("Ramona");
		no.addHijo(ra);
		Persona perse = new Persona("Perseo");
		afro.addHijo(perse);
		Persona kronos = new Persona("Kronos");
		afro.addHijo(kronos);
		System.out.println(ro.descendientes());
		
		
		
		
	}

}
