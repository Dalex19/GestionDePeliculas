/**
 * 
 */
package datos;

import java.util.List;

import domain.Pelicula;
import excepciones.AccesoDatosExcepcion;
import excepciones.EscrituraDatosExcepcion;
import excepciones.LecturaDatosExcepcion;

/**
 * @author Alex FC
 *
 */
public interface IAcessDatos { 
	
	//Metodos para poder realizar operaciones al archivo
	public boolean comprobarSiExisteArchivo (String nombreRecurso) throws AccesoDatosExcepcion;
	
	public List<Pelicula> listar (String nombreRecurso) throws LecturaDatosExcepcion;
	
	public void escribir (Pelicula pelicula, String nombreRecurso, boolean anexar ) throws EscrituraDatosExcepcion;
	
	public String buscar (String nombreRecurso, String buscar) throws LecturaDatosExcepcion;
	
	public void crear (String nombreRecurso) throws AccesoDatosExcepcion;
	
	public void borrar (String nombreRecurso) throws AccesoDatosExcepcion;

}
