package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Resena;
import gestorAplicaci�n.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class AgregarResena extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() throws IOException {//mostrar el catalogo, pa la logica
		//Mostrar el catalogo y numerar las posiciones(empezar en 1)
		
		System.out.println("Ingrese el codigo del producto: ");
		int codigoP = scn.nextInt();
		Producto P = Vendedor.catalogo.get(codigoP);
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = scn.nextInt();
		System.out.println("Ingrese comentario: ");
		String comentario = br.readLine();
		Resena rese = new Resena(comentario, estrellas);
		String str =P.a�adirResena(rese);
		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Agregar rese�a ";
	}
}