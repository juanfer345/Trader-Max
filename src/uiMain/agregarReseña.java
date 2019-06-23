package uiMain;

import gestorAplicación.Materiales.Producto;
import gestorAplicación.Materiales.Reseña;
import gestorAplicación.Usuarios.Vendedor;

class agregarReseña extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() {
		//mostrar el catalogo y numerar las posiciones(empezar en 1)
		System.out.println("Ingrese numero del producto en el catálogo ");
		int codigo = e.nextInt();
		Producto p = Vendedor.catalogo.get(codigo-1);
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = MenuDeConsola.e.nextInt();
		System.out.println("Ingrese comentario: ");
		String comentario = MenuDeConsola.e.next();
		Reseña rese = new Reseña(comentario, estrellas);
		p.añadirReseña(rese);
	}
	@Override
	public String toString() {
		return "Agregar reseña ";
	}
}