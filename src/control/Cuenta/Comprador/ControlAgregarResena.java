package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlAgregarResena extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
	int idProducto;
	byte cantEst;
	String comentario = "";

	if (!comp.getHistorial().isEmpty()) {
		//sb.append(comp.mostrarHistorial());
		
		while (!OpcionDeMenu.controlError) {

			//Ingreso del c�digo
			//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto al que le desea a�adir la rese�a", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ingreso de las estrellas
			//cantEst = ControlErrorDatos.controlByte((byte) 1, (byte) 5, "Ingrese el numero de estrellas", "El dato que ingres� como numero de estrellas es invalido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ingreso del comentario
			//comentario = ControlErrorDatos.controlString("Ingrese el comentario", "Ha ingresado un n�mero en lugar de texto");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ejecuci�n del m�todo
			//System.out.println(comp.anadirResena(idProducto, cantEst, comentario));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
		}
	} else {
		System.out.println("Su historial est� vacio, no puede agregar rese�as.\n");
	}
		
	}
	public String toString() {
		return "Agregar rese�a";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
