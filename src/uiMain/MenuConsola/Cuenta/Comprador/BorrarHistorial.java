package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class BorrarHistorial extends OpcionDeMenu { // opcion 5

	public void ejecutar() throws IOException {
		
		sb.append("\nUsted ha elegido la opción para borrar su historial de compras. ¿Que desea hacer?");
		sb.append("\n0. Devolverse al menú y cancelar el proceso ");
		sb.append("\n1. Continuar con el proceso ");

		controlError = false;
		String opcion;
		int comprobOpc;
	
		while (!controlError) {

			System.out.println(sb);
			System.out.print("=> ");
			opcion = br.readLine().trim();
			comprobOpc = esInt(opcion);

			while (comprobOpc == -1) {
				System.out.println("\nEl dato que ingreso es invalido, vuelva a intentarlo");
				System.out.print("Ingrese su eleccion => ");
				opcion = br.readLine().trim();
				comprobOpc = esInt(opcion);
			}
			if (comprobOpc == 0) {
				// ver si es un 0 para devolverse
				controlError = true;
				System.out.println(" ");
			} else if (comprobOpc == 1) {
				Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
				if (!comp.getHistorial().isEmpty()) {
						String str = comp.borrarHistorial();
						System.out.println(str);
				} else {
					System.out.println("El historial ya esta vacio.");
				}
				controlError = true;
			} else {
				/*
				 * Si ingresa un numero diferente pero no es ninguna de las disponibles debe
				 * empezar de nuevo (Empezara de nuevo el control)
				 */
				System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
			}
		}
	}

	public String toString() {
		return "Borrar Historial";
	}

}