/**
 * 
 */
package presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import servicios.ControlPEliculaIMP;
import servicios.ICPelicula;

/**
 * @author Alex FC
 *
 */
public class PresentacionControlPel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		ICPelicula control = new ControlPEliculaIMP();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner teclado = new Scanner(System.in);
		int seleccion;

		System.out.println("Gestiona tus peliculas.");
		System.out.println("");

		do {

			System.out.println("\n Digita una opcion:");
			System.out.println("1. Iniciar control de pelicula");
			System.out.println("2. Agregar pelicula");
			System.out.println("3. Listar peliculas");
			System.out.println("4. Buscar pelicula");
			System.out.println("5. Salir");
			System.out.println("Digita una opcion:");
			seleccion = teclado.nextInt();

			System.out.println("");

			if (seleccion == 1) {
				control.iniciarControlPelicula();
			} else if (seleccion == 2) {
				System.out.println("Digita el nombre de la pelicula: ");
				String peliculaAdd = br.readLine();
				control.agregarPelicula(peliculaAdd);

			} else if (seleccion == 3) {
				System.out.println("");
				control.listarPelicula();
			} else if (seleccion == 4) {
				System.out.println("");
				System.out.print("Nombre de pelicula a buscar: ");
				String namePeli = br.readLine();
				control.buscarPelicula(namePeli);

			} else if (seleccion == 5) {
				System.out.println("");
				System.out.println("Hasta pronto!");
				seleccion = 5;
			} else {
				System.out.println("");
				System.out.println("Opcion no disponible, vuelve intentarlo.");

			}

		} while (seleccion != 5);
	}

}
