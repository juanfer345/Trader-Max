package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelLogin;

public class ControlInicioSesion extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo iniciarSesion() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent arg) {

		PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
		Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;

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

		String correoIngresado, contrasenaIngresada;

		correoIngresado = panel.texto_2.getText();
		contrasenaIngresada = panel.texto_3.getText();

		try {
			MetodosConError.errorSinCuentas(Cuenta.getTotalCuentas(), "No hay cuentas registradas en la base de datos.");
			JOptionPane.showMessageDialog(
					null, usuario.iniciarSesion(tipoCuenta, correoIngresado, contrasenaIngresada), 
					"Notificación", JOptionPane.INFORMATION_MESSAGE);

		}
		catch (ErrorAplicacion e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (OpcionDeMenu.controlError) {

			//Remoción de los elementos del panel de invitado
			VentanaAplicacion.panelPrincipal.removeAll();

			//Eliminando la barra del usuario invitado
			VentanaAplicacion.barraMenu.removeAll();

			//Añadiendo los nuevos elementos para la ventana de usuario
			VentanaAplicacion.panelPrincipal.add(new PanelUsuario());
		}
		VentanaAplicacion.organizar();
	}

	public String toString() {
		return "Iniciar sesión";
	}
}