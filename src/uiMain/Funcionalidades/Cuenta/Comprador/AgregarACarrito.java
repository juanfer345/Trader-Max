package uiMain.Funcionalidades.Cuenta.Comprador;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.*;
import java.io.IOException;

public class AgregarACarrito extends OpcionDeMenu {
	
	public void ejecutar() throws NumberFormatException, IOException {

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		int codigoProd, cantidadProd;
		
		while (!controlError) {
		
			//Ingreso de valores
			System.out.print("Ingrese el c�digo del producto a agregar: ");
			codigoProd = Integer.parseInt(br.readLine().trim());
			System.out.print("\nIngrese la cantidad de productos a agregar: ");
			cantidadProd = Integer.parseInt(br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (codigoProd != 0) {
				System.out.println(comp.agregarACarrito(codigoProd, cantidadProd));
			}
			else {
				controlError = true;
			}
			
			//Impresi�n de mensaje de cancelaci�n en caso de que se haya producido un error
			if (!controlError) {System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
		}
	}

	public String toString() {
		return "Agregar a carrito";
	}
}