package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlModificarCantidad extends OpcionDeMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		Double codigo = Double.parseDouble(cod);
        String precio = JOptionPane.showInputDialog(null, "Ingrese el monto a sumar o restar\n(Numero positivo o negativo)");
        int pre = 0;

    	try {
			pre = MetodosConError.controlNumero(precio, 1, Integer.MAX_VALUE, "Precio", "Por favor ingrese un precio válido");
		}
		catch (ErrorAplicacion e1) {
			JOptionPane.showMessageDialog(
					null, "Manejo de errores de la Aplicación: " + e1.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
        //vend.cambiarPrecio(codigo, pre);
        
    }


	public String toString() {
		return "Modificar la cantidad de un producto";
	}


}