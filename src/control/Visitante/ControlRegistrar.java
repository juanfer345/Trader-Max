package control.Visitante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.ErrorTipodeDato;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.FieldPanel;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;

public class ControlRegistrar extends OpcionDeMenu implements ActionListener {

	FieldPanel formulario;

	@Override
	public void actionPerformed(ActionEvent arg) {
		/*
		   Propósito: Ejecutar el método registrarse() o hacer aparecer su formulario 
	   				  haciendo los respectivos controles de error del ingreso de datos
		 */

		if (arg.getSource() instanceof JMenuItem) {
			// Caso A: Se elige la opción del menú y se requiere mostrar el formulario

			//Remoción de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			//Añadiendo los nuevos elementos para la ventana de usuario
			VentanaAplicacion.panelPrincipal.add(formulario = new FieldPanel(
					"Datos Usuario",
					new String[] {"Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]", "Nombre", "Cédula", "Correo", "Contraseña"}, 
					"Valor", 
					new String[] {null, null, null, null, null}, 
					new boolean[] {true, true, true, true, true}));

			//Añadiendo los oidores a los botones
			formulario.boton_acep.addActionListener(this);
			formulario.boton_borr.addActionListener(this);
		}
		else if (arg.getSource() instanceof JButton) {
			if (arg.getActionCommand().equals("Aceptar")) {

				// Caso B: Se ha llenado el formulario y se a presionado aceptar - [Inicio]

				Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
				String nombreIngresado = null, correoIngresado = null, contrasenaIngresada = null, contrasenaConfirmacion = null;
				int cedulaIngresada = 0;
				byte tipoDeCuenta;

				try {
					// Control de ingreso tipo de cuenta
					tipoDeCuenta = MetodosConError.controlNumero(formulario.getValue("Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]"), 
							(byte) 1, (byte) 3, "\"Tipo de cuenta\"", "Por favor ingrese un número entero pequeño (byte) en el campo \"Tipo de cuenta\".");

					// Control de ingreso de nombre
					nombreIngresado = MetodosConError.controlString(formulario.getValue("Nombre"), 
							"\"Nombre\"", "Ha ingresado un número en lugar de texto en el campo \"Nombre\"");

					// Control de ingreso de cedula
					cedulaIngresada = MetodosConError.controlNumero(formulario.getValue("Cédula"), 1, Integer.MAX_VALUE, 
							"\"Cedula\"", "Por favor ingrese una cédula válida");

					// Control de ingreso de correo
					correoIngresado = MetodosConError.controlCorreo(formulario.getValue("Correo"));

					// Control de ingreso de contraseña
					contrasenaIngresada = MetodosConError.controlCampoVacio(formulario.getValue("Contraseña"), "\"Contraseña\"");

					//comprobacion contraseña
					contrasenaConfirmacion = JOptionPane.showInputDialog(null, "Confirme su contraseña");
					if (contrasenaConfirmacion != null) {
						if(!contrasenaConfirmacion.equals(contrasenaIngresada)) {
							JOptionPane.showMessageDialog(null, "La contraseña no coincidde NEA!", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else {
						return;
					}

					// Control de ingreso de contraseña secreta para usuarios administradores
					if (tipoDeCuenta == 3) {

						String contrasenaSecreta = JOptionPane.showInputDialog(null, "Ingrese la contraseña de administradores:");
						String resultado =  MetodosConError.controlString(contrasenaSecreta, 
								"\"Contraseña secreta\"", "Ha ingresado un número en lugar de texto en el campo");
						if (!resultado.equals(Administrador.getCodigoSecreto())) {
							return ;
						}
					}
				}
				catch (ErrorAplicacion e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Ejecución e impresión del método
				JOptionPane.showMessageDialog(
						null, usuario.registrarse(tipoDeCuenta, nombreIngresado, correoIngresado, cedulaIngresada, contrasenaIngresada), 
						"Notificación", JOptionPane.INFORMATION_MESSAGE);

				// Remoción de los elementos del panel
				VentanaAplicacion.panelPrincipal.removeAll();

				// Eliminando la barra del usuario invitado
				VentanaAplicacion.barraMenu.removeAll();

				// Añadiendo los nuevos elementos para la ventana de usuario
				VentanaAplicacion.panelPrincipal.add(new PanelUsuario());

				// Caso B: Se ha llenado el formulario y se a presionado aceptar - [Fin]
			}
			else if (arg.getActionCommand().equals("Borrar")) {
				// Caso C: Se presionado borrar
				formulario.borrarValores();
			}
		}
		VentanaAplicacion.organizar();
	}

	public String toString() {
		return "Registrarse";
	}
}