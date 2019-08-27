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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaModelo;

public class PanelCatalogoGeneral extends JFrame {

	Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
	JTable tabla;

	public PanelCatalogoGeneral() {

		Container panel = this.getContentPane();
		panel.setLayout(new BorderLayout(7, 20));

		JLabel titulo = new JLabel("PRODUCTOS");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 16));
		JLabel descripcion = new JLabel("A continuación encontrará la información"
				+ " básica de los productos disponibles en el catálogo");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		panel2.add(titulo);
		panel2.add(descripcion);

		HashMap<Integer, Producto> Catalogo = usuario.getCatalogo();
		String[] nombreColumnas = { "Codigo", "Nombre", "Categoría", "Precio", "Cantidad", "N°Reseñas", "Vendedor" };
		Object[][] datos = new Object[Catalogo.size()][nombreColumnas.length];
		int contador = 0;

		for (Map.Entry<Integer, Producto> producto : Catalogo.entrySet()) {
			Producto item = producto.getValue();
			datos[contador][0] = item.getId();// codigo
			datos[contador][1] = item.getNombreProducto();// nombre
			datos[contador][2] = item.getCategoria();// categoria
			datos[contador][3] = item.getPrecio();
			datos[contador][4] = item.getCantidad();
			datos[contador][5] = item.getResenas().size();
			datos[contador][6] = item.getVendedor().getNombre();
			contador++;
		}
		tabla = new JTable(new tablaModelo(nombreColumnas, datos));
		tabla.setFillsViewportHeight(true);
		tabla.addMouseListener(new tablaBotonOidorMouse(tabla));
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.setMinimumSize(new Dimension(1100, 300));
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.NORTH);
		this.setMinimumSize(new Dimension(800, 300));

	}

	public void lanzar() {
		this.setTitle("Catálogo");
		getDefaultCloseOperation();
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true);
	}
}
