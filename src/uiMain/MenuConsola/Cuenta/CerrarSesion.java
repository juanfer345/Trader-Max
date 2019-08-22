package uiMain.MenuConsola.Cuenta;

import java.io.IOException;

import control.ControlErrorDatos;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.CuentaUsuario;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		
		CuentaUsuario usuario = (CuentaUsuario) InicializacionAplicacion.usuarioActivo;
	    byte seleccion;

	    //Guardado de mensaje principal
		System.out.println();
		sb.append("�Desea cerrar sesi�n?\n");
		sb.append("1: Si.\n");
		sb.append("2: No.\n");
		if (usuario instanceof Comprador && CarritoDeCompras.getTotalproductos() > 0) {
			sb.append("Advertencia: los productos no comprados ser�n eliminados del carrito de compras.\n");
		}
		sb.append("Selecci�n");
		
	    //Ingreso de valores y control de error
		seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
		if (controlError) {System.out.println(); return;}
		
		//Ejecuci�n del m�todo e impresi�n de respuesta
		System.out.println(usuario.cerrarSesion(seleccion));
	}
	
	@Override
	public String toString() {return "Cerrar sesi�n";}
}