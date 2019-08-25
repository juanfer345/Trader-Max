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

			//Ingreso del código
			//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto al que le desea añadir la reseña", "El dato que ingresó como código es invalido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ingreso de las estrellas
			//cantEst = ControlErrorDatos.controlByte((byte) 1, (byte) 5, "Ingrese el numero de estrellas", "El dato que ingresó como numero de estrellas es invalido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ingreso del comentario
			//comentario = ControlErrorDatos.controlString("Ingrese el comentario", "Ha ingresado un número en lugar de texto");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ejecución del método
			//System.out.println(comp.anadirResena(idProducto, cantEst, comentario));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
		}
	} else {
		System.out.println("Su historial está vacio, no puede agregar reseñas.\n");
	}
		
	}
	public String toString() {
		return "Agregar reseña";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
