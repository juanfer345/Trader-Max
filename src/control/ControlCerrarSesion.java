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

		// Remoción de los elementos del panel
		VentanaAplicacion.panelPrincipal.removeAll();

		// Borrado de items anteriores y creación de items nuevos del menú
		InicializacionAplicacion.setUsuarioActivo(new Visitante());
		JMenuItem inicio = new JMenuItem("Inicio");
		JMenu menuProcesos = new JMenu("Procesos y Consultas");
		JMenu menuAyuda = new JMenu("Ayuda");
		JMenuItem opcionDeMenu;

		// Creación de los subitems del menú - [Inicio]

		// Menú Procesos
		inicio.addActionListener(new ControlInicio()); // Opción para volver a la pantalla inicial
		menuProcesos.add(inicio);
		ArrayList<OpcionDeMenu> menu = MenuDeConsola.menuActivo;
		for (int i = 0; i < menu.size(); i++) {
			opcionDeMenu = new JMenuItem(menu.get(i).toString());
			menuProcesos.add(opcionDeMenu);
			opcionDeMenu.addActionListener(menu.get(i));
		}

		// Menú Ayuda
		opcionDeMenu = new JMenuItem("Acerca de");
		menuAyuda.add(opcionDeMenu);
		opcionDeMenu.addActionListener(new ControlAcercaDe());

		// Creación de los subitems del menú - [Fin]

		// Añadiendo cada menú a la barra
		barraMenu.add(menuProcesos);
		barraMenu.add(menuAyuda);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cerrar sesión";
	}

}
