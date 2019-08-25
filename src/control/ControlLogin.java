package control;

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelLogin;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.InicializacionAplicacion;

public class ControlLogin implements MouseMotionListener, ActionListener {

	PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
	int contadorFotos = 2;
	Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg) {
		if (arg.getSource() instanceof JLabel) {
			panel.etiqueta_1.setForeground(Color.blue);
		}
		else if (arg.getSource() instanceof JButton) {
			panel.boton_4.setForeground(Color.red);
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
				panel.boton_2.removeActionListener(this);
				panel.boton_3.removeActionListener(this);
				panel.boton_5.removeActionListener(this);
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
				panel.boton_2.removeActionListener(this);
				panel.boton_3.removeActionListener(this);
				panel.boton_5.removeActionListener(this);
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
				panel.boton_2.removeActionListener(this);
				panel.boton_3.removeActionListener(this);
				panel.boton_5.removeActionListener(this);
				panel.boton_2.addActionListener(oidor);
				panel.boton_3.addActionListener(oidor);
				panel.boton_5.addActionListener(oidorIS);
				break;
			
			default:
				ImageIcon imagen;
				switch (contadorFotos) {
					case 1:
						imagen = new ImageIcon(System.getProperty("user.dir") + "\\src\\fotos\\foto1.png");
						imagen = new ImageIcon(imagen.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
						panel.boton_1.setIcon(imagen);
						contadorFotos++;
						break;
		
					case 2:
						imagen = new ImageIcon(System.getProperty("user.dir") + "\\src\\fotos\\foto2.jpg");
						imagen = new ImageIcon(imagen.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
						panel.boton_1.setIcon(imagen);
						contadorFotos++;
						break;
		
					case 3:
						imagen = new ImageIcon(System.getProperty("user.dir") + "\\src\\fotos\\foto3.jpg");
						imagen = new ImageIcon(imagen.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
						panel.boton_1.setIcon(imagen);
						contadorFotos = 1;
						break;
				}
				break;
		}
		VentanaAplicacion.ventana.pack();
		VentanaAplicacion.ventana.setLocationRelativeTo(null);
	}
}