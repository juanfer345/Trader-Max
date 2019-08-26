package control.Visitante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.FieldPanel;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelLogin;

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

				// Caso B: Se ha llenado el formulario y se a presionado aceptar

				Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
				String nombreIngresado = null, correoIngresado = null, contrasenaIngresada = null;
				int cedulaIngresada = 0;
				byte tipoDeCuenta;

				// Control de ingreso tipo de cuenta
				try {
					tipoDeCuenta = ErrorAplicacion.controlByte(formulario.getValue("Tipo de cuenta [1: Comprador, 2: Vendedor, 3: Administrador]"), 
							(byte) 1, (byte) 3, sb.toString(), "Por favor ingrese un número entero");
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(
							null, "Manejo de errores de la Aplicación: " + e.getMessage(), 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Control de ingreso de contraseña secreta para usuarios administradores
				if (tipoDeCuenta == 3) {

					//						System.out.print("Contraseña secreta para registro de administradores => ");
					//						String contrasenaSecreta;
					//						if (esByte(contrasenaSecreta = br.readLine().trim()) != 0) {
					//							if (contrasenaSecreta.equals(Administrador.getCodigoSecreto())) {
					//								break;
					//							} else {
					//								System.out.println("Contraseña incorrecta, el FBI pronto llegará a su casa.");
					//							}
					//						} else {
					//							System.out.println();
					//							return;
					//						}
					//PENDIENTE: MOSTRAR VENTANA PARA INGRESAR CONTRASEÑA SECRETA
				}

				// Control de ingreso de nombre
				try {
					nombreIngresado = ErrorAplicacion.controlString(formulario.getValue("Nombre"), "Ha ingresado un número en lugar de texto");
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(
							null, "Manejo de errores de la Aplicación: " + e.getMessage(), 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Control de ingreso de cedula
				try {
					cedulaIngresada = ErrorAplicacion.controlEntero(formulario.getValue("Cédula"), 1, Integer.MAX_VALUE, "Por favor ingrese una cédula válida");
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(
							null, "Manejo de errores de la Aplicación: " + e.getMessage(), 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Control de ingreso de correo
				try {
					correoIngresado = ErrorAplicacion.controlCorreo(formulario.getValue("Correo"));
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(
							null, "Manejo de errores de la Aplicación: " + e.getMessage(), 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Control de ingreso de contraseña
				contrasenaIngresada = formulario.getValue("Contraseña");
				//				if (!ControlErrorDatos.controlContrasena(contrasenaIngresada)) {System.out.println(); return;}
				//PENDIENTE: VENTANA PARA CONFIRMAR CONTRASEÑA

				// Ejecución e impresión del método
				JOptionPane.showMessageDialog(
						null, usuario.registrarse(tipoDeCuenta, nombreIngresado, correoIngresado, cedulaIngresada, contrasenaIngresada), 
						"Notificación", JOptionPane.INFORMATION_MESSAGE);
				
				//Volviendo al panel principal

				//Remoción de los elementos del panel
				VentanaAplicacion.panelPrincipal.removeAll();

				//Añadiendo los nuevos elementos para la ventana de usuario
				VentanaAplicacion.panelPrincipal.add(new PanelLogin());
			}
		}
		else if (arg.getActionCommand().equals("Borrar")) {
			// Caso C: Se presionado borrar
			formulario.borrarValores();
		}
	}

	public String toString() {
		return "Registrarse";
	}
}