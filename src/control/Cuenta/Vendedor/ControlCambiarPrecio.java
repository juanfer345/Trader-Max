 package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlCambiarPrecio implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		double precio;
		int idProducto;
		

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() != 0) {

			String mensaje1 = "Recuerde que el producto debe ser de su propiedad.";
			vend.mostrarProductos();

			while(!OpcionDeMenu.controlError) {

				//Ingreso del código del producto
				//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto al que le desea cambiar el precio", "El dato que ingresó no es válido");
				if (!OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ingreso del precio del producto
				//precio = ControlErrorDatos.controlReal(0.1, Double.MAX_VALUE, "Ingrese el nuevo precio del producto", "El dato que ingresó no es válido");
				if (!OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ejecución del método
				//vend.cambiarPrecio(idProducto, precio);
			}
		}
		else {
			//"Usted aún no ha subido ningún producto";
		}
	}
	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}

