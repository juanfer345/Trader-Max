package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import uiMain.InicializacionAplicacion;

public class InformacionUsuario implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg) {
		JOptionPane.showMessageDialog(null, InicializacionAplicacion.usuarioActivo.toString(),
				  "Advertencia", JOptionPane.WARNING_MESSAGE);		
	}
}