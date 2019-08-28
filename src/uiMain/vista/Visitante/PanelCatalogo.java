package uiMain.vista.Visitante;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import control.ControlMostrarResenas;
import control.Cuenta.Comprador.ControlAgregarACarrito;
import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaBotonRenderizador;
import uiMain.vista.tabla.tablaModelo;

public class PanelCatalogo extends JFrame {

	/*
	 * Propósito: Se encarga de la parte visual del Catalogo
	 */

	JTable tabla;

	public PanelCatalogo() {

		Container panel = this.getContentPane();
		panel.setLayout(new BorderLayout(7, 20));

		JLabel titulo = new JLabel("PRODUCTOS");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 16));
		JLabel descripcion = new JLabel(
				"A continuación encontrará la información" + " básica de los productos disponibles en el catálogo");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		panel2.add(titulo);
		panel2.add(descripcion);

		HashMap<Integer, Producto> Catalogo = Cuenta.getCatalogo();
		String nombre_boton1 = "Ver Reseñas";
		String nombre_boton2 = "Agregar a Carrito";
		String[] nombreColumnas1 = { "Codigo", "Nombre", "Categoría", "Precio", "Cantidad", "N°Reseñas", "Vendedor",
				nombre_boton1 };
		String[] nombreColumnas2 = { "Codigo", "Nombre", "Categoría", "Precio", "Cantidad", "N°Reseñas", "Vendedor",
				nombre_boton1, nombre_boton2 };
		Object[][] datos1 = new Object[Catalogo.size()][nombreColumnas1.length];
		Object[][] datos2 = new Object[Catalogo.size()][nombreColumnas2.length];
		int contador1 = 0;

		for (Map.Entry<Integer, Producto> producto : Catalogo.entrySet()) {
			Producto it = producto.getValue();
			String cod = String.valueOf(it.getId());

			JButton boton1 = new JButton(nombre_boton1);
			if (InicializacionAplicacion.usuarioActivo.getMenuDeConsola().buscarOpcionDeMenu(new ControlMostrarResenas())) {
				boton1.addActionListener(new ControlMostrarResenas());
				boton1.setActionCommand(cod);
			}

			JButton boton2 = new JButton(nombre_boton2);
			if (InicializacionAplicacion.usuarioActivo.getMenuDeConsola().buscarOpcionDeMenu(new ControlAgregarACarrito())) {
				boton2.addActionListener(new ControlAgregarACarrito());
				boton2.setActionCommand(cod);
			}

			datos1[contador1][0] = it.getId();// codigo
			datos1[contador1][1] = it.getNombreProducto();// nombre
			datos1[contador1][2] = it.getCategoria();// categoria
			datos1[contador1][3] = it.getPrecio();
			datos1[contador1][4] = it.getCantidad();
			datos1[contador1][5] = it.getResenas().size();
			datos1[contador1][6] = it.getVendedor().getNombre();
			datos1[contador1][7] = boton1;

			datos2[contador1][0] = it.getId();// codigo
			datos2[contador1][1] = it.getNombreProducto();// nombre
			datos2[contador1][2] = it.getCategoria();// categoria
			datos2[contador1][3] = it.getPrecio();
			datos2[contador1][4] = it.getCantidad();
			datos2[contador1][5] = it.getResenas().size();
			datos2[contador1][6] = it.getVendedor().getNombre();
			datos2[contador1][7] = boton1;
			datos2[contador1][8] = boton2;

			contador1++;
		}
		if (InicializacionAplicacion.usuarioActivo instanceof Visitante ||
				InicializacionAplicacion.usuarioActivo instanceof Vendedor) {
			tabla = new JTable(new tablaModelo(nombreColumnas1, datos1));
			tabla.setFillsViewportHeight(true);
			TableCellRenderer buttonRenderer = new tablaBotonRenderizador();
			tabla.getColumn(nombre_boton1).setCellRenderer(buttonRenderer);

		} else if (InicializacionAplicacion.usuarioActivo instanceof Comprador) {
			tabla = new JTable(new tablaModelo(nombreColumnas2, datos2));
			tabla.setFillsViewportHeight(true);
			TableCellRenderer buttonRenderer = new tablaBotonRenderizador();
			tabla.getColumn(nombre_boton1).setCellRenderer(buttonRenderer);
			tabla.getColumn(nombre_boton2).setCellRenderer(buttonRenderer);
		}

		tabla.addMouseListener(new tablaBotonOidorMouse(tabla));
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.setMinimumSize(new Dimension(1000, 300));
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.NORTH);

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
