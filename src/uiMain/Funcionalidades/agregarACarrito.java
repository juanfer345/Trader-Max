package uiMain.Funcionalidades;

import gestorAplicaci�n.Usuarios.CuentaUsuario;
import uiMain.OpcionDeMenu;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Materiales.Producto;

import java.io.IOException;
import java.util.Scanner;

public class agregarACarrito extends OpcionDeMenu { // opcion 4
	//Pedir codigo, y en caso de existir el producto agregarlo
	
	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		System.out.println("Ingrese el c�digo del producto a agregar");
		int codigoP = Integer.parseInt(br.readLine().trim());
		Producto P = null;
		P = CuentaUsuario.catalogo.get(codigoP);
		if(P != null) {
			usuarioActivo.agregarACarrito(P);		
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