package control;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	
			case "UsuarioComún":
				panel.boton_3.setText("UsuarioComún Complete y Nuevamente Clic");
				panel.etiqueta_2.setVisible(true);
				panel.etiqueta_3.setVisible(true);
				panel.etiqueta_4.setVisible(true);
				panel.texto_2.setVisible(true);
				panel.texto_3.setVisible(true);
				break;

			case "Administrador Complete y Nuevamente Clic":
			case "UsuarioComún Complete y Nuevamente Clic":
	
				String correoIngresado, contrasenaIngresada;
				
				correoIngresado = panel.texto_2.getText();
				contrasenaIngresada = panel.texto_3.getText();

				if (Cuenta.getTotalCuentas() != 0) {
					JOptionPane.showMessageDialog(
							null, Visitante.iniciarSesion(correoIngresado, contrasenaIngresada), 
							"Notificación", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(
							null, "No hay cuentas registradas en la base de datos.", 
							"Notificación", JOptionPane.WARNING_MESSAGE);
				}
				
				if (OpcionDeMenu.controlError = true) {
					
					//Creación de los items del menú
					JMenu menuArchivo = new JMenu("Archivo");
					JMenu menuProcesos = new JMenu("Procesos y Consultas");
					JMenu menuAyuda = new JMenu("Ayuda");
					
					// Declaración del oyente
					ControlMenu oidor = new ControlMenu();
					JMenuItem opcionDeMenu;
					
					// Creación de los subitems del menú - [Inicio]
					
					// Menú Archivo 
					opcionDeMenu = new JMenuItem("Usuario");
					menuArchivo.add(opcionDeMenu);
					opcionDeMenu.addActionListener(oidor);
					
					//DISCUTIR: DEJAR O QUITAR LA OPCIÓN DE QUE EL ADMIN PUEDA BORRAR O AÑADIR UNA OPCIÓN 
					opcionDeMenu = new JMenuItem("Cerrar sesión");
					menuArchivo.add(new JMenuItem());
					opcionDeMenu.addActionListener(oidor);
					
					// Menú Procesos
					ArrayList<OpcionDeMenu> menu = MenuDeConsola.menuActivo;
					for (int i = 0; i < menu.size(); i++) {
						opcionDeMenu = new JMenuItem(menu.get(i).toString());
						menuProcesos.add(opcionDeMenu);
						opcionDeMenu.addActionListener(oidor);
					}
					
					// Menú Ayuda
					opcionDeMenu = new JMenuItem("Acerca de");
					menuAyuda.add(opcionDeMenu);
					opcionDeMenu.addActionListener(oidor);

					// Creación de los subitems del menú - [Fin]
					
					VentanaAplicacion.barraMenu.add(menuArchivo);
					VentanaAplicacion.barraMenu.add(menuProcesos);
					VentanaAplicacion.barraMenu.add(menuAyuda);

					//Creación de los subitems del menú - [Fin]

					
					panel.removeAll();
					
					panel.add( new PanelUsuario());
					
					VentanaAplicacion.ventana.pack();
				}
				
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