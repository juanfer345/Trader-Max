package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Materiales.Reseña;
import gestorAplicación.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class agregarReseña extends OpcionDeMenu { // opcion 10

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
		Reseña rese = new Reseña(comentario, estrellas);
		String str =P.añadirReseña(rese);
		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Agregar reseña ";
	}
}