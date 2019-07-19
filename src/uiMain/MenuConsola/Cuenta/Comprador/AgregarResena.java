package uiMain.MenuConsola.Cuenta.Comprador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class AgregarResena extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() throws IOException {
		controlError = false;
		String codigo, estrellas;
		int compCod, compEst;
		String compCom = "";
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		if (!comp.getHistorial().isEmpty()) {
			sb.append("\nNOTA: se puede cancelar la operación ingresando en cualquiera de los dos datos el número '0'");
			while (!controlError) {
				System.out.println(sb);
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
				while (compCod == -1) {
					System.out.println("\nEl dato que ingreso como codigo es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese el codigo del producto => ");
					codigo = br.readLine().trim();
					compCod = esInt(codigo);
				}
				while (compEst == -1) {
					System.out.println(
							"\nEl dato que ingreso como numero de estrellas es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese el numero de estrellas => ");
					estrellas = br.readLine().trim();
					compEst = esInt(estrellas);
				}
				if (compCod == 0 || compEst == 0) {
					controlError = true;
					System.out.println(" ");
				} else {
					Resena rese = new Resena(comp, compCom, compEst); // Asignar el comprador!!
					String str = comp.anadirResena(compCod, rese);
					if (str.equals("No ha comprado este producto, no puede añadir una reseña")) {
						System.out.println("\n" + str);
						System.out.println("Repita el proceso con datos correctos");
					} else {
						System.out.println("\n" + str + "\n");
						controlError = true;
					}
				}
			}
		} else {
			System.out.println("Su historial está vacio, no puede agregar reseñas.");
			controlError = true;
		}
	}

	@Override
	public String toString() {
		return "Agregar reseña";
	}
}