package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import baseDatos.EscrituraBD;
import control.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlEliminarProdCatalogo extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
		Object[] opciones = {"Si", "No"};
		
		int resp = JOptionPane.showOptionDialog(null, "¿Está seguro que desea borrar el producto?", "Advertencia", JOptionPane.YES_NO_OPTION, 
												JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		if (JOptionPane.OK_OPTION == resp) {
			JOptionPane.showMessageDialog(null, "El producto se ha borrado exitosamente",
					"Notificación", JOptionPane.INFORMATION_MESSAGE);
			vend.eliminarProductoCatalogo(codigo);
			
		}
		
	}

	public String toString() {return "Eliminar producto";}
}
