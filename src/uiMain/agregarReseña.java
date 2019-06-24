package uiMain;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Materiales.Rese�a;
import gestorAplicaci�n.Usuarios.Vendedor;

class agregarRese�a extends OpcionDeMenu { // opcion 10

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
		Rese�a rese = new Rese�a(comentario, estrellas);
		P.a�adirRese�a(rese);
	}
	@Override
	public String toString() {
		return "Agregar rese�a ";
	}
}