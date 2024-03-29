package control;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelLogin;

public class ControlLogin implements MouseMotionListener, ActionListener {

	/*
	 * Prop�sito: Controla la ventana inicial de la aplicaci�n
	 * y sus componentes
	 */

	PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
	int contadorFotos = 2;

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg) {
		if (arg.getSource() instanceof JLabel) {
			panel.etiqueta_1.setForeground(Color.blue);
		}
		else if (arg.getSource() instanceof JPanel) {
			panel.boton_4.setForeground(Color.black);
			panel.etiqueta_1.setForeground(Color.black);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg) {

		ControlInicioSesion oidorIS = new ControlInicioSesion();
		ControlLogin oidor = new ControlLogin();

		// CAMBIAR PARA QUE MUESTRE AQUI SI NO HAY CUENTAS INSCRITAS

		switch (((String) arg.getActionCommand())) {

		case "Administrador":
			panel.boton_2.setText("Administrador Complete y Nuevamente Clic");
			panel.boton_3.setText("Comprador");
			panel.boton_5.setText("Vendedor");
			panel.etiqueta_2.setVisible(true);
			panel.etiqueta_3.setVisible(true);
			panel.etiqueta_4.setVisible(true);
			panel.texto_2.setVisible(true);
			panel.texto_3.setVisible(true);
			for (ActionListener AL: Arrays.asList(panel.boton_2.getActionListeners())) {
				panel.boton_2.removeActionListener(AL);
			}
			for (ActionListener AL: Arrays.asList(panel.boton_3.getActionListeners())) {
				panel.boton_3.removeActionListener(AL);
			}
			for (ActionListener AL: Arrays.asList(panel.boton_5.getActionListeners())) {
				panel.boton_5.removeActionListener(AL);
			}
			panel.boton_3.addActionListener(oidor);
			panel.boton_5.addActionListener(oidor);
			panel.boton_2.addActionListener(oidorIS);
			break;

		case "Comprador":
			panel.boton_2.setText("Administrador");
			panel.boton_3.setText("Comprador Complete y Nuevamente Clic");
			panel.boton_5.setText("Vendedor");
			panel.etiqueta_2.setVisible(true);
			panel.etiqueta_3.setVisible(true);
			panel.etiqueta_4.setVisible(true);
			panel.texto_2.setVisible(true);
			panel.texto_3.setVisible(true);
			for (ActionListener AL: Arrays.asList(panel.boton_2.getActionListeners())) {
				panel.boton_2.removeActionListener(AL);
			}
			for (ActionListener AL: Arrays.asList(panel.boton_3.getActionListeners())) {
				panel.boton_3.removeActionListener(AL);
			}
			for (ActionListener AL: Arrays.asList(panel.boton_5.getActionListeners())) {
				panel.boton_5.removeActionListener(AL);
			}
			panel.boton_2.addActionListener(oidor);
			panel.boton_5.addActionListener(oidor);
			panel.boton_3.addActionListener(oidorIS);
			break;

		case "Vendedor":
			panel.boton_2.setText("Administrador");
			panel.boton_3.setText("Comprador");
			panel.boton_5.setText("Vendedor Complete y Nuevamente Clic");
			panel.etiqueta_2.setVisible(true);
			panel.etiqueta_3.setVisible(true);
			panel.etiqueta_4.setVisible(true);
			panel.texto_2.setVisible(true);
			panel.texto_3.setVisible(true);
			for (ActionListener AL: Arrays.asList(panel.boton_2.getActionListeners())) {
				panel.boton_2.removeActionListener(AL);
			}
			for (ActionListener AL: Arrays.asList(panel.boton_3.getActionListeners())) {
				panel.boton_3.removeActionListener(AL);
			}
			for (ActionListener AL: Arrays.asList(panel.boton_5.getActionListeners())) {
				panel.boton_5.removeActionListener(AL);
			}
			panel.boton_2.addActionListener(oidor);
			panel.boton_3.addActionListener(oidor);
			panel.boton_5.addActionListener(oidorIS);
			break;

		default:
			ImageIcon imagen;
			switch (contadorFotos) {
			case 1:
				imagen = new ImageIcon(System.getProperty("user.dir") + "\\src\\fotos\\Mensaje.jpg");
				panel.boton_1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 210, Image.SCALE_SMOOTH)));
				contadorFotos++;
				break;

			case 2:
				imagen = new ImageIcon(System.getProperty("user.dir") + "\\src\\fotos\\Foto 1.jpg");
				panel.boton_1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 210, Image.SCALE_SMOOTH)));
				contadorFotos++;
				break;

			case 3:
				imagen = new ImageIcon(System.getProperty("user.dir") + "\\src\\fotos\\Foto 2.jpg");
				panel.boton_1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 210, Image.SCALE_SMOOTH)));
				contadorFotos = 1;
				break;
			}
			break;
		}
		VentanaAplicacion.organizar();
	}
}