/**
 * 
 */
package domain;

/**
 * @author Alex FC
 *
 */
//Clase entidad
public class Pelicula {
	private String name;
	
	public Pelicula (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	



}
