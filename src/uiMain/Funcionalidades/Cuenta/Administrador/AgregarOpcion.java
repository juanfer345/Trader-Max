package uiMain.Funcionalidades.Cuenta.Administrador;

import java.io.IOException;
import java.util.ArrayList;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.*;

public class AgregarOpcion extends OpcionDeMenu {
	
	public void ejecutar() throws NumberFormatException, IOException {

	    int seleccion;

		
		
		ArrayList <OpcionDeMenu> aux = InicializacionAplicacion.usuarioActivo.getOpcionesDeMenu();
		
		
		for (int i = 0; i < aux.size(); i++) {
			System.out.println(aux.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int agregar = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		MenuDeConsola.opcionesActivas.add(MenuDeConsola.opcionesActivas.get(agregar));
		//boolean b = activo.add(opciones.get(agregar));
		//if(b)
		//	System.out.println("Se agregó la opción exitosamente");
		//else
		//	System.out.println("No se pudo agregar la opción");
		

	    StringBuilder sb = new StringBuilder();
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		int codigoProd, cantidadProd;
		
		while (!OpcionDeMenu.controlError) {
			
		    //Ingreso de valores
			sb.append("Elija el tipo de cuenta a la cual se le desea agregar la opción:\n");
			sb.append("1: Comprador\n");
			sb.append("2: Vendedor\n");
			sb.append("=> ");
			System.out.println(sb);
			seleccion = Integer.parseInt(MenuDeConsola.br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			if (seleccion != 0) {
				if (seleccion == 1) {
					System.out.println(comp.agregarACarrito(codigoProd, cantidadProd));
				}
				else if (seleccion == 2) {
					
				}
			}
			else {
				OpcionDeMenu.controlError = true;
			}
			
			//Impresión de mensaje de cancelación en caso de que se haya producido un error
			if (!OpcionDeMenu.controlError) {System.out.println("NOTA: se puede cancelar la operación ingresando el número '0' \n");}
		}
	}
	
	public String toString() {
		return "Agregar opción";
	}

}