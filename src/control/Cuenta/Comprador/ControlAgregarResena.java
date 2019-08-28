package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.FieldPanel;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;

public class ControlAgregarResena extends OpcionDeMenu implements ActionListener {

	FieldPanel formulario;String idProducto="";

	
	/*
	 * Propósito: Ejecutar el metodo agregarReseña() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	

	@Override
	public void actionPerformed(ActionEvent arg) {
		


	if(!(arg.getActionCommand().equals("Aceptar")||arg.getActionCommand().equals("Borrar"))) {
		idProducto=arg.getActionCommand();
		// Caso A: Se elige la opción del menú y se requiere mostrar el formulario

					//Remoción de los elementos del panel
					VentanaAplicacion.panelPrincipal.removeAll();
					//Añadiendo los nuevos elementos para la ventana de usuario
					PanelUsuario panelresultados = new PanelUsuario();
					panelresultados.panelCambiante.removeAll();

					//Añadiendo los nuevos elementos para la ventana de usuario
					panelresultados.panelCambiante.add(formulario = new FieldPanel(
				"Datos reseña",
				new String[] {"Estrellas(1 a 5)", "Comentario"}, 
				"Valorar", 
				new String[] {null, null}, 
				new boolean[] {true, true}));
				VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);
		//Añadiendo los oidores a los botones
		formulario.boton_acep.addActionListener(this);
		formulario.boton_borr.addActionListener(this);
	}


	else if (arg.getActionCommand().equals("Aceptar")) {

		// Caso B: Se ha llenado el formulario y se a presionado aceptar - [Inicio]

		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		
		int codigo = Integer.parseInt(idProducto);
		byte cantEst;
		String comentario = "";

		try {
			// Control de ingreso de estrellas
			cantEst = MetodosConError.controlNumero(formulario.getValue("Estrellas(1 a 5)"), 
					(byte) 1, (byte) 5, "\"Estrellas(1 a 5)\"", "Por favor ingrese un número entero pequeño (byte) en el campo \"Estrellas(1 a 5)\".");

			// Control de ingreso de comentario
			comentario = MetodosConError.controlString(formulario.getValue("Comentario"), 
					"\"Comentario\"", "Ha ingresado un número en lugar de texto en el campo \"Comentario\"");

		}
		catch (ErrorAplicacion e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Ejecución e impresión del método
		JOptionPane.showMessageDialog(
				null, comp.anadirResena(codigo,cantEst,comentario), 
				"Notificación", JOptionPane.INFORMATION_MESSAGE);

		//Remoción de los elementos del panel
		VentanaAplicacion.panelPrincipal.removeAll();

		//Eliminando la barra del usuario invitado
		VentanaAplicacion.barraMenu.removeAll();

		//Añadiendo los nuevos elementos para la ventana de usuario
		VentanaAplicacion.panelPrincipal.add(new PanelUsuario());

		// Caso B: Se ha llenado el formulario y se a presionado aceptar - [Fin]
	}
	else if (arg.getActionCommand().equals("Borrar")) {
		// Caso C: Se presionado borrar
		formulario.borrarValores();
	}



	VentanaAplicacion.organizar();
	}
	public String toString() {
		return "Agregar reseña";
	}
}