package uiMain.vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldPanel extends JPanel {
	/**
	 * crea un nuevo objeto de tipo FieldPanel
	 * 
	 * @arg tituloCriterios titulo para la columna "Criterio"
	 * @arg criterios array con los nombres de los criterios
	 * @arg tituloValores titulo para la columna "valor"
	 * @arg valores array con los valores iniciales; Si 'null', no hay valores
	 *      iniciales
	 * @arg habilitado array con los campos no-editables por el usuario; Si 'null',
	 *      todos son editables
	 * 
	 */
	String tituloCriterios;
	String[] criterios;
	String tituloValores;
	String[] valores; // null si no se pueden editar
	boolean[] habilitado; // null si no se pueden editar
	JButton boton_acep = new JButton("Aceptar");
	JButton boton_borr = new JButton("Borrar");
	
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {
		
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new GridLayout(criterios.length, 2, 15, 10));
		JLabel tituloCrit = new JLabel(tituloCriterios);
		JLabel tituloVal = new JLabel(tituloValores);
		formulario.add(tituloCrit);
		formulario.add(tituloVal);
		
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(1, 2, 200, 50));
		botones.add(boton_acep);
		botones.add(boton_borr);
		
		this.add(formulario);
		this.add(botones);

	}

//	public String getValue(String criterio) {
//		/**
//		 * @arg criterio el criterio cuyo valor se quiere obtener
//		 * @return el valor del criterio cuyo nombre es 'criterio'
//		 */
//
//	}
}