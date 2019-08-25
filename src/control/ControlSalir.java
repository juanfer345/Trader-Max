package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

import baseDatos.EscrituraBD;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelLogin;

public class ControlSalir implements MouseMotionListener{
	
	PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
	EscrituraBD Escritor = new EscrituraBD();

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		panel.boton_4.setForeground(Color.red);
		if (InicializacionAplicacion.usuarioActivo instanceof Comprador && CarritoDeCompras.getTotalproductos() > 0) {
			JOptionPane.showMessageDialog(null, "Los productos no comprados serán eliminados del Carrito de Compras",
					  "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		
		int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir de Trader-Max?");
		if (JOptionPane.OK_OPTION == resp) {
			JOptionPane.showMessageDialog(null, InicializacionAplicacion.usuarioActivo.salir(),
					"Notificación", JOptionPane.INFORMATION_MESSAGE);
			//Ejecución de la escritura en la base de datos
			Escritor.PrincipalEscrituraBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Catálogo", "Productos", "Reseñas");
			System.exit(0);
		} else {
		}
		VentanaAplicacion.ventana.pack();
		VentanaAplicacion.ventana.setLocationRelativeTo(null);
	}
}
