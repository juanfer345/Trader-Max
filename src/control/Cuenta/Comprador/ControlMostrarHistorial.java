package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarHistorial extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
	byte seleccion=0;

	//Guardado de mensaje principal

	if (!comp.getHistorial().isEmpty()) {

		// Ingreso del dato por parte del usuario
		//seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
		if (OpcionDeMenu.controlError || seleccion == 2) {System.out.println(); return;}

		// Ejecución del método
		System.out.println(comp.mostrarHistorial());
	}
	else {
		System.out.println("Su historial se encuentra vacío, no hay reseñas para mostrar.\n");
	}
}

@Override
public String toString() {return "Mostrar historial";}

}
