package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControlAcercaDe implements ActionListener {
	
	/*
	 * Prop�sito: Da informaci�n acerca de los autores de la aplicaci�n
	 * (Sus nombres)
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, 
				"Autores de la aplicaci�n:\n\n" +
				"- Sara Catalina Balb�n Ram�rez\n" + 
				"- Juan Manuel C�rdenas V�lez\n" + 
				"- Mar�a Paulina Garc�a Vel�squez\n" + 
				"- Juli�n Camilo Ossa Zapata\n" + 
				"- Juan Fernando Pati�o Castro\n"
				, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
	}
}