package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlSubirProducto  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String nombre;
		double precio;
		int cant;
		byte categoria;

		//Guardado de mensaje principal
		String mensaje1 = "Elija la categoría del producto";
		Producto.getCategorias();

		//Impresión del mensaje principal
		System.out.println("\nPor favor ingrese los datos del producto.");

		//Ingreso del nombre del producto
		//nombre = ControlErrorDatos.controlString("Nombre", "Se está ingresando un número en lugar de un nombre");
		if (OpcionDeMenu.controlError) {System.out.println(); return;}

		//Ingreso del precio del producto
		//precio = ControlErrorDatos.controlReal(0.1, Double.MAX_VALUE, "Precio", "Por favor ingrese un número real");
		if (OpcionDeMenu.controlError) {System.out.println(); return;}

		//Ingreso de la cantidad del producto
		//cant = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Cantidad", "Por favor ingrese un número entero positivo");
		if (OpcionDeMenu.controlError) {System.out.println(); return;}

		//vend.subirProducto(nombre, (byte) (categoria), precio, cant);
	}

	@Override
	public String toString() {return "Subir producto";}
}