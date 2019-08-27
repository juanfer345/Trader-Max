package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import uiMain.vista.FieldPanel;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;

public class ControlCambiarPrecio extends OpcionDeMenu implements ActionListener {

	FieldPanel formulario;

	@Override
	public void actionPerformed(ActionEvent arg) {
		/*
		 * Prop�sito: Ejecutar el m�todo cambiarPrecio() o hacer aparecer su formulario
		 * haciendo los respectivos controles de error del ingreso de datos
		 */
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;

		if (arg.getSource() instanceof JMenuItem) {

			// Remoci�n de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();

			// A�adiendo los nuevos elementos para la ventana de usuario
			VentanaAplicacion.panelPrincipal
					.add(formulario = new FieldPanel("Datos", new String[] { "Codigo del Producto", "Nuevo Precio" },
							"Valor", new String[] { null, null }, new boolean[] { true, true }));

			// A�adiendo los oidores a los botones
			formulario.boton_acep.addActionListener(this);
			formulario.boton_borr.addActionListener(this);
			
		} else if (arg.getSource() instanceof JButton) {

			if (arg.getActionCommand().equals("Aceptar")) {

				// Caso B: Se ha llenado el formulario y se ha presionado aceptar
				int codigo = 0;
				double precio = 0;

				// Control de ingreso codigo
				try {
					codigo = ErrorAplicacion.controlEntero(formulario.getValue("Codigo del Producto"), 1,
							Integer.MAX_VALUE, "\"Codigo\"",
							"Por favor ingrese un n�mero entero en el campo \"Codigo\".");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicaci�n: " + e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Control de ingreso de precio
				try {
					precio = ErrorAplicacion.controlReal2(formulario.getValue("Nuevo Precio"), 1, Double.MAX_VALUE,
							"Precio", "Por favor un precio valido");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicaci�n: " + e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Ejecuci�n e impresi�n del m�todo
				JOptionPane.showMessageDialog(null, vend.cambiarPrecio(codigo, precio), "Notificaci�n",
						JOptionPane.INFORMATION_MESSAGE);

				// Volviendo al panel principal

				// Remoci�n de los elementos del panel
				VentanaAplicacion.panelPrincipal.removeAll();

				// A�adiendo los nuevos elementos para la ventana de usuario
				VentanaAplicacion.panelPrincipal.add(new PanelUsuario());

				// A�adiendo la barra del usuario
				VentanaAplicacion.setMenuBarUsuario();

			} else if (arg.getActionCommand().equals("Borrar")) {
				formulario.borrarValores();
			}
		}
		VentanaAplicacion.organizar();
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}
