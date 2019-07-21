/* 
   Clase ModificarCantidad (p�blica, hereda de OpcionDeMenu)
   
   Prop�sito:
   Opci�n de men� del usuario, le permite realizar acciones en el programa 
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
		   Prop�sito: Ejecutar el m�todo subirProducto() haciendo los respectivos 
		              controles de error del ingreso de datos
		 */
		
		// Atributos
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String nombre;
		double precio;
		int cant, i;
		byte categoria;

		//Guardado de mensaje principal
		sb.append("\nPor favor elija la categor�a ingresando su �ndice:\n");
		for (i = 0; i < categorias.length; i++) {
			sb.append((i + 1) + ". " + categorias[i] + '\n');
		}
		
		
		while (!controlError) {

			//Impresi�n del mensaje principal
			System.out.println("\nPor favor ingrese los datos del producto.");

			//Ingreso del nombre del producto
			nombre = ControlErrorDatos.controlString("Nombre", "Se est� ingresando un n�mero en lugar de un nombre");
			
			//Ingreso del precio del producto
			precio = ControlErrorDatos.controlReal(0.1, Double.MAX_VALUE, "Precio", "Por favor ingrese un n�mero real");
			
			//Ingreso de la cantidad del producto
			cant = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Cantidad", "Por favor ingrese un n�mero entero positivo");
			
			//Ingreso de la categor�a
			categoria = ControlErrorDatos.controlByte((byte) 1, (byte) Producto.categorias.length, sb.toString(), "Por favor ingrese un n�mero entero");
			if (controlError) {System.out.println(); return;}

			System.out.println(vend.subirProducto(nombre, categoria, precio, cant));
		}
	}

	@Override
	public String toString() {return "Subir producto";}
}