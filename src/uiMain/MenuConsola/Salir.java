/*	Clase Salir(p�blica)        
	
	Prop�sito: Opci�n de men� del usuario, le permite realizar acciones en el programa 
	           manipulando sus atributos y elementos
*/
package uiMain.MenuConsola;

import java.io.IOException;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;

public class Salir {

//	@Override
//	public void ejecutar() throws IOException {
//		/*
//		 Prop�sito: Ejecutar el metodo Salir() haciendo los respectivos
//		            controles de error del ingreso de datos
//		 */
//	    byte seleccion;
//	    
//	    //Guardado de mensaje principal
//		System.out.println();
//	    sb.append("�Est� seguro que desea salir de la aplicaci�n?\n");
//		sb.append("1: Si.\n");
//		sb.append("2: No.\n");
//		if (InicializacionAplicacion.usuarioActivo instanceof Comprador && CarritoDeCompras.getTotalproductos() > 0) {
//			sb.append("Advertencia: los productos no comprados ser�n eliminados del carrito de compras.\n");
//		}
//		sb.append("Selecci�n");
//		
//	    //Ingreso de valores y control de error
//		seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
//		if (controlError) {System.out.println(); return;}
//		
//		//Ejecuci�n del m�todo e impresi�n de respuesta
//		//System.out.println(InicializacionAplicacion.usuarioActivo.salir(seleccion));
//		if (!OpcionDeMenu.controlError)
//			System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
//	}
//	
//	@Override
//	public String toString() {return "Salir";}
}