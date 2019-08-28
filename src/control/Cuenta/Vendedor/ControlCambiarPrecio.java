package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlCambiarPrecio extends OpcionDeMenu implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		//HashMap<Integer, Producto> productos = vend.verProductos();
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
        String precio = JOptionPane.showInputDialog(null, "Nuevo precio del producto:");
        int pre = 0;
        
    	try {
			pre = MetodosConError.controlNumero(precio, 1, Integer.MAX_VALUE, "Precio", "Por favor ingrese un precio válido");
		}
		catch (ErrorAplicacion a) {
			JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
        vend.cambiarPrecio(codigo, pre);
        
    }
	
	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}