package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarCatalogo extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {byte seleccion; 
	
	if (!Cuenta.getCatalogo().isEmpty()) {
		
		//Selecci�n por parte del usuario
		//seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
		//f (OpcionDeMenu.controlError || seleccion == 2) {System.out.println(); return;}

		System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCatalogo());
		if (!OpcionDeMenu.controlError)
			System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
	}
	else {
		System.out.println("El cat�logo se encuentra vac�o.\n");
	}
		
	}
	public String toString() {return "Mostrar todos los productos";}


}
