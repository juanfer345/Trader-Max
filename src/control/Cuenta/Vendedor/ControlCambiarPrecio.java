package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ErrorAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import uiMain.vista.FieldPanel;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;

public class ControlCambiarPrecio extends OpcionDeMenu implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
        String precio = JOptionPane.showInputDialog(null, "Nuevo precio del producto:");
        int pre = 0;
    	try {
			pre = ErrorAplicacion.controlEntero((precio), 1, Integer.MAX_VALUE, "Precio", "Por favor ingrese un precio válido");
		}
		catch (IOException e1) {
			JOptionPane.showMessageDialog(
					null, "Manejo de errores de la Aplicación: " + e1.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
        vend.cambiarPrecio(codigo, pre);
        
    }
	
	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}
