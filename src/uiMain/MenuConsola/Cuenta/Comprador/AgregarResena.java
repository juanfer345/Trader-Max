/*	Clase AgregarRese�a (p�blica)        
	
	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class AgregarResena extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() throws IOException {
		/*
		 Prop�sito: Ejecutar el metodo AgregarRese�a() haciendo los respectivos 
		            controles de error del ingreso de datos
		 */
		controlError = false;
		String codigo, estrellas;
		int compCod, compEst;
		String compCom = "";
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		
		if (!comp.getHistorial().isEmpty()) {
			sb.append("\nNOTA: se puede cancelar la operaci�n ingresando en cualquiera de los dos datos el n�mero '0'");
			
			while (!controlError) {
				System.out.println(sb);
				//Ingreso de dato por parte del usuario
				System.out.println("Historial de productos comprados => ");
				comp.mostrarHistorial();
				System.out.println("Ingrese el codigo del producto => ");
				codigo = br.readLine().trim();
				compCod = esInt(codigo);
				System.out.println("Ingrese el numero de estrellas => ");
				estrellas = br.readLine().trim();
				compEst = esInt(estrellas);
				System.out.println("Ingrese comentario: ");
				compCom = br.readLine();
				
				/*
				  Ciclo de control de error para el c�digo del producto, pide un n�mero
				 (c�digo) hasta que sea v�lido (puede ingresar el 0 para salir)
				*/
				while (compCod == -1) {
					System.out.println("\nEl dato que ingreso como codigo es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese el codigo del producto => ");
					codigo = br.readLine().trim();
					compCod = esInt(codigo);
				}
				
				/*
				  Ciclo de control de error para el n�mero de estrellas del producto, pide un n�mero
				 (cantidad estrellas) hasta que sea v�lido (puede ingresar el 0 para salir)
				*/
				while (compEst == -1) {
					System.out.println("\nEl dato que ingreso como numero de estrellas es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese el numero de estrellas => ");
					estrellas = br.readLine().trim();
					compEst = esInt(estrellas);
				}
				
				// Verifica si alguno es cero para salirse de la opcion
				if (compCod == 0 || compEst == 0) {
					controlError = true;
					System.out.println(" ");
				} else {
					Resena rese = new Resena(comp, compCom, compEst); 
					String str = comp.anadirResena(compCod, rese);
					// Control de errores en cuanto a l�gica del programa
					if (str.equals("No ha comprado este producto, no puede a�adir una rese�a")) {
						System.out.println("\n" + str);
						System.out.println("Repita el proceso con datos correctos");
					} else {
						System.out.println("\n" + str + "\n");
						controlError = true;
					}
				}
			}
		} else {
			System.out.println("Su historial est� vacio, no puede agregar rese�as.");
			controlError = true;
		}
	}

	@Override
	public String toString() {
		return "Agregar rese�a";
	}
}