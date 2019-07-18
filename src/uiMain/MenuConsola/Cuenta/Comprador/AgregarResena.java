package uiMain.MenuConsola.Cuenta.Comprador;
import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class AgregarResena extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() throws IOException {
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		comp.getHistorial().forEach((k, v) -> {
			System.out.println(v);
		});
		System.out.println("Ingrese el codigo del producto: ");

//		int codigoP = Integer.parseInt(MenuDeConsola.br.readLine().trim());
//		Producto P = Vendedor.catalogo.get(codigoP);
		int codigoP = Integer.parseInt(br.readLine().trim());
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = Integer.parseInt(br.readLine().trim());
		System.out.println("Ingrese comentario: ");
		String comentario = br.readLine();
//		Resena rese = new Resena(comentario, estrellas); //Asignar el comprador!!
//		String str = P.anadirResena(rese);
//		String str = comp.anadirResena(codigoP,rese);
//		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Agregar reseña";
	}
}