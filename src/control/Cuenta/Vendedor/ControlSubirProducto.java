package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.FieldPanel;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;

public class ControlSubirProducto extends OpcionDeMenu implements ActionListener {
	FieldPanel formulario;

	@Override
	public void actionPerformed(ActionEvent arg) {
		/*
		   Prop�sito: Ejecutar el m�todo registrarse() o hacer aparecer su formulario 
	   				  haciendo los respectivos controles de error del ingreso de datos
		 */

		if (arg.getSource() instanceof JMenuItem) {
			// Caso A: Se elige la opci�n del men� y se requiere mostrar el formulario

			//Remoci�n de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			//A�adiendo los nuevos elementos para la ventana de usuario
			VentanaAplicacion.panelPrincipal.add(formulario = new FieldPanel("Datos",
					new String[] { "Nombre del producto", "Precio",	"Cantidad"},
					"Valor", new String[] { null, null, null},
					new boolean[] { true, true, true}));

			//A�adiendo los oidores a los botones
			formulario.boton_acep.addActionListener(this);
			formulario.boton_borr.addActionListener(this);
		}
		else if (arg.getSource() instanceof JButton) {
			
			if (arg.getActionCommand().equals("Aceptar")) {

				// Caso B: Se ha llenado el formulario y se a presionado aceptar

				Vendedor usuario = (Vendedor) InicializacionAplicacion.usuarioActivo;
				String nombreIngresado = null;
				int cantidadIngresada = 0;
				Double precioIngresado = 0.0;
				
				try {

					// Control de ingreso de nombre
					nombreIngresado = MetodosConError.controlString(formulario.getValue("Nombre"), 
							"\"Nombre\"", "Ha ingresado un n�mero en lugar de texto en el campo \"Nombre\"");

					// Control de ingreso de precio
					precioIngresado = MetodosConError.controlNumero(formulario.getValue("Precio"), 1, Double.MAX_VALUE, 
							"\"Cedula\"", "Por favor ingrese una c�dula v�lida");

					// Control de ingreso de cantidad
					cantidadIngresada = MetodosConError.controlNumero(formulario.getValue("Precio"), 1, Integer.MAX_VALUE, 
							"\"Cedula\"", "Por favor ingrese una c�dula v�lida");
				}
				catch (ErrorAplicacion e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Ejecuci�n e impresi�n del m�todo
//				JOptionPane.showMessageDialog(
//						null, usuario.registrarse(tipoDeCuenta, nombreIngresado, correoIngresado, cedulaIngresada, contrasenaIngresada), 
//						"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
				
				//Volviendo al panel principal
				
				//Remoci�n de los elementos del panel
				VentanaAplicacion.panelPrincipal.removeAll();

				//Eliminando la barra del usuario invitado
				VentanaAplicacion.barraMenu.removeAll();
				
				//A�adiendo los nuevos elementos para la ventana de usuario
				VentanaAplicacion.panelPrincipal.add(new PanelUsuario());
			}
			else if (arg.getActionCommand().equals("Borrar")) {
				// Caso C: Se presionado borrar
				formulario.borrarValores();
			}
		}
		VentanaAplicacion.organizar();
	}

	@Override
	public String toString() {return "Subir producto";}
}