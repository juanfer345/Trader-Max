package uiMain.vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FieldPanel extends JPanel {
	/*
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
	
	ArrayList<JLabel> criterios;
	ArrayList<JTextField> valores; 	// null si no existe un valor inicial
	
	public JButton boton_acep = new JButton("Aceptar");
	public JButton boton_borr = new JButton("Borrar");
	
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
		
		int i, totalCriterios = criterios.length;
		
		// Dimensiones del panel
		this.setLayout(new GridLayout(totalCriterios + 2, 2, 15, 10));	
		//criterios.length + 2 debido a que además de los criterios se debe contar un renglón para los espácios y otro para los botones
		
		// Títulos formulario
		this.add(new JLabel(tituloCriterios));
		this.add(new JLabel(tituloValores));
		
		// Conversión y guardado de las cadenas de texto de los criterios en un arreglo de etiquetas
		JLabel[] auxC = new JLabel[totalCriterios];
		for (i = 0; i < totalCriterios; i++) {auxC[i] = new JLabel (criterios[i] + ":");}
		this.criterios = new ArrayList <JLabel> (Arrays.asList(auxC));
		
		// Conversión y guardado de las cadenas de texto de los valores en un arreglo de campos de texto
		JTextField[] auxV = new JTextField[totalCriterios];
		for (i = 0; i < totalCriterios; i++) {auxV[i] = new JTextField (criterios[i]);}
		this.valores = new ArrayList <JTextField> (Arrays.asList(auxV));
		
		// Agregando los parámetros obtenidos al formulario
		for (i = 0; i < totalCriterios; i++) {
			
			// Se añade la pinche etiqueta
			this.add(this.criterios.get(i));
			
			// Se añade el pinche campo de texto (y se utiliza "habilitado" para ponerlo activa'o o desactiva'o)
			this.add(this.valores.get(i));
			this.valores.get(i).setEditable(habilitado[i]);
		}
		
		// Agregando los botones
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(1, 2, 200, 50));
		botones.add(boton_acep); botones.add(boton_borr);
		this.add(botones);
	}
	
	public String getValue(String criterio) {
		/*
		 * @arg criterio el criterio cuyo valor se quiere obtener
		 * @return el valor del criterio cuyo nombre es 'criterio'
		 */
		
		return valores.get(criterios.indexOf(new JLabel (criterio))).getText();
	}
	
	public void borrarValores() {
		
		for (JTextField valor : valores) {
			if (valor.isEditable()) {
				valor.setText("null");
			}
		}
	}
}