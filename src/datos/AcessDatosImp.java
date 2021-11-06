/**
 * 
 */
package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import domain.Pelicula;
import excepciones.AccesoDatosExcepcion;
import excepciones.EscrituraDatosExcepcion;
import excepciones.LecturaDatosExcepcion;

/**
 * @author Alex FC
 *
 */
public class AcessDatosImp implements IAcessDatos {

	@Override
	public boolean comprobarSiExisteArchivo(String nombreRecurso) throws AccesoDatosExcepcion {
		File archivo = new File(nombreRecurso);
		return archivo.exists();
		
	}

	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcepcion {
		File archivo = new File(nombreRecurso);
		List<Pelicula> misPeliculas = new ArrayList <Pelicula>();
		
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String contenido = null;
			contenido = entrada.readLine();
			
			while (contenido != null) {
				Pelicula pelicula = new Pelicula(contenido);
				misPeliculas.add(pelicula);
				contenido = entrada.readLine();
			}
			entrada.close();
		} catch (IOException e) 	{
			e.printStackTrace(System.out);
			throw new LecturaDatosExcepcion("Hay un inconveniente al listar la peliculas"+ e.getMessage());
		}
		
		return misPeliculas;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcepcion {
		File archivo = new File (nombreRecurso);
		
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar)); 
			salida.println(pelicula.toString());
			salida.close();
			System.out.println("Se ha agregado la pelicula "+ pelicula.getName()+ " correctamente");
		} catch(IOException e) {
			e.printStackTrace(System.out);
			throw new EscrituraDatosExcepcion ("Error al escribir en el archivo " + e.getMessage());
		}
	}

	@Override
	public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepcion {
		File archivo = new File(nombreRecurso);
		String resultado = null;
		
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			int indi = 1;
			
			while (linea != null) {
				if(buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula " + linea + ", encontrada en el indice: "+indi ;
					break;
				}
				linea = entrada.readLine();
				indi++;
			}
			
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace(System.out);
			throw new LecturaDatosExcepcion("Ha ocurrido una excepcion al buscar tu pelicula" + e.getMessage());
		}
		
		return resultado;
	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosExcepcion {

		File archivo = new File(nombreRecurso);
		
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se ha creado el archivo");
			
		} catch(IOException e) {
			e.printStackTrace(System.out);
			throw new AccesoDatosExcepcion("Excepcion al crear el archivo "+e.getMessage());
		}
	}

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosExcepcion {
		
		File archivo = new File(nombreRecurso);
		
		if(archivo.exists()) {
			archivo.delete();
		}
		
		System.out.println("Se ha borrado el archivo");
	}
	
	
}
