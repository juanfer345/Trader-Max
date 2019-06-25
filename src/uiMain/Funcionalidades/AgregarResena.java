package uiMain.Funcionalidades;
import java.io.IOException;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Resena;
import gestorAplicaci�n.Usuarios.Vendedor;
import gestorAplicaci�n.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class AgregarResena extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() throws IOException {
		Comprador comp = (Comprador)usuario;
		comp.getHistorial().forEach((k, v) -> {
			System.out.println(v);
		});
		System.out.println("Ingrese el codigo del producto: ");
		int codigoP = Integer.parseInt(br.readLine().trim());
		Producto P = Vendedor.catalogo.get(codigoP);
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = Integer.parseInt(br.readLine().trim());
		System.out.println("Ingrese comentario: ");
		String comentario = br.readLine();
		Resena rese = new Resena(comentario, estrellas);
		String str =P.a�adirResena(rese);
		String str =comp.a�adirResena(codigoP,rese);
		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Agregar rese�a ";
	}
}