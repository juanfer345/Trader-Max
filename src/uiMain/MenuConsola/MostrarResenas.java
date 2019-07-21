/*	Clase MostrarReseñas (pública)        
	
	Propósito: Opción de menú del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.OpcionDeMenu;


public class MostrarResenas extends OpcionDeMenu {
	
public void ejecutar() throws IOException {
	
	/*
	 Propósito: Ejecutar el método mostrarReseñas() haciendo los respectivos
	            controles de error del ingreso de datos
	 */

		controlError = false;
		String codigo;
		int cuentaCod;
		Cuenta cuenta = InicializacionAplicacion.usuarioActivo;
		
		if (!cuenta.getCatalogo().isEmpty()) {
			sb.append("\nNOTA: se puede cancelar la operación ingresando en cualquiera de los dos datos el número '0'.\n");
			
			while (!controlError) {
				
				// Ingreso de datos por parte del usuario
				System.out.println(sb);
				System.out.println("Ingrese el código del producto al cual le quiere ver las reseñas \n=> ");
				codigo = br.readLine().trim();
				cuentaCod = esInt(codigo);
				/*
				  Ciclo de control de error para el código del producto, pide un número
				 (código) hasta que sea válido (puede ingresar el 0 para salir)
				*/
				while (cuentaCod == -1) {
					System.out.println("\nEl dato que ingresó como codigo es inválido, vuelva a intentarlo.");
					System.out.print("Ingrese el código del producto al cual le quiere ver las reseñas \n=> ");
					codigo = br.readLine().trim();
					cuentaCod = esInt(codigo);
				}
				// Mira si es cero para devolverse
				if (cuentaCod == 0) {
					controlError = true;
					System.out.println("");
				} else {
					if (!cuenta.getCatalogo().containsKey(cuentaCod)) {
						System.out.println("Código inválido.");
					} else {
						// Ejecuta el método correspondiente
						Producto prod = cuenta.getCatalogo().get(cuentaCod);
						System.out.println(prod.mostrarResenas());
					}
				}
			}
		} else {
			System.out.println("El catálogo está vacío.");
			controlError = true;
		}
	}

	public String toString() {
		return "Mostrar reseñas de un producto";
	}
}
