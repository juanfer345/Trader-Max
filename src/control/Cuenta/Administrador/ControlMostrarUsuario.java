package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.FieldPanel;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarUsuario extends OpcionDeMenu implements ActionListener {

	FieldPanel formulario = null;

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
				   Prop�sito: Ejecutar el m�todo registrarse() o hacer aparecer su formulario 
			   				  haciendo los respectivos controles de error del ingreso de datos
		 */

		if (e.getSource() instanceof JMenuItem) {
			// Caso A: Se elige la opci�n del men� y se requiere mostrar el formulario

			//Remoci�n de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			//A�adiendo los nuevos elementos para la ventana de usuario
			PanelUsuario panelresultados = new PanelUsuario();
			panelresultados.panelCambiante.removeAll();

			panelresultados.panelCambiante.add(formulario = new FieldPanel(
					"Par�metros usuario",
					new String[] {"Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]", "Identificador usuario"}, 
					"Valor", 
					new String[] {null, null}, 
					new boolean[] {true, true}));

			VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);

			//A�adiendo los oidores a los botones
			formulario.boton_acep.addActionListener(this);
			formulario.boton_borr.addActionListener(this);
		}
		else if (e.getSource() instanceof JButton) {

			if (e.getActionCommand().equals("Aceptar")) {

				// Caso B: Se ha llenado el formulario y se a presionado aceptar
				Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
				int idUsuario = 0;
				byte tipoDeCuenta = 0;

				try {
					// Control de error cuando no hay cuentas
					MetodosConError.errorSinCuentas(Cuenta.getTotalCuentas(), "No hay usuarios resgistrados aparte de tu cuenta.");

					// Control de ingreso de tipo de cuenta
					tipoDeCuenta = MetodosConError.controlNumero(formulario.getValue("Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]"), 
							(byte) 1, (byte) 3, "\"Tipo de cuenta\"", "Por favor ingrese un n�mero entero peque�o (byte) en el campo \"Tipo de cuenta\".");

					//Control de ingreso de identificaci�n de usuario
					idUsuario = MetodosConError.controlNumero(formulario.getValue("Identificador usuario"), 
							(int) 1, (int) Integer.MAX_VALUE, "\"Identificador usuario\"", "Por favor ingrese un n�mero entero en el campo \"Identificador usuario\".");

				}
				catch (ErrorAplicacion a) {
					JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				//Impresi�n de las opciones de men� del usuario
				JOptionPane.showMessageDialog(null, usuario.mostrarUsuario(idUsuario, tipoDeCuenta), 
						"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);

				if (controlError) {
					//Remoci�n de los elementos del panel
					VentanaAplicacion.panelPrincipal.removeAll();

					//A�adiendo los nuevos elementos para la ventana de usuario
					VentanaAplicacion.panelPrincipal.add(new PanelUsuario());
				}
				else {return;}
			}
			else if (e.getActionCommand().equals("Borrar")) {

				// Caso C: Se presionado borrar
				formulario.borrarValores();
			}
		}
		VentanaAplicacion.organizar();
		controlError = false;
	}
	
	public String toString() {
		return "Mostrar usuario";
	}
}