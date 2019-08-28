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
import control.ControlMostrarResenas;
import control.ControlSalir;
import control.Cuenta.Comprador.ControlAgregarACarrito;
import control.Cuenta.Comprador.ControlAgregarResena;
import control.Cuenta.Comprador.ControlBorrarHistorial;
import control.Cuenta.Comprador.ControlComprarProductos;
import control.Cuenta.Comprador.ControlQuitarProductoCarrito;
import control.Cuenta.Comprador.ControlVaciarCarrito;
import control.Cuenta.Vendedor.ControlCambiarPrecio;
import control.Cuenta.Vendedor.ControlEliminarProdCatalogo;
import control.Cuenta.Vendedor.ControlModificarCantidad;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.Visitante.PanelLogin;

public class VentanaAplicacion extends JFrame {

	/*
	 * Propósito: Se encarga de la ventana de la Aplicacion
	 */
	
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
	
	public static JMenuBar getMenuBarUsuario () {
		
		// Creando referencia al usuario activo
		Cuenta usuario = InicializacionAplicacion.usuarioActivo;
		
		// Borrado de items anteriores y creación de items nuevos del menú
		JMenuBar barraMenu = new JMenuBar();
		JMenuItem menuArchivo = new JMenu("Archivo");
		JMenu menuProcesos = new JMenu("Procesos y Consultas");
		JMenu menuAyuda = new JMenu("Ayuda");
		JMenuItem opcionDeMenu;
		
		// Creación de los subitems del menú - [Inicio]
		
		// Menú Archivo
		
		// Opción para volver a la pantalla inicial
		opcionDeMenu = new JMenuItem("Página Principal");
		menuArchivo.add(opcionDeMenu);
		opcionDeMenu.addActionListener(new ControlInicio());
		
		// Opción para ver la información del usuario
		opcionDeMenu = new JMenuItem("Usuario");
		menuArchivo.add(opcionDeMenu);
		opcionDeMenu.addActionListener(new ControlInformacionUsuario());
		
		// Opción para cerrar sesión en la cuenta (solo si está activada)
		if (usuario.getMenuDeConsola().buscarOpcionDeMenu(new ControlCerrarSesion())) {
			opcionDeMenu = new JMenuItem("Cerrar sesión");
			menuArchivo.add(opcionDeMenu);
			opcionDeMenu.addActionListener(new ControlCerrarSesion());
		}

		// Opcion para salir de la aplicación (solo si está activada)
		if (usuario.getMenuDeConsola().buscarOpcionDeMenu(new ControlSalir())) {
			opcionDeMenu = new JMenuItem("Salir");
			menuArchivo.add(opcionDeMenu);
			opcionDeMenu.addActionListener(new ControlSalir());
		}
		
		// Menu procesos
		OpcionDeMenu[] opcionesNoMostrables = null;
		
		if (usuario instanceof Comprador) {
			opcionesNoMostrables = new OpcionDeMenu[] {
				new ControlMostrarResenas(), new ControlAgregarACarrito(), new ControlComprarProductos(), 
				new ControlQuitarProductoCarrito(), new ControlVaciarCarrito(), new ControlAgregarResena(), 
				new ControlBorrarHistorial(),new ControlCerrarSesion(), new ControlSalir()
			};
		}
		else if (usuario instanceof Vendedor) {
			opcionesNoMostrables = new OpcionDeMenu[] {
					new ControlMostrarResenas(), new ControlModificarCantidad(), new ControlCambiarPrecio(), 
					new ControlEliminarProdCatalogo(), new ControlCerrarSesion(), new ControlSalir()
				};
		}
		else if (usuario instanceof Administrador) {
			opcionesNoMostrables = new OpcionDeMenu[] {
					new ControlCerrarSesion(), new ControlSalir()
				};
		}
		opcionesParaMostrar(menuProcesos, opcionesNoMostrables);
//		ArrayList<OpcionDeMenu> menu = MenuDeConsola.menuActivo;
//		for (int i = 0; i < menu.size(); i++) {
//			opcionDeMenu = new JMenuItem(menu.get(i).toString());
//			menuProcesos.add(opcionDeMenu);
//			opcionDeMenu.addActionListener(menu.get(i));
//		}
		
		// Menú Ayuda
		opcionDeMenu = new JMenuItem("Acerca de");
		menuAyuda.add(opcionDeMenu);
		opcionDeMenu.addActionListener(new ControlAcercaDe());
		
		// Creación de los subitems del menú - [Fin]

		// Añadiendo cada menú a la barra
		barraMenu.add(menuArchivo);
		barraMenu.add(menuProcesos);
		barraMenu.add(menuAyuda);
		
		return barraMenu;
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
	
	/* Este método sirve para que en la barra de menú, en el submenú "menuProcesos" aparezcan solo las opciones 
	 * que deban aparecer (por ejemplo: un comprador no debería tener "agregar a carrito" en la barra, ya que 
	 * esta funcionalidad corresponde a un botón al mostrar el catálogo)
	 */
	private static void opcionesParaMostrar(JMenu menuProcesos, OpcionDeMenu[] opcionesNoMostrables) {
		
		ArrayList<OpcionDeMenu> menu = MenuDeConsola.menuActivo;
		boolean mostrable = true;
		
		for (int i = 0; i < menu.size(); i++) {
			
			for (int j = 0; j < opcionesNoMostrables.length; j++) {
				if (opcionesNoMostrables[j].getClass().equals(menu.get(i).getClass())) {
					mostrable = false; break;
				}
			}
			
			if (mostrable) {
				JMenuItem opcionDeMenu = new JMenuItem(menu.get(i).toString());
				menuProcesos.add(opcionDeMenu);
				opcionDeMenu.addActionListener(menu.get(i));
			}
			mostrable = true;
		}
	}
}