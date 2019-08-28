package control.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Cuenta.Comprador.PanelMostrarCarrito;

public class ControlMostrarCarrito extends OpcionDeMenu implements ActionListener, MouseMotionListener {
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseMoved(MouseEvent arg) {}
	@Override

	public void actionPerformed(ActionEvent arg) {

		if (arg.getSource() instanceof JMenuItem) {
			// Caso A: Se elige la opción del menú y se requiere mostrar el formulario

			//Remoción de los elementos del panel
			VentanaAplicacion.panelPrincipal.removeAll();
			PanelUsuario panelresultados= new PanelUsuario();
			panelresultados.panelCambiante.removeAll();
			panelresultados.panelCambiante.setLayout(new BorderLayout());
			PanelMostrarCarrito carrito = new PanelMostrarCarrito();
			panelresultados.panelCambiante.add(carrito);
			VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);
			carrito.asignarOyente();

			// Añadiendo los nuevos elementos para la ventana de usuario
		}
		else if (arg.getSource() instanceof JButton) {
			if (arg.getActionCommand().equals("Vaciar carrito")){
				if (CarritoDeCompras.getProductos().size()>0) {				
				CarritoDeCompras.vaciarCarrito();
				VentanaAplicacion.panelPrincipal.removeAll();
				PanelUsuario panelresultados= new PanelUsuario();
				panelresultados.panelCambiante.removeAll();
				panelresultados.panelCambiante.setLayout(new BorderLayout());
				panelresultados.panelCambiante.add(new PanelMostrarCarrito());
				VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);
				}
				else {
					JOptionPane.showMessageDialog(null, "El Carrito se encuentra vacío", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			//else if(arg.getActionCommand().equals("Quitar")){ 
//			if(CarritoDeCompras.getProductos().)
//				Comprador comprad = (Comprador) InicializacionAplicacion.usuarioActivo;
//				String cod = arg.getActionCommand();
//				int codigo = Integer.parseInt(cod);
//		        String cantidad = JOptionPane.showInputDialog(null, "Cantidad que desea quitar:");
//		        int cant = 0;
//		    	try {
//					cant = ErrorAplicacion.controlEntero((cantidad), 1, Integer.MAX_VALUE, "Cantidad", "Por favor ingrese la cantidad a quitar");
//				}
//				catch (IOException e1) {
//					JOptionPane.showMessageDialog(
//							null, "Manejo de errores de la Aplicación: " + e1.getMessage(), 
//							"Error", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
//		        CarritoDeCompras. quitarProducto(codigo, cant);
//			}
//			
		}
		//VentanaAplicacion.organizar();
	}
	@Override
	public String toString() {
		return "Ver los productos del carrito";
	}

}
