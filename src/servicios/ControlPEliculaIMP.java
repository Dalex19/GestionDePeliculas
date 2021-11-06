/**
 * 
 */
package servicios;

import java.util.List;


import datos.AcessDatosImp;
import datos.IAcessDatos;
import domain.Pelicula;
import excepciones.AccesoDatosExcepcion;

/**
 * @author Alex FC
 *
 */
public class ControlPEliculaIMP implements ICPelicula {

	private final IAcessDatos datos;

	public ControlPEliculaIMP() {
		this.datos = new AcessDatosImp();
	}

	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;

		try {
			anexar = datos.comprobarSiExisteArchivo(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosExcepcion e) {
			System.out.println("Error de acceso a datos ");
			e.printStackTrace(System.out);
		}

	}

	@Override
	public void listarPelicula() {
		try {
			List<Pelicula> peliculasCopy = this.datos.listar(NOMBRE_RECURSO);
			for (Pelicula x : peliculasCopy) {
				System.out.println("Pelicula: "+x.getName());
			}
		} catch (AccesoDatosExcepcion e) {
			System.out.println("Error de acceso a datos ");
			e.printStackTrace(System.out);
		}

	}

	@Override
	public void buscarPelicula(String buscarPelicula) {
		String resultado1 = null;
		try {
			resultado1 = this.datos.buscar(NOMBRE_RECURSO, buscarPelicula);
		} catch (AccesoDatosExcepcion e) {
			System.out.println("Error de acceso a datos ");
			e.printStackTrace(System.out);
		}

		if (resultado1 == null) {
			System.out.println("No se ha encontrado la pelicula");
		} else {
			System.out.println(resultado1);
		}

	}

	@Override
	// Metodo que crea el archivo de texto
	public void iniciarControlPelicula() {
		try {
			if (this.datos.comprobarSiExisteArchivo(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			} else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosExcepcion e) {
			System.out.println("Error al iniciar control de pelicula");
			e.printStackTrace(System.out);
		}
	}

}
