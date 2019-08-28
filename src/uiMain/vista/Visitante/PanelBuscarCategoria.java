package uiMain.vista.Visitante;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaModelo;

public class PanelBuscarCategoria extends JFrame {

	JTable tabla;

	public PanelBuscarCategoria() {

		String categorias[] = { "Belleza", "Vehículos", "Deportes", "Electrodomésticos", "Hogar", "Juegos", "Libros",
				"Música", "Tecnología", "Vestimenta", "Vivienda" };
		String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una categoria", "CATEGORIAS",
				JOptionPane.QUESTION_MESSAGE, null, categorias, "Seleccione");
		System.out.println(seleccion);

		Container panel = this.getContentPane();
		panel.setLayout(new BorderLayout(7, 20));

		JLabel titulo = new JLabel("PRODUCTOS POR CATEGORIA");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 16));
		JLabel descripcion = new JLabel(
				"A continuación encontrará la información básica de los productos de acuerdo a su categoria");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		panel2.add(titulo);
		panel2.add(descripcion);

		// HashMap<Integer, Producto> productos =
		// InicializacionAplicacion.usuarioActivo.getCatalogo();

		String[] nombreColumnas = { "Codigo", "Nombre", "Categoría", "Precio", "Cantidad", "N°Reseñas" };
		int contador = 0;
		for (Map.Entry<Integer, Producto> entry : Cuenta.getCatalogo().entrySet()) {
			Producto prod = entry.getValue();
			if (prod.getCategoria().equals(seleccion)) {
				contador++;
			}
			System.out.println(contador);
		}
		Object[][] datos = new Object[contador][nombreColumnas.length];
		int contador2 = 0;

		for (Map.Entry<Integer, Producto> producto : Cuenta.getCatalogo().entrySet()) {
			Producto item = producto.getValue();
			if (item.getCategoria().equals(seleccion)) {

				datos[contador2][0] = item.getId();// codigo
				datos[contador2][1] = item.getNombreProducto();// nombre
				datos[contador2][2] = item.getCategoria();// categoria
				datos[contador2][3] = item.getPrecio();
				datos[contador2][4] = item.getCantidad();
				datos[contador2][5] = item.getResenas().size();

				contador2++;
			}
		}
		tabla = new JTable(new tablaModelo(nombreColumnas, datos));
		tabla.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tabla);
		this.setMinimumSize(new Dimension(800, 300));
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.NORTH);

	}

	public void lanzar() {
		this.setTitle("Busqueda de productos por categoria");
		getDefaultCloseOperation();
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true);
	}
}
