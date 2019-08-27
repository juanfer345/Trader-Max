package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import control.ErrorAplicacion;
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
        //desde aca juan fernando
    	try {
			pre = ErrorAplicacion.controlEntero((precio), 1, Integer.MAX_VALUE, "Precio", "Por favor ingrese un precio válido");
		}
		catch (IOException e1) {
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