/*	Clase MostrarRese�as (p�blica)        
	
	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
	 Prop�sito: Ejecutar el m�todo mostrarRese�as() haciendo los respectivos
	            controles de error del ingreso de datos
	 */

		controlError = false;
		String codigo;
		int cuentaCod;
		Cuenta cuenta = InicializacionAplicacion.usuarioActivo;
		
		if (!cuenta.getCatalogo().isEmpty()) {
			sb.append("\nNOTA: se puede cancelar la operaci�n ingresando en cualquiera de los dos datos el n�mero '0'.\n");
			
			while (!controlError) {
				
				// Ingreso de datos por parte del usuario
				System.out.println(sb);
				System.out.println("Ingrese el c�digo del producto al cual le quiere ver las rese�as \n=> ");
				codigo = br.readLine().trim();
				cuentaCod = esInt(codigo);
				/*
				  Ciclo de control de error para el c�digo del producto, pide un n�mero
				 (c�digo) hasta que sea v�lido (puede ingresar el 0 para salir)
				*/
				while (cuentaCod == -1) {
					System.out.println("\nEl dato que ingres� como codigo es inv�lido, vuelva a intentarlo.");
					System.out.print("Ingrese el c�digo del producto al cual le quiere ver las rese�as \n=> ");
					codigo = br.readLine().trim();
					cuentaCod = esInt(codigo);
				}
				// Mira si es cero para devolverse
				if (cuentaCod == 0) {
					controlError = true;
					System.out.println("");
				} else {
					if (!cuenta.getCatalogo().containsKey(cuentaCod)) {
						System.out.println("C�digo inv�lido.");
					} else {
						// Ejecuta el m�todo correspondiente
						Producto prod = cuenta.getCatalogo().get(cuentaCod);
						System.out.println(prod.mostrarResenas());
					}
				}
			}
		} else {
			System.out.println("El cat�logo est� vac�o.");
			controlError = true;
		}
	}

	public String toString() {
		return "Mostrar rese�as de un producto";
	}
}
