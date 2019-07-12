package uiMain.Funcionalidades.Cuenta.Comprador;

import java.io.IOException;
import java.util.Map;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class MostrarHistorial extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {

		StringBuilder sb = new StringBuilder();

		sb.append("\n Usted ha elegido la opcion para mostrar su historial de compras");
		sb.append("\n Para regresar y cancelar el proceso ingrese el '0'");
		sb.append("\n Para continuar con el proceso ingrese '1'");

		int opcion;
		OpcionDeMenu.controlError = false;

		while (!OpcionDeMenu.controlError) {

			System.out.println(sb);

			try {
				opcion = Integer.parseInt(br.readLine().trim());
				
				if (opcion == 0) {
					OpcionDeMenu.controlError = true;
				} else if (opcion == 1) {
					Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
					System.out.println("Total de productos del historial = " + comp.getHistorial().size() + "\n");
					for (Map.Entry<Integer, Producto> entry : comp.getHistorial().entrySet()) {
						Producto P = entry.getValue();
						System.out.println(P);
					}
					comp = null;
					OpcionDeMenu.controlError = true;
				}else {
					System.out.println("Solo puede ingresar '0' o '1', vuelva a intentarlo");
				}
				
			} catch (NumberFormatException nfe) {
				// Por si se ingresa un tipo de dato diferente
				System.out.println("\n El dato que ingreso es invalido ");
			}
		}
	}

	@Override
	public String toString() {
		return "Mostrar historial";
	}
}