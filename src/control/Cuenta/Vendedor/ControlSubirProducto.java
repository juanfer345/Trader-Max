package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

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

	/*
	 * Prop�sito: Ejecutar el metodo subirProducto() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent arg) {

		if (arg.getSource() instanceof JMenuItem) {
			// Caso A: Se elige la opci�n del men� y se requiere mostrar el formulario

			//Remoci�n de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();
			//A�adiendo los nuevos elementos para la ventana de usuario
			PanelUsuario panelresultados = new PanelUsuario();
			panelresultados.panelCambiante.removeAll();

			//A�adiendo los nuevos elementos para la ventana de usuario
			panelresultados.panelCambiante.add(formulario = new FieldPanel("Datos",
					new String[] { "Nombre del producto", "Precio",	"Cantidad"},
					"Valor", new String[] { null, null, null},
					new boolean[] { true, true, true}));
			VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);

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
							"\"Cedula\"", "Por favor ingrese un precio v�lido");

					// Control de ingreso de cantidad
					cantidadIngresada = MetodosConError.controlNumero(formulario.getValue("Cantidad"), 1, Integer.MAX_VALUE, 
							"\"Cedula\"", "Por favor ingrese una cantidad v�lida");
				}
				catch (ErrorAplicacion e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String categorias[] = { "Belleza", "Veh�culos", "Deportes", "Electrodom�sticos", "Hogar", "Juegos", "Libros",
						"M�sica", "Tecnolog�a", "Vestimenta", "Vivienda" };
				String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una categoria", "CATEGORIAS",
						JOptionPane.QUESTION_MESSAGE, null, categorias, "Seleccione");
				
				byte categoria =0;
				for (byte i = 0; i < categorias.length; i++) {
					if(categorias[i].contentEquals(seleccion)) {
						categoria = i;
					}
				}
				categoria++;
				// Ejecuci�n e impresi�n del m�todo
				JOptionPane.showMessageDialog(
					null, usuario.subirProducto(nombreIngresado, categoria, precioIngresado, cantidadIngresada), 
					"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
				
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