package uiMain.vista.Cuenta.Vendedor;

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
import java.awt.BorderLayout;
import java.awt.Container;

import control.ControlMostrarResenas;
import control.Cuenta.Vendedor.ControlCambiarPrecio;
import control.Cuenta.Vendedor.ControlEliminarProdCatalogo;
import control.Cuenta.Vendedor.ControlModificarCantidad;
import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaBotonRenderizador;
import uiMain.vista.tabla.tablaModelo;

public class PanelVerProductos extends JFrame {
	
	Vendedor usuario = (Vendedor) InicializacionAplicacion.usuarioActivo;
	JTable tabla;
	
	public PanelVerProductos(){
		
		Container panel = this.getContentPane();
		panel.setLayout(new BorderLayout(7, 20));
		
		JLabel titulo = new JLabel("PRODUCTOS POR CATEGORIA");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 16));
		JLabel descripcion = new JLabel("A continuación encontrará la información básica de los productos que ha subido con anterioridad, puede modificar la cantidad existente, el precio o eliminarlo del catalogo");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		panel2.add(titulo);
		panel2.add(descripcion);
		
		HashMap<Integer, Producto> productos = usuario.verProductos();
		String nombreBoton1 = "Cambiar precio";
		String nombreBoton2 = "Cambiar cantidad";
		String nombreBoton3 = "Eliminar";
		String nombreBoton4 = "Ver reseñas";
		String [] nombreColumnas = {"Codigo", "Nombre","Categoría", "Precio", "Cantidad", "N°Reseñas",nombreBoton1,nombreBoton2,nombreBoton3,nombreBoton4};
		Object [][] datos = new Object [productos.size()][nombreColumnas.length];
		int contador = 0;
		
		for(Map.Entry<Integer, Producto> producto : productos.entrySet()) {
			Producto item = producto.getValue();
			String ac =String.valueOf(item.getId());
			
			//botones cambiar precio, eliminar
			JButton boton1 = new JButton(nombreBoton1);
			boton1.setActionCommand(ac);
			boton1.addActionListener(new ControlCambiarPrecio());
			JButton boton2 = new JButton(nombreBoton2);
			boton2.setActionCommand(ac);
			boton2.addActionListener(new ControlModificarCantidad());
			JButton boton3 = new JButton(nombreBoton3);
			boton3.setActionCommand(ac);
			boton3.addActionListener(new ControlEliminarProdCatalogo());
			JButton boton4 = new JButton(nombreBoton4);
			boton4.setActionCommand(ac);
			boton4.addActionListener(new ControlMostrarResenas());
			
			datos[contador][0] = item.getId();// codigo
			datos[contador][1] = item.getNombreProducto();// nombre
			datos[contador][2] = item.getCategoria();// categoria
			datos[contador][3] = item.getPrecio();
			datos[contador][4] = item.getCantidad();
			datos[contador][5] = item.getResenas().size();
			datos[contador][6] = boton1;
			datos[contador][7] = boton2;
			datos[contador][8] = boton3;
			datos[contador][9] = boton4;

			contador++;
		}
		tabla = new JTable(new tablaModelo(nombreColumnas,datos)); 
		tabla.setFillsViewportHeight(true);
		TableCellRenderer buttonRenderer = new tablaBotonRenderizador();
	    tabla.getColumn(nombreBoton1).setCellRenderer(buttonRenderer);
	    tabla.getColumn(nombreBoton2).setCellRenderer(buttonRenderer);
	    tabla.getColumn(nombreBoton3).setCellRenderer(buttonRenderer);
	    tabla.getColumn(nombreBoton4).setCellRenderer(buttonRenderer);	    
	    tabla.addMouseListener(new tablaBotonOidorMouse(tabla));
	    
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.setMinimumSize(new Dimension(1100, 300)); 
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.NORTH);

	}
	public void lanzar() {
		this.setTitle("Catálogo productos vendedor "+usuario.getNombre());
		getDefaultCloseOperation();
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true); 
	}
}
