package control.Cuenta.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.ErrorOtro;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.FieldPanel;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;


public class ControlAgregarOpcion extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		FieldPanel formulario = null;

		/*
			   Prop�sito: Ejecutar el m�todo registrarse() o hacer aparecer su formulario 
		   				  haciendo los respectivos controles de error del ingreso de datos
		 */

		if (e.getSource() instanceof JMenuItem) {
			// Caso A: Se elige la opci�n del men� y se requiere mostrar el formulario

			//Remoci�n de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			//A�adiendo los nuevos elementos para la ventana de usuario
			VentanaAplicacion.panelPrincipal.add(formulario = new FieldPanel(
					"Par�metros usuario",
					new String[] {"Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]", "Identificador usuario"}, 
					"Valor", 
					new String[] {null, null, null, null, null}, 
					new boolean[] {true, true, true, true, true}));

			//A�adiendo los oidores a los botones
			formulario.boton_acep.addActionListener(this);
			formulario.boton_borr.addActionListener(this);
		}
		else if (e.getSource() instanceof JButton) {

			if (e.getActionCommand().equals("Aceptar")) {

				// Caso B: Se ha llenado el formulario y se a presionado aceptar

				Administrador usuario = (Administrador) InicializacionAplicacion.usuarioActivo;
				String menuOpcionesDisponibles = null, auxiliar;
				int idUsuario = 0;
				String opciones [] = null;
				byte tipoDeCuenta = 0, opcionUsuario = 0;

				try {
					// Control de error cuando no hay cuentas
					MetodosConError.errorSinCuentas(Cuenta.getTotalCuentas(), "No hay usuarios resgistrados aparte de tu cuenta.");

					// Control de ingreso de tipo de cuenta
					tipoDeCuenta = MetodosConError.controlNumero(formulario.getValue("Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]"), 
							(byte) 1, (byte) 3, "\"Tipo de cuenta\"", "Por favor ingrese un n�mero entero peque�o (byte) en el campo \"Tipo de cuenta\".");

					//Control de ingreso de identificaci�n de usuario
					idUsuario = MetodosConError.controlNumero(formulario.getValue("Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]"), 
							(int) 1, (int) Integer.MAX_VALUE, "\"Identificador usuario\"", "Por favor ingrese un n�mero entero en el campo \"Tipo de cuenta\".");

					// Control de eliminaci�n a la misma cuenta
					if (idUsuario == usuario.getId() && tipoDeCuenta == 3) {
						throw new ErrorOtro("No es permitido que elimines opciones de tu propia cuenta, ingresa otra identificaci�n.");
					}

				}
				catch (ErrorAplicacion a) {
					JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				//Impresi�n de las opciones de men� del usuario
				auxiliar = usuario.getMenuDeConsola().mostrarOpcionesDeMenu(idUsuario, tipoDeCuenta);
				if (controlError) {

					JOptionPane.showMessageDialog(null, auxiliar, "Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
					controlError = false;

					//Guardado de las opciones disponibles a agregar
					menuOpcionesDisponibles = usuario.getMenuDeConsola().comprobarCantidadOpciones(idUsuario, tipoDeCuenta, (byte) 1);

					if (controlError) {
						JOptionPane.showMessageDialog(null, menuOpcionesDisponibles, "Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
						controlError = false;
					}
					else {return;}
				}
				else {return;}

				for (byte i = 1; i <= MenuDeConsola.getsizeOpcionesComp(); i++) {
					opciones[i - 1] = Byte.toString(i);
				}
				
				opcionUsuario = (byte) JOptionPane.showInputDialog(null, "Seleccione una opci�n", "Opcion a agregar",
						JOptionPane.QUESTION_MESSAGE, null, opciones, "Seleccione");
				
				//Ejecuci�n del m�todo principal
				JOptionPane.showMessageDialog(null, 
						usuario.getMenuDeConsola().agregarOpcion(idUsuario, tipoDeCuenta, (byte) (opcionUsuario - 1)), 
						"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);

				if (controlError) {
					//Remoci�n de los elementos del panel
					VentanaAplicacion.panelPrincipal.removeAll();

					//Eliminando la barra del usuario invitado
					VentanaAplicacion.barraMenu.removeAll();

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
	}

	public String toString() {
		return "Agregar opci�n";
	}
}