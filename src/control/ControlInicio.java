package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelLogin;

public class ControlInicio implements ActionListener {

	// Este m�todo se utiliza para volver a la p�gina principal de cada ventana (Invitado o Usuario)
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Inicio")) {
			//Caso A: Ventana de invitado

			//Remoci�n de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			//A�adiendo los nuevos elementos para la ventana de invitado
			PanelLogin panel = new PanelLogin();
			VentanaAplicacion.panelPrincipal.add(panel);
			panel.asignarOyente();
		}
		else if (e.getActionCommand().equals("P�gina Principal")) {
			//Caso B: Ventana de usuario

			//Remoci�n de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			//A�adiendo los nuevos elementos para la ventana de usuario
			PanelUsuario panel = new PanelUsuario();
			VentanaAplicacion.panelPrincipal.add(panel);
		}
		VentanaAplicacion.organizar();
	}
}