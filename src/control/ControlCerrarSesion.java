package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import baseDatos.EscrituraBD;
import control.Errores.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.CuentaUsuario;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelLogin;

public class ControlCerrarSesion extends OpcionDeMenu implements ActionListener {
	public static JMenuBar barraMenu = new JMenuBar();

	/*
	 * Propósito: Ejecutar el metodo cerrarSesion() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		CuentaUsuario usuario = (CuentaUsuario) InicializacionAplicacion.usuarioActivo;
		Object[] opciones = {"Si", "No"};
		int resp;

		if (usuario instanceof Comprador && CarritoDeCompras.getTotalproductos() > 0) {
			JOptionPane.showMessageDialog(null, "Los productos no comprados serán eliminados del Carrito de Compras",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		
		resp = JOptionPane.showOptionDialog(null, "¿Está seguro que desea cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (JOptionPane.OK_OPTION == resp) {
			JOptionPane.showMessageDialog(null, usuario.cerrarSesion(),	"Notificación", JOptionPane.INFORMATION_MESSAGE);

			// Remoción de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			// Asignando el visitante como usuario activo
			InicializacionAplicacion.setUsuarioActivo(new Visitante());

			// Añadiendo el panel de visitante
			PanelLogin panel = new PanelLogin();
			VentanaAplicacion.panelPrincipal.add(panel);

			// Añadiendo las opciones de la barra
			VentanaAplicacion.setMenuBarInvitado();

			// Asignando los oyentes
			panel.asignarOyente();
		}
		VentanaAplicacion.organizar();
	}

	@Override
	public String toString() {
		return "Cerrar sesión";
	}
}