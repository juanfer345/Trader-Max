package uiMain;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Materiales.Reseña;
import gestorAplicación.Usuarios.Vendedor;

class agregarReseña extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() {
		//Mostrar el catalogo y numerar las posiciones(empezar en 1)
		
		System.out.println("Ingrese el codigo del producto: ");
		int codigoP = scn.nextInt();
		Producto P = Vendedor.catalogo.get(codigoP);
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = scn.nextInt();
		System.out.println("Ingrese comentario: ");
		String comentario = scn.next();
		Reseña rese = new Reseña(comentario, estrellas);
		P.añadirReseña(rese);
	}
	@Override
	public String toString() {
		return "Agregar reseña ";
	}
}