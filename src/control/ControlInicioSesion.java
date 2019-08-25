package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelLogin;
import uiMain.vista.VentanaAplicacion;

public class ControlInicioSesion implements ActionListener {
	
	PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
	Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
		
	@Override
	public void actionPerformed(ActionEvent arg) {

		OpcionDeMenu.controlError = false;
		byte tipoCuenta=0;
		switch (((String) arg.getActionCommand())) {
		
		case "Comprador Complete y Nuevamente Clic":
			tipoCuenta=1;
			break;
			
		case "Vendedor Complete y Nuevamente Clic":
			tipoCuenta=2;
			break;
			
		case "Administrador Complete y Nuevamente Clic":
			tipoCuenta=3;
			break;
		}
		
		OpcionDeMenu.controlError = false;
		
		String correoIngresado, contrasenaIngresada;
		
		correoIngresado = panel.texto_2.getText();
		contrasenaIngresada = panel.texto_3.getText();

		if (Cuenta.getTotalCuentas() != 0) {
			JOptionPane.showMessageDialog(
					null, usuario.iniciarSesion(tipoCuenta, correoIngresado, contrasenaIngresada), 
					"Notificación", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(
					null, "No hay cuentas registradas en la base de datos.", 
					"Notificación", JOptionPane.WARNING_MESSAGE);
		}
		
		if (OpcionDeMenu.controlError == true) {
			
			//Creación de los items del menú
			JMenu menuArchivo = new JMenu("Archivo");
			JMenu menuProcesos = new JMenu("Procesos y Consultas");
			JMenu menuAyuda = new JMenu("Ayuda");
			
			// Declaración del oyente
			ControlMenu oidorIS = new ControlMenu();
			JMenuItem opcionDeMenu;
			
			// Creación de los subitems del menú - [Inicio]
			
			// Menú Archivo 
			opcionDeMenu = new JMenuItem("Usuario");
			menuArchivo.add(opcionDeMenu);
			opcionDeMenu.addActionListener(oidorIS);
			
			//DISCUTIR: DEJAR O QUITAR LA OPCIÓN DE QUE EL ADMIN PUEDA BORRAR O AÑADIR UNA OPCIÓN 
			opcionDeMenu = new JMenuItem("Cerrar sesión");
			menuArchivo.add(new JMenuItem());
			opcionDeMenu.addActionListener(oidorIS);
			
			// Menú Procesos
			ArrayList<OpcionDeMenu> menu = MenuDeConsola.menuActivo;
			for (int i = 0; i < menu.size(); i++) {
				opcionDeMenu = new JMenuItem(menu.get(i).toString());
				menuProcesos.add(opcionDeMenu);
				opcionDeMenu.addActionListener(oidorIS);
			}
			
			// Menú Ayuda
			opcionDeMenu = new JMenuItem("Acerca de");
			menuAyuda.add(opcionDeMenu);
			opcionDeMenu.addActionListener(oidorIS);
			
			//Creación de los subitems del menú - [Fin]
			
			VentanaAplicacion.barraMenu.add(menuArchivo);
			VentanaAplicacion.barraMenu.add(menuProcesos);
			VentanaAplicacion.barraMenu.add(menuAyuda);
			
			panel.removeAll();
//			VentanaAplicacion((JPanel) (new PanelUsuario()));
		}
		
	}

}
