package uiMain.Funcionalidades.Cuenta.Comprador;

import java.io.IOException;
import java.util.Map;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class MostrarHistorial extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {

		StringBuilder sb = new StringBuilder();

		sb.append("\nUsted ha elegido la opcion para mostrar su historial de compras. ¿Que desea hacer?");
		sb.append("\n0. Devolverse al menú y cancelar el proceso ");
		sb.append("\n1. Continuar con el proceso ");

		controlError = false;
		String opcion;
		int comprobOpc;

		while (!controlError) {

			System.out.println(sb);
			System.out.print("=> ");
			opcion = br.readLine().trim();
			comprobOpc = MenuDeConsola.esInt(opcion);

			while (comprobOpc == -1) {
				System.out.println("\nEl dato que ingreso es invalido, vuelva a intentarlo");
				System.out.print("Ingrese su eleccion => ");
				opcion = br.readLine().trim();
				comprobOpc = (int) MenuDeConsola.esInt(opcion);
			}
			if (comprobOpc == 0) {
				// ver si es un 0 para devolverse
				controlError = true;
				System.out.println(" ");
			} else if (comprobOpc == 1) {
				Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
				System.out.println("\nTotal de productos del historial = " + comp.getHistorial().size());
				if (!comp.getHistorial().isEmpty()) {
					System.out.println("\n");
					for (Map.Entry<Integer, Producto> entry : comp.getHistorial().entrySet()) {
						Producto p = entry.getValue();
						System.out.println(p);
					}
					comp = null;
					System.out.println("\n");
				} else {
					System.out.println("El historial está vacío \n");
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

	@Override
	public String toString() {
		return "Mostrar historial";
	}
}