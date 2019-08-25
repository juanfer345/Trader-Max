package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlErrorDatos;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarTodasLasOpciones implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		
byte seleccion;
		
		//Guardado de mensaje principal
		System.out.println();
//		sb.append("Usted ha elegido mostrar todas las opciones de menu existentes. �Que desea hacer?\n");
//		sb.append("1. Continuar con el proceso\n");
//		sb.append("2. Volver al men� y cancelar el proceso\n");
//		sb.append("Selecci�n");

		// Ingreso del dato por parte del usuario
		seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
		if (OpcionDeMenu.controlError || seleccion == 2) {System.out.println(); return;}

		//Mostrado de todas las opciones
		System.out.println(OpcionDeMenu.ImprimirTodasLasOpciones());
	}

	
}
