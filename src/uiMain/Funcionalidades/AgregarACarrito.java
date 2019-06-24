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
		Comprador comp = (Comprador)usuario;
		System.out.println("Ingrese el código del producto a agregar");
		int codigoP = scn.nextInt();
		System.out.println("Ingrese la cantidad de unidades de este producto");
		int cantidad  = scn.nextInt();
        String agreg = comp.agregarACarrito(codigoP, cantidad);
	}

	@Override
	public String toString() {
		return "Agregar a Carrito";
	}

}