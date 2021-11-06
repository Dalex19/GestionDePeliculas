/**
 * 
 */
package servicios;

/**
 * @author Alex FC
 *
 */
public interface ICPelicula {
	
	 final String NOMBRE_RECURSO = "peliculas.txt";

	public void agregarPelicula(String nombrePelicula);
	
	public void listarPelicula();
	
	public void buscarPelicula(String peliculaSearch);
	
	public void iniciarControlPelicula();
	
}
