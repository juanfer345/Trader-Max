package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.VentanaAplicacion;

public class ControlCerrarSesion extends OpcionDeMenu implements ActionListener {
	public static JMenuBar barraMenu = new JMenuBar();

	@Override
	public void actionPerformed(ActionEvent e) {

		// Caso A: Ventana de invitado

		// Remoci�n de los elementos del panel
		VentanaAplicacion.panelPrincipal.removeAll();

		// Borrado de items anteriores y creaci�n de items nuevos del men�
		InicializacionAplicacion.setUsuarioActivo(new Visitante());
		JMenuItem inicio = new JMenuItem("Inicio");
		JMenu menuProcesos = new JMenu("Procesos y Consultas");
		JMenu menuAyuda = new JMenu("Ayuda");
		JMenuItem opcionDeMenu;

		// Creaci�n de los subitems del men� - [Inicio]

		// Men� Procesos
		inicio.addActionListener(new ControlInicio()); // Opci�n para volver a la pantalla inicial
		menuProcesos.add(inicio);
		ArrayList<OpcionDeMenu> menu = MenuDeConsola.menuActivo;
		for (int i = 0; i < menu.size(); i++) {
			opcionDeMenu = new JMenuItem(menu.get(i).toString());
			menuProcesos.add(opcionDeMenu);
			opcionDeMenu.addActionListener(menu.get(i));
		}

		// Men� Ayuda
		opcionDeMenu = new JMenuItem("Acerca de");
		menuAyuda.add(opcionDeMenu);
		opcionDeMenu.addActionListener(new ControlAcercaDe());

		// Creaci�n de los subitems del men� - [Fin]

		// A�adiendo cada men� a la barra
		barraMenu.add(menuProcesos);
		barraMenu.add(menuAyuda);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cerrar sesi�n";
	}

}
