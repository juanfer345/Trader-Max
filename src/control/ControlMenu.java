package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uiMain.vista.VentanaAplicacion;

public class ControlMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		VentanaAplicacion.ventana.pack();
		VentanaAplicacion.ventana.setLocationRelativeTo(null);
	}
}