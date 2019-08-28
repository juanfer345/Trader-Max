package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlEliminarProdCatalogo extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo eliminarProductoCatalogo() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
		Object[] opciones = {"Si", "No"};
		
		int resp = JOptionPane.showOptionDialog(null, "¿Está seguro que desea borrar el producto?", "Advertencia", JOptionPane.YES_NO_OPTION, 
												JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		if (JOptionPane.OK_OPTION == resp) {
			JOptionPane.showMessageDialog(null, vend.eliminarProductoCatalogo(codigo),
					"Notificación", JOptionPane.INFORMATION_MESSAGE);
			;
			
		}
		
	}

	public String toString() {return "Eliminar producto";}
}
