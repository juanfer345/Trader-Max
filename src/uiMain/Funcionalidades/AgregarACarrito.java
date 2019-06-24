package uiMain.Funcionalidades;

import gestorAplicación.Usuarios.CuentaUsuarios;
import uiMain.OpcionDeMenu;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Materiales.Producto;
import java.util.Scanner;

public class AgregarACarrito extends OpcionDeMenu { // opcion 4
	//Pedir codigo, y en caso de existir el producto agregarlo
	
	@Override
	public void ejecutar() { //pa la logica
		System.out.println("Ingrese el código del producto a agregar");
		int codigoP = scn.nextInt();
		Producto P = null;
		P = CuentaUsuarios.catalogo.get(codigoP);
		if(P != null) {
			usuario.agregarACarrito(P);		
			System.out.println(P);
			System.out.println("Este producto ha sido agregado exitosamente");
		} else {
			System.out.println("Código de producto invalido");
		}
	}

	@Override
	public String toString() {
		return "Agregar a Carrito";
	}

}