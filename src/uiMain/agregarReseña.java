package uiMain;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Rese�a;
import gestorAplicaci�n.Usuarios.Vendedor;

class agregarRese�a extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() {
		//mostrar el catalogo y numerar las posiciones(empezar en 1)
		System.out.println("Ingrese numero del producto en el cat�logo ");
		int codigo = e.nextInt();
		Producto p = Vendedor.catalogo.get(codigo-1);
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = MenuDeConsola.e.nextInt();
		System.out.println("Ingrese comentario: ");
		String comentario = MenuDeConsola.e.next();
		Rese�a rese = new Rese�a(comentario, estrellas);
		p.a�adirRese�a(rese);
	}
	@Override
	public String toString() {
		return "Agregar rese�a ";
	}
}