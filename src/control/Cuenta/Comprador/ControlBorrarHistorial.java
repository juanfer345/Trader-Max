package control.Cuenta.Comprador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.Errores.ErrorAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Cuenta.Comprador.PanelMostrarHistorial;

public class ControlBorrarHistorial extends OpcionDeMenu implements ActionListener {//OpcionDeMenu.controlError

	/*
	 * Prop�sito: Ejecutar el metodo borrarHistorial() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] opciones = { "Si", "No" };
		Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
		
		if (!comp.getHistorial().isEmpty()) {
			int resp = JOptionPane.showOptionDialog(null, "�Est� seguro que desea quitar el producto?",
				"Quitar Producto de Carrito", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
				opciones[0]);
		if (JOptionPane.OK_OPTION == resp) {	
			
			//Ejecuci�n del m�todo
			comp.borrarHistorial();
			VentanaAplicacion.panelPrincipal.removeAll();
			PanelUsuario panelresultados= new PanelUsuario();
			panelresultados.panelCambiante.removeAll();
			
			PanelMostrarHistorial historial = new PanelMostrarHistorial();
			panelresultados.panelCambiante.add(historial);
			VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);
			historial.asignarOyente();
			
		} }
		else {
			JOptionPane.showMessageDialog(null, "El cat�logo se encuentra vac�o", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		VentanaAplicacion.organizar();

	}
	public String toString() {
		return "Borrar Historial";
	}

}
