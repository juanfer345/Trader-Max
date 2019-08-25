package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AcercaDe implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, 
				"Autores de la aplicación:\n\n" +
				"- Sara Catalina Balbín Ramírez\n" + 
				"- Juan Manuel Cárdenas Vélez\n" + 
				"- María Paulina García Velásquez\n" + 
				"- Julián Camilo Ossa Zapata\n" + 
				"- Juan Fernando Patiño Castro\n"
				, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
	}
}