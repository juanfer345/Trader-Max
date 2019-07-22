/* 
   Clase ModificarCantidad (pública, hereda de OpcionDeMenu)

   Propósito:
   Opción de menú del usuario, le permite realizar acciones en el programa 
   manipulando sus atributos y elementos

   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.InterfazCategorias;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class SubirProducto extends OpcionDeMenu implements InterfazCategorias{

	@Override
	public void ejecutar() throws IOException {

		/*
		   Propósito: Ejecutar el método subirProducto() haciendo los respectivos 
		              controles de error del ingreso de datos
		 */

		// Atributos
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String nombre;
		double precio;
		int cant;
		byte categoria;

		//Guardado de mensaje principal
		sb.append("\nPor favor elija la categoría del producto ingresando su índice:\n");
		sb.append(Producto.getCategorias());
		sb.append("selección");

		//Impresión del mensaje principal
		System.out.println("\nPor favor ingrese los datos del producto.");

		//Ingreso del nombre del producto
		nombre = ControlErrorDatos.controlString("Nombre", "Se está ingresando un número en lugar de un nombre");
		if (controlError) {System.out.println(); return;}

		//Ingreso del precio del producto
		precio = ControlErrorDatos.controlReal(0.1, Double.MAX_VALUE, "Precio", "Por favor ingrese un número real");
		if (controlError) {System.out.println(); return;}

		//Ingreso de la cantidad del producto
		cant = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Cantidad", "Por favor ingrese un número entero positivo");
		if (controlError) {System.out.println(); return;}

		//Ingreso de la categoría
		categoria = ControlErrorDatos.controlByte((byte) 1, (byte) Producto.categorias.length, sb.toString(), "Por favor ingrese un número entero");
		if (controlError) {System.out.println(); return;}

		System.out.println(vend.subirProducto(nombre, (byte) (categoria - 1), precio, cant));
	}

	@Override
	public String toString() {return "Subir producto";}
}