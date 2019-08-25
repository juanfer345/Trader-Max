package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlAgregarACarrito extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {int idProducto, cantProd;

	// Verificación de catalogo no vacío
	if (!Cuenta.getCatalogo().isEmpty()) {

		System.out.println();
		
		while(!OpcionDeMenu.controlError) {
			//Ingreso del código
			//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto que desea agregar", "El dato que ingresó como código es inválido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ingreso de la cantidad del producto
			//cantProd = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese la cantidad de elementos que desea agregar", "El dato que ingresó como cantidad es inválido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}
			
			//Ejecución del método
			//System.out.println(CarritoDeCompras.agregarACarrito(idProducto, cantProd));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
		}
	}
	else {
		System.out.println("No hay productos en el catálogo.\n");
	}
		
	}
	public String toString() {
		return "Agregar a carrito";
	}

}
