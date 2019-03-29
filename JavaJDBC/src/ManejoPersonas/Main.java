package ManejoPersonas;
import ManejoPersonas.datos.PersonaJDBC;
import ManejoPersonas.domain.Persona;
import java.util.List;
public class Main {

	/**
	 * Método main.
	 * @param args
	 */
	public static void main(String[] args) {

		PersonaJDBC personaJDBC = new PersonaJDBC();
		
		//listarPersonas(personaJDBC);
		
		// Prueba del metodo insert
		//personaJDBC.insert("Karla", "Amaya");
		//listarPersonas(personaJDBC);
		
		// Prueba de update
		//personaJDBC.update(2, "Nombre3", "Apellido 3");
		//listarPersonas(personaJDBC);
		
		// Prueba de delete
		personaJDBC.delete(7);
		listarPersonas(personaJDBC);
	}
	
	private static void listarPersonas(PersonaJDBC personaJDBC) {

		
		List<Persona> listaPersonas;
		
		listaPersonas = personaJDBC.select();
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona);
			System.out.println();
		}
		listaPersonas.clear();
		listaPersonas = null;
	}

}
