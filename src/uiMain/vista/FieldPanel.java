package uiMain.vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
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
		JPanel panelInterno = new JPanel();

		// Dimensiones del panel
		this.setLayout(new FlowLayout());	
		panelInterno.setLayout(new GridLayout(totalCriterios + 2, 2, 50, 20));
		//criterios.length + 2 debido a que además de los criterios se debe contar un renglón para los espácios y otro para los botones

		// Títulos formulario
		panelInterno.add(new JLabel(tituloCriterios));
		panelInterno.add(new JLabel(tituloValores));

		// Conversión y guardado de las cadenas de texto de los criterios en un arreglo de etiquetas
		JLabel[] auxC = new JLabel[totalCriterios];
		for (i = 0; i < totalCriterios; i++) {auxC[i] = new JLabel (criterios[i] + ":");}
		this.criterios = new ArrayList <JLabel> (Arrays.asList(auxC));

		// Conversión y guardado de las cadenas de texto de los valores en un arreglo de campos de texto
		JTextField[] auxV = new JTextField[totalCriterios];
		for (i = 0; i < totalCriterios; i++) {auxV[i] = new JTextField (valores[i]);}
		this.valores = new ArrayList <JTextField> (Arrays.asList(auxV));

		// Agregando los parámetros obtenidos al formulario
		for (i = 0; i < totalCriterios; i++) {

			// Se añade la pinche etiqueta
			panelInterno.add(this.criterios.get(i));

			// Se añade el pinche campo de texto (y se utiliza "habilitado" para ponerlo activa'o o desactiva'o)
			panelInterno.add(this.valores.get(i));
			this.valores.get(i).setEditable(habilitado[i]);
		}

		// Agregando los botones
		panelInterno.add(boton_acep); panelInterno.add(boton_borr);

		// Agregando todo al panel
		this.add(panelInterno);
	}

	public String getValue(String criterio) {
		/*
		 * @arg criterio el criterio cuyo valor se quiere obtener
		 * @return el valor del criterio cuyo nombre es 'criterio'
		 */
		int indice = 0;

		for (JLabel jL : criterios) {
			if (jL.getText().equals(criterio + ":")) {
				indice = criterios.indexOf(jL);
				break;
			}
		}
		return valores.get(indice).getText();
	}

	// Método para borrar todos los valores del formulario
	public void borrarValores() {
		for (JTextField valor : valores) {
			if (valor.isEditable()) {
				valor.setText(null);
			}
		}
	}
}