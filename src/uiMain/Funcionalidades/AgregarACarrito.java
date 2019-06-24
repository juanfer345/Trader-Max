package uiMain.Funcionalidades;

import gestorAplicaci�n.Usuarios.CuentaUsuarios;
import uiMain.OpcionDeMenu;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Materiales.Producto;
import java.util.Scanner;

public class AgregarACarrito extends OpcionDeMenu { // opcion 4
	//Pedir codigo, y en caso de existir el producto agregarlo
	
	@Override
	public void ejecutar() { //pa la logica
		Comprador comp = (Comprador)usuario;
		System.out.println("Ingrese el c�digo del producto a agregar");
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