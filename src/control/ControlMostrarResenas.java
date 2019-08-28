package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import control.ControlMostrarResenas;

public class ControlMostrarResenas extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
	String cod = e.getActionCommand();
    int codigo = Integer.parseInt(cod);
		
	String resenas =  InicializacionAplicacion.usuarioActivo.getCatalogo().get(codigo).mostrarResenas();
	
	JOptionPane.showMessageDialog(null, resenas,"Reseñas", JOptionPane.INFORMATION_MESSAGE);
		
	
	}
	
	public String toString() {
		return "Mostrar reseñas";
	}
}