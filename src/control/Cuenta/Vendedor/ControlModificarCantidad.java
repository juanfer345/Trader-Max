package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlModificarCantidad extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		int idProducto, cantidad;
		byte operacion;
		StringBuilder sb = new StringBuilder();

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() != 0) {

			//Guardado de mensaje principal (incluyendo lista de productos)
			String mensaje1 = "Esta opción es para cambiar la cantidad un producto del catálogo. "
					+ "\n Recuerde que el producto debe ser de su propiedad.";
			vend.mostrarProductos();

			while(!OpcionDeMenu.controlError) {

				//Impresión del mensaje principal
				System.out.println(sb);

				//Ingreso del código del producto
				//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto al que le desea cambiar su cantidad", "Por favor ingrese un número entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ingreso de la cantidad del producto
				//cantidad = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese cantidad a sumar o restar", "Por favor ingrese un número entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ingreso del tipo de operación
				//operacion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, "Ingrese 1 para sumar la cantidad y 2 para restarla", "Por favor ingrese un número entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}
				
				//Ejecución del método
				//vend.modificarCantidad(idProducto, cantidad, operacion);
			}
		}
		else {
			System.out.println("Usted aún no ha subido ningún producto.\n");
		}
	}

	public String toString() {
		return "Modificar la cantidad de un producto";
	}
}