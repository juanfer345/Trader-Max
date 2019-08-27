package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import control.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlComprarProductos extends OpcionDeMenu implements ActionListener {
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseMoved(MouseEvent arg) {}
	@Override
	
	public void actionPerformed(ActionEvent arg) {
		byte seleccion=0;
		OpcionDeMenu.controlError = false;
		switch (((String) arg.getActionCommand())) {
		case "Comprar Productos":
			if (!CarritoDeCompras.getProductos().isEmpty()) {
				// Ingreso del dato por parte del usuario
				//seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingresó es inválido, vuelva a intentarlo");
				//if (OpcionDeMenu.controlError || seleccion == 2) {return;}

				//Ejecución del método
				JOptionPane.showMessageDialog(null, CarritoDeCompras.comprarProductos(), "Comprar Productos", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Su carrito de compras esta vacío, no hay ningún producto pendiente por comprar.", "Comprar Productos", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	@Override
	public String toString() {
		return "Comprar productos del carrito";
	}

}
