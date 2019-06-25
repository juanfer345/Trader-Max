package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Rese�a;
import gestorAplicaci�n.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class agregarRese�a extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() throws IOException {
		//Mostrar el catalogo y numerar las posiciones(empezar en 1)
		
		System.out.println("Ingrese el codigo del producto: ");
		int codigoP = Integer.parseInt(br.readLine().trim());
		Producto P = Vendedor.catalogo.get(codigoP);
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = Integer.parseInt(br.readLine().trim());
		System.out.println("Ingrese comentario: ");
		String comentario = br.readLine();
		Rese�a rese = new Rese�a(comentario, estrellas);
		P.a�adirRese�a(rese);
	}
	@Override
	public String toString() {
		return "Agregar rese�a ";
	}
}