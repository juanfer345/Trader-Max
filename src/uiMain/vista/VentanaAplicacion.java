package uiMain.vista;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.ControlAcercaDe;
import control.ControlCerrarSesion;
import control.ControlInformacionUsuario;
import control.ControlInicio;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.Visitante.PanelLogin;

public class VentanaAplicacion extends JFrame {

	public static JFrame ventana;
	public static Container panelPrincipal;
	public static JMenuBar barraMenu = new JMenuBar();
	
	public VentanaAplicacion() {
		PanelLogin panel = new PanelLogin();
		panelPrincipal = this.getContentPane();
		panelPrincipal.add(panel);
		ventana = this;
		setJMenuBar(barraMenu);
		
		// Añadiendo la barra de opciones
		VentanaAplicacion.setMenuBarInvitado();
		
		panel.asignarOyente();
	}
	
	public static void setMenuBarInvitado () {
		
		// Borrado de items anteriores y creación de items nuevos del menú
		barraMenu.removeAll();
		JMenuItem inicio = new JMenuItem("Inicio");
		JMenu menuProcesos = new JMenu("Procesos y Consultas");
		JMenu menuAyuda = new JMenu("Ayuda");
		JMenuItem opcionDeMenu;
		
		// Creación de los subitems del menú - [Inicio]
		
		// Menú Procesos
		inicio.addActionListener(new ControlInicio());	// Opción para volver a la pantalla inicial
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
	
	public static void setMenuBarUsuario () {
		
		// Borrado de items anteriores y creación de items nuevos del menú
		barraMenu.removeAll();
		JMenuItem inicio = new JMenuItem("Página Principal");
		JMenuItem menuArchivo = new JMenu("Archivo");
		JMenu menuProcesos = new JMenu("Procesos y Consultas");
		JMenu menuAyuda = new JMenu("Ayuda");
		JMenuItem opcionDeMenu;
		
		// Creación de los subitems del menú - [Inicio]
		
		// Menú Archivo 
		opcionDeMenu = new JMenuItem("Usuario");
		menuArchivo.add(opcionDeMenu);
		opcionDeMenu.addActionListener(new ControlInformacionUsuario());
		
		//CONDICIONAL DE SI EL CERRAR SESIÓN EXISTE EN LA CUENTA, FALTA
		opcionDeMenu = new JMenuItem("Cerrar sesión");
		menuArchivo.add(new JMenuItem());
		opcionDeMenu.addActionListener(new ControlCerrarSesion());
		
		// Menú Procesos
		inicio.addActionListener(new ControlInicio());	// Opción para volver a la pantalla inicial
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
		barraMenu.add(menuArchivo);
		barraMenu.add(menuProcesos);
		barraMenu.add(menuAyuda);
	}
	
	public void lanzar() {
		// Parámetros principales
		this.setTitle("TRADER-MAX INC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		organizar();
		setVisible(true);				// visualiza la ventana
	}
	
	public static void organizar() {
		ventana.pack();							// coloca los componentes
		ventana.setLocationRelativeTo(null);	// centra la ventana en la pantalla
	}
}