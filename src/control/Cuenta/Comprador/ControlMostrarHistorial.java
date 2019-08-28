package control.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Errores.ErrorAplicacion;
import javax.swing.SwingConstants;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Cuenta.Comprador.PanelMostrarCarrito;
import uiMain.vista.Cuenta.Comprador.PanelMostrarHistorial;

public class ControlMostrarHistorial extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo mostrarHistorial() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		//Remoción de los elementos del panel
		VentanaAplicacion.panelPrincipal.removeAll();
		PanelUsuario panelresultados= new PanelUsuario();
		panelresultados.panelCambiante.removeAll();
		
		PanelMostrarHistorial historial = new PanelMostrarHistorial();
		panelresultados.panelCambiante.add(historial);
		VentanaAplicacion.panelPrincipal.add(panelresultados, SwingConstants.CENTER);
		historial.asignarOyente();
		
	VentanaAplicacion.organizar();
}
	
@Override
public String toString() {return "Mostrar historial";}

}
