package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import uiMain.InicializacionAplicacion;
import uiMain.vista.PanelLogin;
import uiMain.vista.VentanaAplicacion;

public class ControlSalir implements MouseMotionListener{
	
	PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		panel.boton_4.setForeground(Color.red);
		JOptionPane.showMessageDialog(null, "Los productos no comprados serán eliminados del Carrito de Compras",
				  "Advertencia", JOptionPane.WARNING_MESSAGE);
		
		int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir de Trader-Max?");
		if (JOptionPane.OK_OPTION == resp) {
			JOptionPane.showMessageDialog(null, InicializacionAplicacion.usuarioActivo.salir((byte)1),
					"Notificación", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else {
		}
	}
}
