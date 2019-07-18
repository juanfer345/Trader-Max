package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.OpcionDeMenu;

public class MostrarCatalogo extends OpcionDeMenu {
	// Recorre toda la tabla Hash mostrando los productos

	@Override
	public void ejecutar() throws IOException {

		byte comprobOpc;
		
		sb.append("\n Usted ha elegido la opcion para mostrar el catalogo de los productos");
		sb.append("\n Para regresar y cancelar el proceso ingrese el '0'");
		sb.append("\n Para continuar con el proceso ingrese '1'");

		while (!controlError) {
			
			System.out.println(sb);
			comprobOpc = esByte(br.readLine().trim());
			
			if (comprobOpc != 0) {
				if (comprobOpc == 1) {
					System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
				}
				else {
					System.out.println("El dato que ingreso es invalido, solo puede ingresar '0' o '1', "
							           + " vuelva a intentarlo");
				}
			}
			else {System.out.println(); return;}
		}
	}

	@Override
	public String toString() {return "Mostrar todos los productos";}
}