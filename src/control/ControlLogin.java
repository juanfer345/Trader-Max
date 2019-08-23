package control;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uiMain.vista.PanelLogin;
import uiMain.vista.VentanaAplicacion;

public class ControlLogin implements MouseMotionListener, ActionListener {

	PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
	int contadorFotos = 1;

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg) {
		if (arg.getSource() instanceof JButton) {
			panel.boton_4.setForeground(Color.red);
		} 
		else if (arg.getSource() instanceof Label) {
			panel.etiqueta_1.setForeground(Color.blue);
		} 
		else if (arg.getSource() instanceof JPanel) {
			panel.boton_4.setForeground(Color.black);
			panel.etiqueta_1.setForeground(Color.black);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg) {

		switch (((String) arg.getActionCommand())) {
		case "Administrador":
			panel.boton_2.setText("Administrador Complete y Nuevamente Clic");
			panel.etiqueta_2.setVisible(true);
			panel.etiqueta_3.setVisible(true);
			panel.etiqueta_4.setVisible(true);
			panel.texto_2.setVisible(true);
			panel.texto_3.setVisible(true);
			break;

		case "Administrador Complete y Nuevamente Clic":
			
			// LANZAR EXEPCIÓN 1
			break;

		case "UsuarioComún":
			panel.boton_3.setText("UsuarioComún Complete y Nuevamente Clic");
			panel.etiqueta_2.setVisible(true);
			panel.etiqueta_3.setVisible(true);
			panel.etiqueta_4.setVisible(true);
			panel.texto_2.setVisible(true);
			panel.texto_3.setVisible(true);
			break;

		case "UsuarioComún Complete y Nuevamente Clic":
			// LANZAR EXEPCIÓN 2
			break;

		default:
			switch (contadorFotos) {
			case 1:
				panel.boton_1.setIcon(new ImageIcon("./fotos/foto1.png"));
				contadorFotos++;
				break;

			case 2:
				panel.boton_1.setIcon(new ImageIcon("./fotos/foto2.jpg"));
				contadorFotos++;
				break;

			case 3:
				panel.boton_1.setIcon(new ImageIcon("./fotos/foto3.jpg"));
				contadorFotos = 1;
				break;
			}
			break;
		}
	}
}