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

public class ControlLogin implements MouseMotionListener, ActionListener {

	PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
	int contadorFotos = 2;

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

		switch (((String) arg.getActionCommand())) {
			case "Administrador":
				panel.boton_2.setText("Administrador Complete y Nuevamente Clic");
				panel.boton_3.setText("UsuarioCom�n");
				panel.etiqueta_2.setVisible(true);
				panel.etiqueta_3.setVisible(true);
				panel.etiqueta_4.setVisible(true);
				panel.texto_2.setVisible(true);
				panel.texto_3.setVisible(true);
				break;
	
			case "UsuarioCom�n":
				panel.boton_2.setText("Administrador");
				panel.boton_3.setText("UsuarioCom�n Complete y Nuevamente Clic");
				panel.etiqueta_2.setVisible(true);
				panel.etiqueta_3.setVisible(true);
				panel.etiqueta_4.setVisible(true);
				panel.texto_2.setVisible(true);
				panel.texto_3.setVisible(true);
				break;

			case "Administrador Complete y Nuevamente Clic":
			case "UsuarioCom�n Complete y Nuevamente Clic":
	
				OpcionDeMenu.controlError = false;
				
				String correoIngresado, contrasenaIngresada;
				
				correoIngresado = panel.texto_2.getText();
				contrasenaIngresada = panel.texto_3.getText();

				if (Cuenta.getTotalCuentas() != 0) {
					JOptionPane.showMessageDialog(
							null, Visitante.iniciarSesion(correoIngresado, contrasenaIngresada), 
							"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(
							null, "No hay cuentas registradas en la base de datos.", 
							"Notificaci�n", JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				if (OpcionDeMenu.controlError == true) {
					
					//Creaci�n de los items del men�
					JMenu menuArchivo = new JMenu("Archivo");
					JMenu menuProcesos = new JMenu("Procesos y Consultas");
					JMenu menuAyuda = new JMenu("Ayuda");
					
					// Declaraci�n del oyente
					ControlMenu oidor = new ControlMenu();
					JMenuItem opcionDeMenu;
					
					// Creaci�n de los subitems del men� - [Inicio]
					
					// Men� Archivo 
					opcionDeMenu = new JMenuItem("Usuario");
					menuArchivo.add(opcionDeMenu);
					opcionDeMenu.addActionListener(oidor);
					
					//DISCUTIR: DEJAR O QUITAR LA OPCI�N DE QUE EL ADMIN PUEDA BORRAR O A�ADIR UNA OPCI�N 
					opcionDeMenu = new JMenuItem("Cerrar sesi�n");
					menuArchivo.add(new JMenuItem());
					opcionDeMenu.addActionListener(oidor);
					
					// Men� Procesos
					ArrayList<OpcionDeMenu> menu = MenuDeConsola.menuActivo;
					for (int i = 0; i < menu.size(); i++) {
						opcionDeMenu = new JMenuItem(menu.get(i).toString());
						menuProcesos.add(opcionDeMenu);
						opcionDeMenu.addActionListener(oidor);
					}
					
					// Men� Ayuda
					opcionDeMenu = new JMenuItem("Acerca de");
					menuAyuda.add(opcionDeMenu);
					opcionDeMenu.addActionListener(oidor);
					
					//Creaci�n de los subitems del men� - [Fin]
					
					VentanaAplicacion.barraMenu.add(menuArchivo);
					VentanaAplicacion.barraMenu.add(menuProcesos);
					VentanaAplicacion.barraMenu.add(menuAyuda);
					
					panel.removeAll();
//					VentanaAplicacion((JPanel) (new PanelUsuario()));
				}
				
				// LANZAR EXEPCI�N 2
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
	}
}