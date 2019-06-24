package uiMain;

import gestorAplicaci�n.Usuarios.CuentaUsuarios;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Materiales.Producto;
import java.util.Scanner;

class agregarACarrito extends OpcionDeMenu { // opcion 4
	//Pedir codigo, y en caso de existir el producto agregarlo
	
	@Override
	public void ejecutar() {
		System.out.println("Ingrese el c�digo del producto a agregar");
		int codigoP = scn.nextInt();
		Producto P = null;
		P = CuentaUsuarios.catalogo.get(codigoP);
		if(P != null) {
			usuario.agregarACarrito(P);		
			System.out.println(P);
			System.out.println("Este producto ha sido agregado exitosamente");
		} else {
			System.out.println("C�digo de producto invalido");
		}
	}

	@Override
	public String toString() {
		return "Agregar a Carrito";
	}

}