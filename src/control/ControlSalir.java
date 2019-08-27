package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import baseDatos.EscrituraBD;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Visitante.PanelLogin;

public class ControlSalir extends OpcionDeMenu implements MouseMotionListener{
	

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		PanelLogin panel = (PanelLogin) VentanaAplicacion.panelPrincipal.getComponent(0);
		
		panel.boton_4.setForeground(Color.red);
		metodoComunSalir();
	}
	public String toString() {
		return "Salir";
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		metodoComunSalir();
	}
	
	private void metodoComunSalir() {
		
		Object[] opciones = {"Si", "No"};
		
		if (InicializacionAplicacion.usuarioActivo instanceof Comprador && CarritoDeCompras.getTotalproductos() > 0) {
			JOptionPane.showMessageDialog(null, "Los productos no comprados serán eliminados del Carrito de Compras",
					  "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		
		int resp = JOptionPane.showOptionDialog(null, "¿Está seguro que desea salir de Trader-Max papirri?", "Salir", JOptionPane.YES_NO_OPTION, 
												JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		if (JOptionPane.OK_OPTION == resp) {
			JOptionPane.showMessageDialog(null, InicializacionAplicacion.usuarioActivo.salir(),
					"Notificación", JOptionPane.INFORMATION_MESSAGE);
			
			//Ejecución de la escritura en la base de datos
			EscrituraBD Escritor = new EscrituraBD();
			Escritor.PrincipalEscrituraBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Catálogo", "Productos", "Reseñas");
			
			//Saliendo de la aplicación
			System.exit(0);
		}
		VentanaAplicacion.organizar();
	}
}